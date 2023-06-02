package testSuite_opensource_2;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest_1 extends BaseTest {

    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    @Before
    public void setUp(){
        openBrowser(url);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expectedMessage = "Dashboard";
        String actualMessage = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        System.out.println(actualMessage);

        Assert.assertEquals("Test",expectedMessage,actualMessage);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        String expectedMessage = "Forgot your password?";
        String actualMessage = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).getText();
        Assert.assertEquals("Is equal",expectedMessage,actualMessage);
        driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();

    }

    @After
    public void close(){
        closeBrowser();
    }
}
