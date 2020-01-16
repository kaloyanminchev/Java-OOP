package hotelReservation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[1]);
        Season season = Season.valueOf(tokens[2].toUpperCase());
        Discount discount = parseDiscount(tokens[3]);

        Reservation reservation = new Reservation(pricePerDay, days, season, discount);

        double price = PriceCalculator.CalculatePrice(reservation);
        System.out.printf("%.2f", price);
    }

    private static Discount parseDiscount(String token) {
        Matcher matcher = Pattern.compile("([A-Z]+[a-z]*)")
                .matcher(token);

        StringBuilder enumToUpper = new StringBuilder();
        int count = 0;
        while (matcher.find()) {
            if (count > 0) {
                enumToUpper.append("_");
            }
            enumToUpper.append(matcher.group(1).toUpperCase());
            count++;
        }

        return Discount.valueOf(enumToUpper.toString());
    }
}
