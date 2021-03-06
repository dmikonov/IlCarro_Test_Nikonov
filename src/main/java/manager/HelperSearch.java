package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase{


    public boolean isPeriodPast(){
        pause(2000);
        return isElementPresent(By.xpath("//div[@class='ng-star-inserted']"));
    }

    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMounth(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodCurrentMonths(dataFrom,dataTo);
    }

    private void selectPeriodCurrentMonths(String dataFrom, String dataTo) {
        clearPeriod();
        click(By.cssSelector("#dates"));
        String[] from = dataFrom.split("/"); //[7],[25],[2022]
        String locator = "//div[text()=' " + from[1]+" ']";
        click(By.xpath(locator));
        String[] to = dataTo.split("/");
        String locator2 = String.format("//div[text() = ' %s ']",to[1]);
        click(By.xpath(locator2));
    }

    private void clearPeriod() {
        WebElement el = wd.findElement(By.cssSelector("#dates"));
        String osName = System.getProperty("os.name");
        System.out.println(osName);
        if(osName.startsWith("Mac")){
            el.sendKeys(Keys.COMMAND,"a");
        }else {
            el.sendKeys(Keys.CONTROL,"a");
        }
        el.sendKeys(Keys.DELETE);
    }

    private void typeCity(String city) {
        new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.id("city"))));
        type(By.id("city"),city);
        pause(500);
        click(By.cssSelector(".pac-item"));
    }
    public void searchCurrentYear(String city, String dataFrom, String dataTo) {
        clearPeriod();
        typeCity(city);
        pause(2000);
        selectPeriodCurrentYear(dataFrom,dataTo);
    }

    public void selectPeriodCurrentYear(String dataFrom, String dataTo) {
        clearPeriod();
        click(By.cssSelector("#dates"));
        String now = "7/18/2022";
        String[] nowA = now.split("/");
        String[] from = dataFrom.split("/");
        String[] to = dataTo.split("/");
        if(!nowA[0].equals(from[0])) {
            int diffMonthNow = Integer.parseInt(from[0]) - Integer.parseInt(nowA[0]);
            clickByNextMonth(diffMonthNow);
        }
        String locator = String.format("//div[text()=' %s ']",from[1]);
        click(By.xpath(locator));
        if(Integer.parseInt(from[0])!=Integer.parseInt(to[0])) {
            int diffMonthFrom = Integer.parseInt(to[0]) - Integer.parseInt(from[0]);
            clickByNextMonth(diffMonthFrom);
        }
        String locator1 = String.format("//div[text()=' %s ']",to[1]);
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

    public boolean isPageResultAppeared(){
        String currentURL = wd.getCurrentUrl();
        System.out.println(currentURL);
        currentURL.contains("results");
        return currentURL.startsWith("https://ilcarro-1578153671498.web.app/search/results");
    }

    public void returnToHome() {
        click(By.cssSelector(".logo"));
    }


    public void searchCurrentYearLocalDate(String city, String dataFrom, String dataTo) {
        typeCity(city);
        click(By.cssSelector("#dates"));
        clearPeriod();
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo,DateTimeFormatter.ofPattern("M/d/yyyy"));
        if(now.getMonthValue()!= from.getMonthValue()){
            int count = from.getMonthValue()- now.getMonthValue();
            clickByNextMonth(count);
        }
        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));
        if(from.getMonthValue()!=to.getMonthValue()){
            int count = to.getMonthValue()- from.getMonthValue();
            clickByNextMonth(count);
        }
        locator = String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));
    }

    public void searchAnyPeriodLocalDate2(String city, String dataFrom, String dataTo) {
        typeCity(city);
        click(By.id("dates"));
        clearPeriod();
        LocalDate now = LocalDate.now();
        LocalDate from= LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/dd/yyyy"));
        LocalDate to = LocalDate.parse(dataTo,DateTimeFormatter.ofPattern("M/dd/yyyy"));
        int diffMonth = from.getYear()-now.getYear()
                ==0 ? from.getMonthValue() -now.getMonthValue() : 12-now.getMonthValue()+ from.getMonthValue();

        clickByNextMonth(diffMonth);
        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));

        diffMonth= to.getYear()-from.getYear()
                ==0  ?to.getMonthValue()-from.getMonthValue(): 12-from.getMonthValue()+to.getMonthValue();

        clickByNextMonth(diffMonth);
        locator=String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));
    }

    public void searchAnyPeriodLocalDate(String city, String dataFrom, String dataTo) {
        typeCity(city);
        LocalDate now = LocalDate.now();
        LocalDate from= LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo,DateTimeFormatter.ofPattern("M/d/yyyy"));
        click(By.id("dates"));
        // "8/10/2022", "3/20/2023"
        int diffYear;
        int diffMonth;

        diffYear=from.getYear()-now.getYear();
        if(diffYear==0){
            diffMonth= from.getMonthValue()-now.getMonthValue(); /// 8-7 =1
        }else {
            diffMonth= 12-now.getMonthValue()+from.getMonthValue(); //12-7+3
        }
        clickByNextMonth(diffMonth);
        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));

        ///**************
        diffYear=to.getYear()-from.getYear();

        if(diffYear==0){
            diffMonth = to.getMonthValue()-from.getMonthValue();
        }else {
            diffMonth= 12-from.getMonthValue()+to.getMonthValue();
        }
        clickByNextMonth(diffMonth);
        locator=String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));

    }

    public void searchPeriodPast(String city, String dataFrom, String dataTo) {
        clearPeriod();
        typeCity(city);
        typePeriodPast(dataFrom,dataTo);
    }

    private void typePeriodPast(String dataFrom, String dataTo) {
        pause(2000);
        type(By.cssSelector("#dates"),dataFrom + " - "+dataTo);
        click(By.cssSelector(".cdk-overlay-container"));
    }
}
