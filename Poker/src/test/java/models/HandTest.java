package models;

import models.card.Card;
import models.card.Rank;
import models.card.Suit;
import models.hand.Hand;
import models.hand.HandRank;
import models.hand.names.GetFourOfAKind;
import models.hand.names.GetFullHouse;
import models.hand.names.GetRoyalStraightFlush;
import models.hand.names.GetStraightFlush;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HandTest {
    private List<Card> cards;

    @Before
    public void setup() {
        cards = Arrays.asList(
                new Card(Rank.DEUCE, Suit.SPADES),
                new Card(Rank.DEUCE, Suit.CLUBS),
                new Card(Rank.THREE, Suit.DIAMONDS),
                new Card(Rank.ACE, Suit.DIAMONDS),
                new Card(Rank.JACK, Suit.SPADES)
        );
    }

    @Test
    public void shouldReturnTheHigherValueCardRank() {
        Hand hand = new Hand(cards);

        Rank expected = Rank.ACE;

        assertEquals(expected, hand.getHigherCardRank());
    }

    @Test
    public void shouldBeARoyalStraightFlush() {
        cards = Arrays.asList(
                new Card(Rank.TEN, Suit.DIAMONDS),
                new Card(Rank.JACK, Suit.DIAMONDS),
                new Card(Rank.ACE, Suit.DIAMONDS),
                new Card(Rank.KING, Suit.DIAMONDS),
                new Card(Rank.QUEEN, Suit.DIAMONDS)
        );

        Hand hand = new Hand(cards);

        assertEquals(HandRank.ROYALSTRAIGHTFLUSH, hand.getHandRank());
    }

    @Test
    public void shouldBeAStraightFlush() {
        List<Card> cards1 = Arrays.asList(
                new Card(Rank.NINE, Suit.DIAMONDS),
                new Card(Rank.JACK, Suit.DIAMONDS),
                new Card(Rank.TEN, Suit.DIAMONDS),
                new Card(Rank.KING, Suit.DIAMONDS),
                new Card(Rank.QUEEN, Suit.DIAMONDS)
        );

        List<Card> cards2 = Arrays.asList(
                new Card(Rank.DEUCE, Suit.SPADES),
                new Card(Rank.THREE, Suit.SPADES),
                new Card(Rank.FIVE, Suit.SPADES),
                new Card(Rank.SIX, Suit.SPADES),
                new Card(Rank.FOUR, Suit.SPADES)
        );

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(HandRank.STRAIGHTFLUSH, hand1.getHandRank());
        assertEquals(HandRank.STRAIGHTFLUSH, hand2.getHandRank());
    }

    @Test
    public void shouldTranslateAStringBasedHandToACardBasedHand() {
        String string = "2S 2C 3D AD JS";
        Hand expectedHand = new Hand(cards);
        Hand actualHand = Hand.fromString(string);

        List<String> expected = expectedHand.showHand();
        List<String> actual = actualHand.showHand();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeAFourOfAKind() {
        String hand1 = "2S 2C 2D 2H 10S";
        String hand2 = "10C 2C 10D 10S 10H";
        Hand actual1 = Hand.fromString(hand1);
        Hand actual2 = Hand.fromString(hand2);

        assertEquals(HandRank.FOUROFAKIND, actual1.getHandRank());
        assertEquals(HandRank.FOUROFAKIND, actual2.getHandRank());
    }

    @Test
    public void shouldBeAFullHouse() {
        String hand1 = "3C 3S 2D 2S 3D";
        String hand2 = "4C 4S 4D AS AD";

        Hand actual1 = Hand.fromString(hand1);
        Hand actual2 = Hand.fromString(hand2);

        assertEquals(HandRank.FULLHOUSE, actual1.getHandRank());
        assertEquals(HandRank.FULLHOUSE, actual2.getHandRank());
    }

    @Test
    public void shouldBeAFlush() {
        String hand1 = "3D AD 2D JD 4D";
        String hand2 = "2C 4C QC AC JC";

        Hand actual1 = Hand.fromString(hand1);
        Hand actual2 = Hand.fromString(hand2);

        assertEquals(HandRank.FLUSH, actual1.getHandRank());
        assertEquals(HandRank.FLUSH, actual2.getHandRank());
    }

    @Test
    public void shouldBeAStraight() {
        String hand1 = "3D 4H 2D 6D 5D";
        String hand2 = "KC 10H QC AC JC";

        Hand actual1 = Hand.fromString(hand1);
        Hand actual2 = Hand.fromString(hand2);

        assertEquals(HandRank.STRAIGHT, actual1.getHandRank());
        assertEquals(HandRank.STRAIGHT, actual2.getHandRank());
    }

    @Test
    public void shouldBeAThreeOfAKind() {
        String hand1 = "3D 3H 3S 6D 5D";
        String hand2 = "KC KH KS AC JC";

        Hand actual1 = Hand.fromString(hand1);
        Hand actual2 = Hand.fromString(hand2);

        assertEquals(HandRank.THREEOFAKIND, actual1.getHandRank());
        assertEquals(HandRank.THREEOFAKIND, actual2.getHandRank());
    }

    @Test
    public void shouldBeATwoPairs() {
        String hand1 = "3D 3H 4S 6D 4D";
        String hand2 = "KC KH JS AC JC";

        Hand actual1 = Hand.fromString(hand1);
        Hand actual2 = Hand.fromString(hand2);

        assertEquals(HandRank.TWOPAIRS, actual1.getHandRank());
        assertEquals(HandRank.TWOPAIRS, actual2.getHandRank());
    }

    @Test
    public void shouldBeAOnePair() {
        String hand1 = "3D 3H 4S 6D 7D";
        String hand2 = "KC 7H JS AC JC";

        Hand actual1 = Hand.fromString(hand1);
        Hand actual2 = Hand.fromString(hand2);

        assertEquals(HandRank.ONEPAIR, actual1.getHandRank());
        assertEquals(HandRank.ONEPAIR, actual2.getHandRank());
    }

    @Test
    public void shouldBeAHighCard() {
        String hand1 = "3D QH 4S 6D 7D";
        String hand2 = "KC 7H 2S AC JC";

        Hand actual1 = Hand.fromString(hand1);
        Hand actual2 = Hand.fromString(hand2);

        assertEquals(HandRank.HIGHCARD, actual1.getHandRank());
        assertEquals(HandRank.HIGHCARD, actual2.getHandRank());
    }
}
