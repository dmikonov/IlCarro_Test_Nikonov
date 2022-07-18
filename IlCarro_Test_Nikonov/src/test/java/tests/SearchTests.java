package tests;

import org.testng.Assert;
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
        app.search().searchCurrentYear("Tel Aviv","8/30/2022","12/2/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }
}
