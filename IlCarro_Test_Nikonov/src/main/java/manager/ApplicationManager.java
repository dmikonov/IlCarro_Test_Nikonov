package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class ApplicationManager {


    WebDriver wd;
    HelperUser helperUser;
    HelperCar car;
    HelperSearch search;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init(){

        wd=new ChromeDriver();
        WebDriverListener listener = new MyListener();
        wd = new EventFiringDecorator(listener).decorate(wd);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        logger.info("Current URL ---> " + wd.getCurrentUrl());
        helperUser=new HelperUser(wd);
        search = new HelperSearch(wd);
        car = new HelperCar(wd);
    }

    public void stop(){
        wd.quit();
    }


    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperCar car() {
        return car;
    }

    public HelperSearch search() {
        return search;
    }
}