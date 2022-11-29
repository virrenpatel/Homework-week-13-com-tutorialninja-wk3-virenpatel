package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    /*create method with name "selectMyAccountOptions" it has one parameter name
     "option" of type string.  This method should click on the options whatever name is passed as parameter.
     */
    public void selectMyAccountOptions(String option, By by) {
        List<WebElement> options = driver.findElements(by);
        for (WebElement name : options) {
            if (name.getText().equalsIgnoreCase(option)) {
                name.click();
                break;
            }
        }
    }

    @Test
    public void  verifyUserShouldNavigateToRegisterPageSuccessfully(){
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        // Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register",By.xpath("//a[contains(text(),'Register')]"));
        //Verify the text “Register Account”.
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Register Account')]"),"Register Account");

    }
    @Test
    public void  verifyUserShouldNavigateToLoginPageSuccessfully(){
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login",By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //Verify the text “Returning Customer”.
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Returning Customer')]"),"Returning Customer");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        // Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register",By.xpath("//a[contains(text(),'Register')]"));
        //Enter First Name
        sendTextToElement(By.xpath("//input[@name = 'firstname']"),"Manan");
        //Enter Last Name
        sendTextToElement(By.xpath("//input[@name = 'lastname']"),"Shah");
        //Enter Email
        sendTextToElement(By.xpath("//input[@name = 'email']"),"test45678@gmail.com");
        //Enter Telephone
        sendTextToElement(By.xpath("//input[@name = 'telephone']"),"020546353564");
        //Enter Password
        sendTextToElement(By.xpath("//input[@name = 'password']"),"Password23");
        //Enter Password Confirm
        sendTextToElement(By.xpath("//input[@name = 'confirm']"),"Password23");
        //Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));
        //Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name = 'agree']"));
        Thread.sleep(2000);
        //Click on Continue button
        clickOnElement(By.xpath("//input[@class = 'btn btn-primary']"));
        //Verify the message “Your Account Has Been Created!”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"),"Your Account Has Been Created!");
        //Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //Click on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout",By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]"));
        //Verify the text “Account Logout”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Account Logout')]"),"Account Logout");
        //Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException{
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login",By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"),"test45678@gmail.com");
        //Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"Password23");
        //Click on Login button
        clickOnElement(By.xpath("//input[@class = 'btn btn-primary']"));
        //Verify text “My Account”
        verifyExpectedAndActual(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"),"My Account");
        Thread.sleep(3000);
        //Click on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout",By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]"));
        //Verify the text “Account Logout”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Account Logout')]"),"Account Logout");
        //Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
