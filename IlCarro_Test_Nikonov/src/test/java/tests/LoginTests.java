package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in");
    }

    public void loginASuccess2(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("d020797@gmail.com","Ww12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in");
    }
    @Test
    public void loginNegativeTestsWrongEmail(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("d020877@gmail.com","Ww12345$");
        app.getHelperUser().submit();
        Assert.assertNotEquals(app.getHelperUser().getMessage(),"Logged in");
    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOk();
    }




}
