package models.hand.names;

import models.hand.Hand;
import models.hand.HandRank;

public abstract class GetHandNameChain {
    private GetHandNameChain next;

    public GetHandNameChain(GetHandNameChain next) {
        this.next = next;
    }

    public HandRank returnHandName(Hand hand) {
        HandRank handRank = getHandName(hand);

        if (handRank == HandRank.NEXT)
            return next.returnHandName(hand);


        return handRank;
    }

    public abstract HandRank getHandName(Hand hand);
}
