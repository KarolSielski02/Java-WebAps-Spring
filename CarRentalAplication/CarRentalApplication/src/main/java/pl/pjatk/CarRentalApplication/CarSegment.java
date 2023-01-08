package pl.pjatk.CarRentalApplication;

public enum CarSegment {
    STANDARD(2.0), PREMIUM(5.0), CITY(1.0);

    private double numVal;

    CarSegment(double numVal) {
        this.numVal = numVal;
    }

    public double getNumVal() {
        return numVal;
    }



}
