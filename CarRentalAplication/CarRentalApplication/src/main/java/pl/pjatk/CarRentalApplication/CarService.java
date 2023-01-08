package pl.pjatk.CarRentalApplication;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

@Component
public class CarService {

    private final CarStorage carStorage;
    private final RentalStorage rentalStorage;

    public CarService(CarStorage carStorage, RentalStorage rentalStorage) {
        this.carStorage = carStorage;
        this.rentalStorage = rentalStorage;
    }

    public List<Car> getAllCars() {
        return carStorage.getCarList();
    }

    public List<Rental> getAllRentals() {
        return rentalStorage.getRentalList();
    }

//    public RentalInfo rentACar(String vin) {
//        List<Rental> rentalList = rentalStorage.getRentalList();
//        for (Car car : carStorage.getCarList()) {
//            if (vin.equals(car.getVin())) {
//                for (Rental rental : rentalList) {
//                    if (rental.getCar().getVin().equals(car.getVin())) {
//                        System.out.println("This car is already rented");
//                        return null;
//                    } else {
//                        System.out.println("Car with vin: " + vin + " successfully add");
//                        rentalStorage.getRentalList().add(new Rental(new User("userTemplate"), car));
//                        return new RentalInfo(1.0, LocalDate.now(), LocalDate.now());
//                    }
//                }
//            }
//        }
//        System.out.println("We don't have that type of car");
//        return null;
//    }

    public RentalInfo rentACar(String vin, LocalDate startDate, LocalDate endDate) {

        List<Rental> rentalList = rentalStorage.getRentalList();
        List<Car> carList = carStorage.getCarList();

        if (startDate.isAfter(endDate)){
            System.out.println("Start date cannot be after end Date");
            return null;
        }

        if (vin == null){
            System.out.println("Vin number cannot be null");
            return null;
        }

        for (Rental rental : rentalList) {
            if (!(rental.getCar().getVin().equals(vin))) {
                for (Car car : carList) {
                    if (car.getVin().equals(vin)) {
                        System.out.println("Car with vin: " + vin + " successfully rented");
                        rentalList.add(new Rental(new User("dummyUser"), car));
                        int between = (int) ChronoUnit.DAYS.between(startDate, endDate);
                        return new RentalInfo(300.00 * between * car.getCarSegment().getNumVal(), startDate, endDate);
                    }
                }
            } else {
                System.out.println("Can't rent that car.");
                return null;
            }
        }
        return null;
    }

}

