package models.hand.names;

import models.card.Rank;
import models.card.Suit;
import models.hand.Hand;
import models.hand.HandRank;

import java.util.Arrays;
import java.util.List;

public class GetRoyalStraightFlush extends GetHandNameChain {

    public GetRoyalStraightFlush(GetHandNameChain next) {
        super(next);
    }

    @Override
    public HandRank getHandName(Hand hand) {
        List<Rank> ranks = Arrays.asList(
                Rank.TEN,
                Rank.JACK,
                Rank.ACE,
                Rank.KING,
                Rank.QUEEN
        );

        List<Rank> handRanks = hand.getHandRanks();
        List<Suit> handSuits = hand.getHandSuits();

        if (handSuits.stream().distinct().count() <= 1)
            return handRanks.containsAll(ranks) ? HandRank.ROYALSTRAIGHTFLUSH : HandRank.NEXT;
        return HandRank.NEXT;
    }
}
