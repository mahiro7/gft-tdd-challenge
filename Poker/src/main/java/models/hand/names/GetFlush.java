package models.hand.names;

import models.card.Suit;
import models.hand.Hand;
import models.hand.HandRank;

import java.util.List;

public class GetFlush extends GetHandNameChain {
    public GetFlush(GetHandNameChain next) {
        super(next);
    }

    @Override
    public HandRank getHandName(Hand hand) {
        List<Suit> handSuits = hand.getHandSuits();

        if (handSuits.stream().distinct().count() <= 1)
            return HandRank.FLUSH;

        return HandRank.NEXT;
    }
}
