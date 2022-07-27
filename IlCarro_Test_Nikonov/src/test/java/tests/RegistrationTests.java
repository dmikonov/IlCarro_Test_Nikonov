package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test(dataProvider = "dataRegistration",dataProviderClass = MyDataProvider.class, enabled = false)
    public void registrationSuccess(User user){
        //int i =(int) (System.currentTimeMillis()/1000)%3600;
       // User user = new User().setName("Lis").setLastName("Snow").setEmail("fox"+i+"@mail.com").setPassword("Ff12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyJS();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Registered");
    }
    @Test(groups = {"web"})
    public void registrationSuccess2(){
        int i =(int) (System.currentTimeMillis()/1000)%3600;
        User user = new User().setName("Lis").setLastName("Snow").setEmail("fox"+i+"@mail.com").setPassword("Ff12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyJS();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Registered");
    }
    @Test
    public void registrationWrongPasswordFormatSize(){
        User user = new User()
                .setName("Zoa")
                .setLastName("DSnow")
                .setEmail("zoa@gmail.com")
                .setPassword("zoa");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().pause(500);
        app.getHelperUser().checkPolicyJS();
        Assert.assertTrue(app.getHelperUser().isErrorPasswordFormatDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorPasswordSizeDisplayed());
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }
    @AfterMethod(alwaysRun = true)
    public void postCondition(){
        app.getHelperUser().clickOk();
    }
}