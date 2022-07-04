package manager;

import models.User;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        wd.findElement(By.cssSelector("a[href='/login?url=%2Fsearch']")).click();
    }

    public void fillLoginForm(String email, String password){
        type(By.cssSelector("#email"),email);
        type(By.cssSelector("#password"),password);
    }

    public boolean isLogged() {
        return Element(By.cssSelector("button[type='button']"));
    }

    public void logout() {
        click(By.cssSelector("button[type='button']"));
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(@NotNull User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

   /* public void checkPolicy() {
        //click(By.id("terms-of-use"));
        click(By.cssSelector("label[for='terms-of-use']"));
    }*/

    public void checkPolicyXY() {

        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = label.getRect();
        int xOffSet=rect.getWidth()/2;
        int yOffSet = rect.getHeight()/2;

        Actions actions = new Actions(wd);
        actions.moveToElement(label).release().perform();
        actions.moveByOffset(-xOffSet,-yOffSet).click().release().perform();
    }

    public void clickOk() {
        click(By.xpath("//button[text()='Ok']"));
    }
}
