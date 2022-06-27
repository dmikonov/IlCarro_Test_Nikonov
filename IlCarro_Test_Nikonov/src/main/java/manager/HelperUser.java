package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        wd.findElement(By.cssSelector("a[href='/login?url=%2Fsearch']")).click();
    }

    public void submitLogin(){
        wd.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public void fillLoginForm(String email, String password){
        type(By.cssSelector("#email"),email);
        type(By.cssSelector("#password"),password);
    }

    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.cssSelector("button[type='button']"));
        return list.size()>0;
    }

    public void logout() {
        click(By.cssSelector("button[type='button']"));
        click(By.xpath("//a[normalize-space()='Logout']"));
    }
}
