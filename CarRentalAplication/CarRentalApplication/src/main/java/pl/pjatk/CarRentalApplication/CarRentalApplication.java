package pl.pjatk.CarRentalApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CarRentalApplication {

    public CarRentalApplication(CarService carService) {
        System.out.println(carService.getAllCars());
        System.out.println(carService.getAllRentals());
        System.out.println(carService.rentACar("rena12345", LocalDate.of(2022,10,30),LocalDate.of(2022,11,30)));
    }

    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class, args);
    }

}
