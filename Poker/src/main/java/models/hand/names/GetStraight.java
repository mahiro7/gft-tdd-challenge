package models.hand.names;

import models.card.Suit;
import models.hand.Hand;
import models.hand.HandRank;

import java.util.List;
import java.util.stream.Collectors;

public class GetStraight extends GetHandNameChain {
    public GetStraight(GetHandNameChain next) {
        super(next);
    }

    @Override
    public HandRank getHandName(Hand hand) {
        List<Integer> ranksValues = hand.getHand().stream()
                .map(x -> x.getRank().ordinal())
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < ranksValues.size() - 1; i++){
            if (ranksValues.get(i) != ranksValues.get(i + 1) - 1)
                return HandRank.NEXT;
        }

        return HandRank.STRAIGHT;
    }
}
