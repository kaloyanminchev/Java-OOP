package cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRank rank = CardRank.valueOf(scanner.nextLine());
        CardSuit suit = CardSuit.valueOf(scanner.nextLine());

        Card card = new Card(rank, suit);
        System.out.println(card.toString());
    }
}
