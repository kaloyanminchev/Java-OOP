package cardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("cardsWithPower.Card Ranks:");
        for (CardRank value : CardRank.values()) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    value.ordinal(),
                    value.name())
            );
        }
    }
}
