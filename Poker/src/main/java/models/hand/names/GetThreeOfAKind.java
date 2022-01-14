package models.hand.names;

import models.card.Rank;
import models.hand.Hand;
import models.hand.HandRank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetThreeOfAKind extends GetHandNameChain {
    public GetThreeOfAKind(GetHandNameChain next) {
        super(next);
    }

    @Override
    public HandRank getHandName(Hand hand) {
        List<Rank> handRanks = hand.getHandRanks();

        Map<Rank, Long> counts = handRanks.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        if (counts.containsValue(3L))
            return HandRank.THREEOFAKIND;

        return HandRank.NEXT;
    }
}
