package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void loginASuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("d020797@gmail.com","Ww12345$");
        app.getHelperUser().submitLogin();
    }
    @Test
    public void loginNegativeTestsWrongEmail(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("d02077gmail.com","Ww12345$");
        app.getHelperUser().submitLogin();
    }



}
