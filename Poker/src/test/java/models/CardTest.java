package models;

import models.card.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {
    private Card smallerCard;
    private Card higherCard;

    @Before
    public void setup() {
        smallerCard = new Card(Rank.DEUCE, Suit.SPADES);
        higherCard = new Card(Rank.EIGHT, Suit.DIAMONDS);
    }

    @Test
    public void shouldCompareTwoRanksAndGetTheHigherOne() {
        Rank actualRank = smallerCard.compareRanks(higherCard.getRank());

        Rank expectedRank = Rank.EIGHT;

        assertEquals(expectedRank, actualRank);
    }

}
