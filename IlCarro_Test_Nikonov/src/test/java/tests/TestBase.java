package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver wd;
    @BeforeMethod
    public void preCondition(){
        //1. browser open
        wd=new ChromeDriver();
        //2. open link
        wd.navigate().to("https://ilcarro-1578153671498.web.app/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

    public void openLoginRegistrationForm(){
        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login?url=%2Fsearch']"));
        loginTab.click();
    }

    public void submitLogin(){
        wd.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public void fillLoginRegistrationForm(String email, String password){
        type(By.cssSelector("#email"),email);
        type(By.cssSelector("#password"),password);
    }

    public void type(By locator, String text){
        if(text!=null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
}
