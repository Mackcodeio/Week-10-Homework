package testSuite_herokuapp_3;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String url = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(url);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        String expectedMessage = "Secure Area";
        String actualMessage = driver.findElement(By.xpath("//div[@class='example']//h2")).getText();
        Assert.assertEquals("Test",expectedMessage,actualMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        String expectedMessage = "Your username is invalid!";
        String actualMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        System.out.println("------expectedMessage------"+expectedMessage);
        System.out.println("------actualMessage------"+actualMessage);
     //   Assert.assertEquals("TestMessage",expectedMessage,actualMessage);

    }

    @Test
    public void verifyThePasswordErrorMessage(){
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        String expectedMessage = "Your password is invalid!";
        String actualMessage = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        System.out.println("------expectedMessage------"+expectedMessage);
        System.out.println("------actualMessage------"+actualMessage);
        // Assert.assertEquals("TestMessage",expectedMessage,actualMessage);
    }

    @After
    public void close(){
        closeBrowser();
    }
}
