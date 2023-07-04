package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

        sendTextToElement(By.id("user-name"),"standard_user");
        sendTextToElement(By.id("password"),"secret_sauce");
        clickOnElement(By.id("login-button"));

        String actual = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        String expected = "Products";
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        sendTextToElement(By.id("user-name"),"standard_user");
        sendTextToElement(By.id("password"),"secret_sauce");
        clickOnElement(By.id("login-button"));

        List<WebElement> items = driver.findElements(By.xpath("//div[@class = 'inventory_list']//div[@class = 'inventory_item']"));
        System.out.println("Total Products Displayed on Page : "+items.size());

    }

    @After
    public void tearDown() {

        closeBrowser();
    }

}
