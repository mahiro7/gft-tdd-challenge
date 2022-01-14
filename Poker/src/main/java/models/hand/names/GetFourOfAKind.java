package models.hand.names;

import models.card.Rank;
import models.card.Suit;
import models.hand.Hand;
import models.hand.HandRank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetFourOfAKind extends GetHandNameChain {
    public GetFourOfAKind(GetHandNameChain next) {
        super(next);
    }

    @Override
    public HandRank getHandName(Hand hand) {
        List<Rank> handRanks = hand.getHandRanks();

        Map<Rank, Long> counts = handRanks.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        if (counts.containsValue(4L))
            return HandRank.FOUROFAKIND;

        return HandRank.NEXT;
    }
}
