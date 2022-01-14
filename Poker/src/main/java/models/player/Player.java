package models.player;

import models.hand.Hand;

public class Player {
    private String name;
    private Hand hand;

    public Player() {
    }

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public static Player getWinner(Player p1, Player p2) {
        int p1HandRank = p1.getHand().getHandRank().ordinal();
        int p2HandRank = p2.getHand().getHandRank().ordinal();

        if (p1HandRank == p2HandRank) {
            int highCard1 = p1.hand.getHigherCardRank().ordinal();
            int highCard2 = p2.hand.getHigherCardRank().ordinal();

            if (highCard1 == highCard2)
                return new Player("Empate", new Hand());
            return highCard1 > highCard2 ? p1 : p2;
        }
        return p1HandRank > p2HandRank ? p1 : p2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
