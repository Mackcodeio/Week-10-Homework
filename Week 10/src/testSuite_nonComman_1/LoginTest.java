package testSuite_nonComman_1;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        WebElement welcomeMessage = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        String actualMessage = welcomeMessage.getText();
        String expectedMessage = "Welcome, Please Sign In!";
        Assert.assertEquals("Verifying WelcomeMessage",expectedMessage,actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        String expectedMessage = "Log out";

        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        WebElement email_id = driver.findElement(By.id("Email"));
        email_id.sendKeys("maheshhirpara.uk@gmail.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Mahesh0712");

        WebElement loginButton = driver.findElement(By.linkText("Log in"));
        loginButton.click();

        //String actualMessage = driver.findElement(By.id("ico-logout")).getText();
        //Assert.assertEquals("Verifying LogoutMessage",expectedMessage,actualMessage);

    }

    @Test
    public void verifyTheErrorMessage() throws InstantiationError {
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        WebElement email_id = driver.findElement(By.id("Email"));
        email_id.sendKeys("maheshhirpara.uk13@gmail.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Mahesh07@!ww");

        WebElement loginButton = driver.findElement(By.linkText("Log in"));
        loginButton.click();


        WebElement welcomeMessage=driver.findElement(By.xpath("//h1[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]"));

        System.out.println("welcomeMessage: " +welcomeMessage);

        String actualMessage = welcomeMessage.getText();
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.";
        Assert.assertEquals("Verifying WelcomeMessage",expectedMessage,actualMessage);
    }
    @After
    public void closeDown(){
        closeBrowser();
    }
}
