package cardsWithPower;

public class Card {
    private CardRank rank;
    private CardSuit suit;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public CardRank getRank() {
        return this.rank;
    }

    public CardSuit getSuit() {
        return this.suit;
    }

    private int getPower() {
        return this.getRank().getValue() + this.getSuit().getValue();
    }

    @Override
    public String toString() {
        return String.format("cardsWithPower.Card name: %s of %s; cardsWithPower.Card power: %d",
                this.getRank(),
                this.getSuit(),
                this.getPower());
    }
}
