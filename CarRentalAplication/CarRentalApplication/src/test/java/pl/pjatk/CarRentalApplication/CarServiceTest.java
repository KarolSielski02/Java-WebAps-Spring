package pl.pjatk.CarRentalApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    private CarStorage carStorage;
    private RentalStorage rentalStorage;
    private CarService carService;

    @BeforeEach
    void setup(){
        this.carStorage = new CarStorage();
        this.rentalStorage = new RentalStorage();
        this.carService = new CarService(carStorage, rentalStorage);

//        carService.rentACar("r000000", LocalDate.of(2022,10,30),LocalDate.of(2022,11,30));
    }

    @Test
    void carServiceWhatIfVinIsNull(){
        var result = carService.rentACar(null, LocalDate.of(2022,10,30),LocalDate.of(2022,11,30));

        assertThat(result).isEqualTo(null);
    }

    @Test
    void carServiceStartDateAfterEndDate(){
        var result = carService.rentACar("r000000", LocalDate.of(2022,10,30),LocalDate.of(2022,9,30));

        assertThat(result).isEqualTo(null);
    }

    @Test
    void carServiceRentingRentedCar(){
        var result = carService.rentACar("audii321", LocalDate.of(2022,10,30),LocalDate.of(2022,11,30));

        assertThat(result).isEqualTo(null);
    }

    @Test
    void carServiceNoCarInStorageTest(){
        var result = carService.rentACar("r000001", LocalDate.of(2022,10,30),LocalDate.of(2022,11,30));

        assertThat(result).isEqualTo(null);
    }

    @Test
    void carSegmentStandardSegmentPriceTest(){
        var result = carService.rentACar("ford1234", LocalDate.of(2022,10,20),LocalDate.of(2022,10,30));
        assertThat(result.getPrice()).isEqualTo(300.00 * 10 * CarSegment.STANDARD.getNumVal());
    }

    @Test
    void carSegmentPremiumSegmentPriceTest(){
        var result = carService.rentACar("Merc1234", LocalDate.of(2022,10,20),LocalDate.of(2022,10,30));
        assertThat(result.getPrice()).isEqualTo(300.00 * 10 * CarSegment.PREMIUM.getNumVal());
    }
}