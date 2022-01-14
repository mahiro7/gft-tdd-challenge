package models.card;

public enum Suit {
    CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");

    public String cardSuit;
    Suit(String s) {
        cardSuit = s;
    }

    public String getCardSuit() {
        return cardSuit;
    }

    public static Suit fromString(String s) {
        for (Suit suit : Suit.values()) {
            if (suit.cardSuit.equalsIgnoreCase(s))
                    return suit;
        }
        return null;
    }
}
