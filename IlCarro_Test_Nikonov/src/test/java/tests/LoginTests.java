package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    WebDriver wd;


    @Test
    public void successlogin(){
        openLoginRegistrationForm();
        fillLoginRegistrationForm("d020797@gmail.com","Ww12345$");
        submitLogin();
    }
    @Test
    public void loginNegativeTestsWrongEmail(){
        openLoginRegistrationForm();
        fillLoginRegistrationForm("d020797gmail.com","Ww12345$");
        submitLogin();
    }


}
