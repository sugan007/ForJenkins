package pages;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.logs.JSErrorLogs;
import utils.logs.Log;

public class LoginPage extends BasePage {
    /**
     * Constructor
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Variables
     */
    String baseURL = "https://www.saucedemo.com/";

    /**
     * Web Elements
     */
    By userNameId                = By.id("user-name");
    By passwordId                = By.id("password");
    By loginButtonId             = By.id("login-button");
    By errorMessageXpath = By.xpath("//h3[contains(text(),'is required')]");
 
    /**
     * Page Methods
     */
    
    public LoginPage goToLoginPage() {
        Log.info("Going to Login Page..");
        driver.get(baseURL);
        return new LoginPage(driver);
    }
    
    public LoginPage loginToApp(String username, String password) {
        Log.info("Trying to login the Swag Labs.");
        writeText(userNameId, username);
        writeText(passwordId, password);
        click(loginButtonId);
        wait(3);
        return this;
    }

    
    public LoginPage verifyErrorMsg(String expectedText) {
    	Log.info("Verifying login error: "+expectedText);
        waitVisibility(errorMessageXpath);
        assertEquals(readText(errorMessageXpath), expectedText);
    	return this;
    }

    //Verify Password Condition
    public LoginPage verifyLogError() {
        Log.info("Verifying javascript login errors.");
        assertTrue(JSErrorLogs.isLoginErrorLog(driver));
        return this;
    }
}