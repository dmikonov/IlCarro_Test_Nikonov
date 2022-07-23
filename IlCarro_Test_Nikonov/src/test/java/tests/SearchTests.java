package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{
    @Test
    public void searchCurrentMounts(){
        app.search().searchCurrentMounth("Tev Aviv","7/28/2022","7/27/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }
    @Test
    public void searchCurrentYear(){
        app.search().searchCurrentYear("Tel Aviv","7/30/2022","12/2/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
    }
    @Test
    public void searchCurrentYearLocalDate(){
        app.search().searchCurrentYearLocalDate("Tel Aviv","8/10/2022","12/02/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
    }

    @Test
    public void searchAnyPeriod(){
        app.search().searchAnyPeriodLocalDate2("Tel Aviv","8/15/2022","5/25/2023");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
    }
    @Test
    public void searchPeriodPastNegative(){
        app.search().searchPeriodPast("Tel Aviv","2/01/2022","4/20/2022");
        app.search().submitWithoutWait();
        Assert.assertFalse(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertTrue(app.search().isPeriodPast());

    }
    @AfterMethod
    public void returnToHome(){
        app.search().returnToHome();
    }
}
