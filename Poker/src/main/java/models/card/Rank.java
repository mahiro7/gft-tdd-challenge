package models.card;

public enum Rank {
    DEUCE("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"),
    SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
    JACK("J"), QUEEN("Q"), KING("K"), ACE("A");

    public String cardRank;
    Rank(String s) {
        cardRank = s;
    }

    public String getCardRank() {
        return cardRank;
    }

    public static Rank fromString(String s) {
        for (Rank r : Rank.values()) {
            if (r.cardRank.equalsIgnoreCase(s))
                return r;
        }

        return null;
    }
}
