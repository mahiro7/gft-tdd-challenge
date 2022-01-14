package models.hand.names;

import models.card.Suit;
import models.hand.Hand;
import models.hand.HandRank;

import java.util.List;
import java.util.stream.Collectors;

public class GetStraightFlush extends GetHandNameChain {
    public GetStraightFlush(GetHandNameChain next) {
        super(next);
    }

    @Override
    public HandRank getHandName(Hand hand) {
        List<Integer> ranksValues = hand.getHand().stream()
                .map(x -> x.getRank().ordinal())
                .sorted()
                .collect(Collectors.toList());

        List<Suit> handSuits = hand.getHandSuits();

        for (int i = 0; i < ranksValues.size() - 1; i++){
            if (ranksValues.get(i) != ranksValues.get(i + 1) - 1)
                return HandRank.NEXT;
        }

        if (handSuits.stream().distinct().count() <= 1)
            return HandRank.STRAIGHTFLUSH;

        return HandRank.NEXT;
    }
}
