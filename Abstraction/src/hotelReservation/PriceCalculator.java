package hotelReservation;

public class PriceCalculator {
    public static double CalculatePrice(Reservation reservation) {
       double basePrice = reservation.getPricePerDay() * reservation.getDays() * reservation.getSeason().getValue();
       double discountPercentage = 1 - reservation.getDiscount().getValue() / 100;
       return basePrice * discountPercentage;
    }
}
