package pl.pjatk.CarRentalApplication;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarStorage {

    private final List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }

    public CarStorage() {
        carList.add(new Car("Renault", "Clio III", "abcde123", CarSegment.CITY));
        carList.add(new Car("Mercedes", "CLS", "Merc1234", CarSegment.PREMIUM));
        carList.add(new Car("Ford", "Focus", "ford1234", CarSegment.STANDARD));
        carList.add(new Car("Renault", "Megane", "rena12345", CarSegment.STANDARD));
        carList.add(new Car("Renault", "Clio III", "arenaa23", CarSegment.CITY));
    }

    public Car findByVin(String vin){
        for (Car car: carList){
            if (car.getVin().equals(vin)){
                return car;
            }
        }
        return null;
    }
}
