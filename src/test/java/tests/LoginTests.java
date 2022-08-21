package tests;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test(priority = 0, description = "Valid Login Scenario with username and password.")
    public void invalidLoginTest_ValidUserNameValidPassword(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Valid Login Scenario with username and password.");

       loginpage.goToLoginPage().loginToApp("standard_user", "secret_sauce");
       
    }

    @Test(priority = 1, description = "Invalid Login Scenario with empty username and password.",dataProvider = "invalid data")
    public void invalidLoginTest_EmptyUserEmptyPassword(String username,String password,String errorMsg) {
        //ExtentReports Description
        startTest("Invalid Login Scenario ","Invalid Login Scenario with empty username and password.");

        loginpage.goToLoginPage().loginToApp(username,password).verifyErrorMsg(errorMsg);
      }
    
    @DataProvider(name="invalid data")
    public String[][] getData(){
    	return  new String[][]{{"","secretsauce","Epic sadface: Username is required"}
    							,{"standard_user","","Epic sadface: Password is required"}};
    }
}