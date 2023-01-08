package pl.pjatk.CarRentalApplication;

import java.time.LocalDate;

public class RentalInfo {

    private double price;
    private LocalDate startDate;
    private LocalDate endDate;

    public RentalInfo(double price, LocalDate startDate, LocalDate endDate) {
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "RentalInfo{" +
                "price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
