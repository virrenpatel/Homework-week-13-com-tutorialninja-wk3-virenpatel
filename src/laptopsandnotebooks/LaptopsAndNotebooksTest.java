package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        // Click on Show All Laptops & Notebooks
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //Select Sort By "Price (High>Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        Select sortBy = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        sortBy.selectByValue("http://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        // Verify the Product price will arrange in High to Low order
        verifyExpectedAndActual(By.xpath("//option[@value='http://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC']"), "Price (High > Low)");
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        //Mouse hover on Currency Tab.and click
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Currency')]"));
        // Click on £ Pound Sterling
        clickOnElement(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));
        //Click on Laptops & Notebooks Menu
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        // Click on Show All Laptops & Notebooks
        Thread.sleep(3000);
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //Select Sort By "Price (High>Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        Select sortBy = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        sortBy.selectByValue("http://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        //Select Product “MacBook”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
        // Verify the text “MacBook”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'MacBook')]"), "MacBook");
        // Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyExpectedAndActual(By.xpath("//div[@class = 'alert alert-success alert-dismissible']"), "Success: You have added MacBook to your shopping cart!\n" +
                "×");
        Thread.sleep(2000);
        //Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //Verify the text "Shopping Cart"
        verifyExpectedAndActual(By.xpath("//a[contains(text(),'Shopping Cart')]"), "Shopping Cart");
        //Verify the Product name "MacBook"
        verifyExpectedAndActual(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "MacBook");
        Thread.sleep(2000);
        //Change Quantity "2"
        clearText(By.xpath("//input[@value = '1']"));
//        Actions actions1 = new Actions(driver);
//        WebElement quantity = driver.findElement(By.xpath("//input[@value = '1']"));
//        quantity.clear();
        sendTextToElement(By.xpath("//input[@value = '1']"), "2");
        //Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));
        //Verify the message “Success: You have modified your shopping cart!”
        verifyExpectedAndActual(By.xpath("//div[@class = 'alert alert-success alert-dismissible']"), "Success: You have modified your shopping cart!\n" +
                "×");
        //Verify the Total £737.45
        verifyExpectedAndActual(By.xpath("//tbody/tr[1]/td[6]"), "£737.45");
        //Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        Thread.sleep(2000);
        //Verify the text “Checkout”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Checkout')]"), "Checkout");
        //Verify the Text “New Customer”
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'New Customer')]"), "New Customer");
        //Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value = 'guest']"));
        //Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id = 'input-payment-firstname']"), "Manan");
        sendTextToElement(By.xpath("//input[@id = 'input-payment-lastname']"), "Shah");
        sendTextToElement(By.xpath("//input[@id = 'input-payment-email']"), "test123@gmail.com");
        sendTextToElement(By.xpath("//input[@id = 'input-payment-telephone']"), "0203456789");
        sendTextToElement(By.xpath("//input[@id = 'input-payment-address-1']"), "21 Luton Road");
        sendTextToElement(By.xpath("//input[@id = 'input-payment-city']"), "Luton");
        sendTextToElement(By.xpath("//input[@id = 'input-payment-postcode']"), "HA8 9HU");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "Kent");
        Thread.sleep(2000);
        // Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        //Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"), "Please Confirm Delivery date.");
        //Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name= 'agree']"));
        //Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //Verify the message “Warning: Payment method required!”
        verifyExpectedAndActual(By.xpath("//div[@class= 'alert alert-danger alert-dismissible']"), "Warning: Payment method required!\n" +
                "×");
    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}