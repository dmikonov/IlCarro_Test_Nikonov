package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


public class MyListener implements WebDriverListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);
    @Override
    public void beforeFindElements(WebElement element, By locator) {
        WebDriverListener.super.beforeFindElements(element, locator);
        logger.info("WebDriver start find element -->" + locator);
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.info("The name of method with error ->>>" + method.getName());
        logger.info("We have a problem" + e.getTargetException().fillInStackTrace());
    }

    @Override
    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(element, locator, result);
        logger.info("WebDriver start found element by locator -->" + locator);
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
        logger.info("WebDriver starts find element ---> " + locator);
    }


}
