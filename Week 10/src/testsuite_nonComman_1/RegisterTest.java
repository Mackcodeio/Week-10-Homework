package testsuite_nonComman_1;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest  extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        String expectMessage = "Register";
        WebElement registerLink = driver.findElement(By.className("ico-register"));
        String actualMessage = registerLink.getText();
        registerLink.click();

        System.out.println("on Register page actualMessage: "+actualMessage);
        Assert.assertEquals("Verifying Message",expectMessage,actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully(){
        WebElement registerLink = driver.findElement(By.className("ico-register"));
        registerLink.click();

        driver.findElement(By.xpath("//div[@class='inputs']//div[@id='gender']//span[@class='male']//input[@id='gender-male']")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Mahesh");
        driver.findElement(By.name("LastName")).sendKeys("Hirpara");
        WebElement dropDown = driver.findElement(By.xpath("//div[@class='inputs date-of-birth']"));
        Select select = new Select(dropDown);
        select.selectByValue("07");
        select.selectByValue("December");
        select.selectByValue("1993");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("test123@gmail.com");
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("coding");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123T");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123T");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        String actualMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
        String expectedMessage = "Your registration completed";
        Assert.assertEquals("Verifying WelcomeMessage", expectedMessage,actualMessage);
    }

    @After
    public void close(){
        closeBrowser();
    }
}
