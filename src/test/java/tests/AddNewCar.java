package tests;

import manager.MyDataProvider;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCar extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("d020797@gmail.com").setPassword("Ww12345$"));
        }
    }
    @Test(dataProvider = "validCar",dataProviderClass = MyDataProvider.class, enabled = false)
    public void addNewCarSuccessDP(Car car){
        logger.info("Car is -> " + car.toString());
        app.car().openCarForm();
        app.car().fillCarForm(car);
        app.car().attachPhoto("C:/Users/Dmitrii/Desktop/QA34/IlCarro_Test_Nikonov/auto1.jpeg");
        app.car().submit();
        Assert.assertEquals(app.car().getMessage(),"Car added");
    }
    @Test(groups = {"web","smoke","regress"})
    public void addNewCarSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        Car car = Car.builder()
                .address("Haifa, Israel")
                .make("BMW")
                .model("M5")
                .year("2021")
                .engine("2.5")
                .fuel("Petrol")
                .gear("AT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsunption("6.5")
                .carRegNumber("22-333"+i)
                .price("65")
                .distanceIncluded("800")
                .features("type of features")
                .about("Very nice car")
                .build();
        logger.info("Car is -> " + car.toString());
        app.car().openCarForm();
        app.car().fillCarForm(car);
        app.car().attachPhoto("C:/Users/Dmitrii/Desktop/QA34/IlCarro_Test_Nikonov/IlCarro_Test_Nikonov/auto1.jpeg");
        app.car().submit();
        Assert.assertEquals(app.car().getMessage(),"Car added");
    }

    @AfterMethod(alwaysRun = true)
        public void postCondition(){
        app.car().returnToHome();
    }
}
