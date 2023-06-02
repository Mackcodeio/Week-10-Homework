package testSuite_courses_5;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest_1 extends BaseTest {

    String url = "https://courses.ultimateqa.com/";
    @Before
    public void setUp(){
        openBrowser(url);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
        String actualMessage = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        String expectedMessage = "Welcome Back!";
        Assert.assertEquals("Verifying WelcomeMessage",expectedMessage,actualMessage);
    }

    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("test1");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String actualMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        String expectedMessage = "Invalid email or password.";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @After
    public void close(){
        closeBrowser();
    }
}
