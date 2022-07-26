package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{
    @Test
    public void searchCurrentMounts(){
        app.search().searchCurrentMounth("Tel Aviv","7/28/2022","7/27/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takeScreenshots("C:/Users/Dmitrii/Desktop/QA34/IlCarro_Test_Nikonov/IlCarro_Test_Nikonov/src/test/screenshots/screen2.png");
    }
    @Test
    public void searchCurrentYear(){
        app.search().searchCurrentYear("Jerusalem","8/30/2022","9/2/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
        app.search().takeScreenshots("C:/Users/Dmitrii/Desktop/QA34/IlCarro_Test_Nikonov/IlCarro_Test_Nikonov/src/test/screenshots/screen3.png");
    }
    @Test
    public void searchCurrentYearLocalDate(){
        app.search().searchCurrentYearLocalDate("Haifa","8/10/2022","10/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
        app.search().takeScreenshots("C:/Users/Dmitrii/Desktop/QA34/IlCarro_Test_Nikonov/IlCarro_Test_Nikonov/src/test/screenshots/screen4.png");
    }

    @Test
    public void searchAnyPeriod(){
        app.search().searchAnyPeriodLocalDate2("Jerusalem","6/30/2023","7/12/2023");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takeScreenshots("C:/Users/Dmitrii/Desktop/QA34/IlCarro_Test_Nikonov/IlCarro_Test_Nikonov/src/test/screenshots/screen5.png");
    }
    @Test
    public void searchPeriodPastNegative(){
        app.search().searchPeriodPast("Eilat","2/01/2022","4/20/2022");
        app.search().submitWithoutWait();
        Assert.assertTrue(app.search().isYallaButtonNotActive());
        Assert.assertTrue(app.search().isPeriodPast());
        app.search().takeScreenshots("C:/Users/Dmitrii/Desktop/QA34/IlCarro_Test_Nikonov/IlCarro_Test_Nikonov/src/test/screenshots/screen6.png");

    }
    @AfterMethod
    public void returnToHome(){
        app.search().returnToHome();
    }
}
