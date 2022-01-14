package models.hand;

import models.card.Card;
import models.card.Rank;
import models.card.Suit;
import models.hand.names.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {
    private List<Card> hand;
    private GetHandNameChain handName = new GetRoyalStraightFlush(
            new GetStraightFlush(
                    new GetFourOfAKind(
                            new GetFullHouse(
                                    new GetFlush(
                                            new GetStraight(
                                                    new GetThreeOfAKind(
                                                            new GetTwoPairs(
                                                                    new GetOnePair(
                                                                            new GetHighCard(null)
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                            )
                    )
            )
    );

    public Hand() {
    }

    public Hand(List<Card> hand) {
        this.hand = hand;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public GetHandNameChain getHandName() {
        return handName;
    }

    public void setHandName(GetHandNameChain handName) {
        this.handName = handName;
    }

    public List<String> showHand() {
        /*
        this.hand.forEach(x -> {
                System.out.print(x.getRank().cardRank + x.getSuit().cardSuit + " ");
            }
        );
        */
        //System.out.println(" ");
        List<String> hand = this.hand.stream()
                .map(x -> x.getRank().cardRank + x.getSuit().cardSuit)
                .collect(Collectors.toList());

        return hand;
    }

    public Rank getHigherCardRank() {
        List<Integer> valuesList = this.hand.stream()
                .map(x -> x.getRank().ordinal())
                .collect(Collectors.toList())
        ;

        int higher = Collections.max(valuesList);

        return Rank.values()[higher];
    }

    public HandRank getHandRank() {
        return handName.returnHandName(this);
    }

    public static Hand fromString(String string) {
        String[] stringHandArr = string.split(" ");
        List<Card> cards = new java.util.ArrayList<>(List.of());
        Card card;

        for (String s : stringHandArr) {
            String rank = s.substring(0, s.length() - 1);
            char suit = s.charAt(s.length() - 1);
            card = new Card(Rank.fromString(rank), Suit.fromString(Character.toString(suit)));

            cards.add(card);
        }

        return new Hand(cards);
    }

    public List<Rank> getHandRanks() {
        List<Rank> handRanks = this.getHand().stream()
                .map(x -> x.getRank())
                .collect(Collectors.toList());

        return handRanks;
    }

    public List<Suit> getHandSuits() {
        List<Suit> handSuits = this.getHand().stream()
                .map(x -> x.getSuit())
                .collect(Collectors.toList());

        return handSuits;
    }
}
