package hotelReservation;

public enum Discount {
    VIP(20),
    SECOND_VISIT(10),
    NONE(0);

    private double value;

    Discount(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
