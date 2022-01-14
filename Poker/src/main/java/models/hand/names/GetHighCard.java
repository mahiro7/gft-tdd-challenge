package models.hand.names;

import models.hand.Hand;
import models.hand.HandRank;

public class GetHighCard extends GetHandNameChain {
    public GetHighCard(GetHandNameChain next) {
        super(next);
    }

    @Override
    public HandRank getHandName(Hand hand) {
        return HandRank.HIGHCARD;
    }
}
