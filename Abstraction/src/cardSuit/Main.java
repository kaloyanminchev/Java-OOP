package cardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("cardsWithPower.Card Suits:");

        CardSuit[] tokens = CardSuit.values();
        for (CardSuit token : tokens) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", token.ordinal(), token.toString()));
        }
    }
}
