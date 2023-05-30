package testsuite;

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
    public void userSholdRegisterAccountSuccessfully(){
        WebElement registerLink = driver.findElement(By.className("ico-register"));
        registerLink.click();

        WebElement gender = driver.findElement(By.className("forcheckbox"));
        gender.click();

        // FirstName
        WebElement emailField = driver.findElement(By.id("FirstName"));
        emailField.sendKeys("Mahesh");

        // SecondName
        WebElement lastName=driver.findElement(By.name("LastName"));
        lastName.sendKeys("Hirpara");


        Select day = new Select(driver.findElement(By.xpath("//*[@name='DateOfBirthDay']")));
        day.selectByIndex(6);
        System.out.println("--------day-------"+day);



//        WebElement month=driver.findElement(By.name("DateOfBirthMonth"));
//        day.sendKeys("12");
//
//        WebElement year=driver.findElement(By.name("DateOfBirthYear"));
//        day.sendKeys("1993");
    }

    @After
    public void close(){
        closeBrowser();
    }
}
