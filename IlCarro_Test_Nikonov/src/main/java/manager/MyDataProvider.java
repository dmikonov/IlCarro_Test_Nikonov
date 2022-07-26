package manager;

import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> dataLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"d020797@gmail.com","Ww12345$"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
        list.add(new Object[]{"d020797@gmail.com","Ww12345$"});
        list.add(new Object[]{"d020797@gmail.com","Ww12345$"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> dataRegistration(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setName("Dor").setLastName("Fox").setEmail("dor@gmail.com").setPassword("Dd12345$")});
        list.add(new Object[]{new User().setName("Vor").setLastName("Fox").setEmail("dor1@gmail.com").setPassword("Dd12345$")});
        list.add(new Object[]{new User().setName("Zor").setLastName("Cox").setEmail("dor2@gmail.com").setPassword("Dd12345$")});
        list.add(new Object[]{new User().setName("Nor").setLastName("Fox").setEmail("dor3@gmail.com").setPassword("Dd12345$")});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:/Users/Dmitrii/Desktop/QA34/IlCarro_Test_Nikonov/IlCarro_Test_Nikonov/src/test/resources/lohin.csv.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[] {new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validCar() throws IOException {
        List<Object[]> list=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/car1.csv")));
        String line=reader.readLine();
        while (line!=null){
            String[] split=line.split(";");
            list.add(new Object[]{Car.builder()
                    .address(split[0])
                    .make(split[1])
                    .model(split[2])
                    .year(split[3])
                    .engine(split[4])
                    .fuel(split[5])
                    .gear(split[6])
                    .wD(split[7])
                    .doors(split[8])
                    .seats(split[9])
                    .clasS(split[10])
                    .fuelConsunption(split[11])
                    .carRegNumber(split[12])
                    .price(split[13])
                    .distanceIncluded(split[14])
                    .features(split[15])
                    .about(split[16])
                    .build()});
            line = reader.readLine(); }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> dataBase(){
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }
}
