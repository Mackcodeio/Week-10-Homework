package testSuite_nonComman_1;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenuTest extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";
    String actualMessage;
    String exeptedMessage;

    @Before
    public void setUp(){
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']"));
        List<WebElement> links = driver.findElements(By.tagName("li"));
        int numberOfLinks = links.size();
        System.out.println("numberOfLinks : "+numberOfLinks);
        for(int i=1; i<numberOfLinks; i++){

            if(i==1){
                actualMessage = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li[1]//a[@href=\"/computers\"]")).getText();
                exeptedMessage = "Computers";
                System.out.println("I am in "+actualMessage);
                Assert.assertEquals("Computers",exeptedMessage,actualMessage);
            } else if (i==2) {
                actualMessage = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li[2]//a[@href=\"/electronics\"]")).getText();
                exeptedMessage = "Electronics";
                System.out.println("I am in "+actualMessage);
                Assert.assertEquals("Electronics",exeptedMessage,actualMessage);
            } else if (i==3) {
                actualMessage = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li[3]//a[@href=\"/apparel\"]")).getText();
                exeptedMessage = "Apparel";
                System.out.println("I am in "+actualMessage);
                Assert.assertEquals("Apparel",exeptedMessage,actualMessage);
                //Assert.assertEquals("Apparel",exeptedMessage,actualMessage);
            } else if (i==4) {
                actualMessage = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li[4]//a[@href=\"/digital-downloads\"]")).getText();
                exeptedMessage = "Digital downloads";
                System.out.println("I am in "+actualMessage);
                Assert.assertEquals("Digital downloads",exeptedMessage,actualMessage);
            } else if (i==5) {
                actualMessage = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li[5]//a[@href=\"/books\"]")).getText();
                exeptedMessage = "Books";
                System.out.println("I am in "+actualMessage);
                Assert.assertEquals("Books",exeptedMessage,actualMessage);
            } else if (i==6) {
                actualMessage = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li[6]//a[@href=\"/jewelry\"]")).getText();
                exeptedMessage = "Jewelry";
                System.out.println("I am in "+actualMessage);
                Assert.assertEquals("Jewelry",exeptedMessage,actualMessage);
            } else if (i==7) {
                actualMessage = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li[7]//a[@href=\"/gift-cards\"]")).getText();
                exeptedMessage = "Gift Cards";
                System.out.println("I am in "+actualMessage);
                Assert.assertEquals("Gift Cards",exeptedMessage,actualMessage);
            }
        }

    }

    @After
    public void close(){
        closeBrowser();
    }
}
