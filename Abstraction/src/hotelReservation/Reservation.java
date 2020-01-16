package hotelReservation;

public class Reservation {
    private double pricePerDay;
    private int days;
    private Season season;
    private Discount discount;

    public Reservation(double pricePerDay, int days, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }

    public double getPricePerDay() {
        return this.pricePerDay;
    }

    public int getDays() {
        return this.days;
    }

    public Season getSeason() {
        return this.season;
    }

    public Discount getDiscount() {
        return this.discount;
    }
}
