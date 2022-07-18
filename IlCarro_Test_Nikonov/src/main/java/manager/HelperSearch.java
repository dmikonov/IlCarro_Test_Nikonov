package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMounth(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodCurrentMonths(dataFrom,dataTo);
    }

    private void selectPeriodCurrentMonths(String dataFrom, String dataTo) {
        click(By.id("dates"));
        String[] from = dataFrom.split("/"); //[7],[25],[2022]
        String locator = "//div[text()=' " + from[1]+" ']";
        click(By.xpath(locator));
        String[] to = dataTo.split("/");
        String locator2 = String.format("//div[text() = ' %s ']",to[1]);
        click(By.xpath(locator2));
    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector(".pac-item"));
        pause(500);
    }

    public void searchCurrentYear(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodCurrentYear(dataFrom,dataTo);
    }

    public void selectPeriodCurrentYear(String dataFrom, String dataTo) {
        click(By.id("dates"));
        String now = "7/18/2022";
        String[] Now = now.split("/");
        String[] From = dataFrom.split("/");
        String[] To = dataTo.split("/");
        int diffMonthNow = Integer.parseInt(From[0])-Integer.parseInt(Now[0]);
        clickByNextMonth(diffMonthNow);
        String locator = String.format("//div[text()=' %s ']",From[1]);
        click(By.xpath(locator));
        int diffMonthFrom = Integer.parseInt(To[0])-Integer.parseInt(From[0]);
        clickByNextMonth(diffMonthFrom);
        String locator1 = String.format("//div[text()=' %s ']",To[1]);
        click(By.xpath(locator1));
    }

    private void clickByNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".cars-container"));
    }
}
