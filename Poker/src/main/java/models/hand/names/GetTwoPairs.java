package models.hand.names;

import models.card.Rank;
import models.hand.Hand;
import models.hand.HandRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetTwoPairs extends GetHandNameChain {
    public GetTwoPairs(GetHandNameChain next) {
        super(next);
    }

    @Override
    public HandRank getHandName(Hand hand) {
        List<Rank> handRanks = hand.getHandRanks();

        Map<Rank, Long> counts = handRanks.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        if (counts.values().stream().filter(x -> x.equals(2L)).count() == 2)
            return HandRank.TWOPAIRS;

        return HandRank.NEXT;
    }
}
