package testSuite_saucedemo_4;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest_1  extends BaseTest {
    String url = "https://www.saucedemo.com/";

    @Before
    public void setUP(){
        openBrowser(url);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid(){
        //span[@class='title']
        //input[@id='user-name']
        //input[@id='password']
        //input[@id='login-button']

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String expectedMessage = "Products";
        String actualMessage = driver.findElement(By.xpath("//span[@class='title']")).getText();
        System.out.println("------expectedMessage------"+expectedMessage);
        System.out.println("------actualMessage------"+actualMessage);
        Assert.assertEquals("Mahesh",expectedMessage,actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        List<WebElement> list_products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int number_products = list_products.size();
        System.out.println("Verifying login is the number of products: " + number_products);
        Assert.assertEquals(number_products,6);
    }

    @After
    public void close(){
        closeBrowser();
    }
}
