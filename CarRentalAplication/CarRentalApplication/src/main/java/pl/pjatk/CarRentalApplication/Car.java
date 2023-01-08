package pl.pjatk.CarRentalApplication;

public class Car {

    private String make;
    private String model;
    private String vin;
    private CarSegment carSegment;

    public Car(String make, String model, String vin, CarSegment carSegment) {
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.carSegment = carSegment;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public CarSegment getCarSegment() {
        return carSegment;
    }

    public void setCarSegment(CarSegment carSegment) {
        this.carSegment = carSegment;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", carSegment='" + carSegment + '\'' +
                '}';
    }
}
