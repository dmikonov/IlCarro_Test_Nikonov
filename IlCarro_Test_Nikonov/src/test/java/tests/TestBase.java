package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;


public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);
   protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));
    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        app.init();
    }
    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }
    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method m){
        logger.info("Start method with name ->>" +m.getName());
    }

}
