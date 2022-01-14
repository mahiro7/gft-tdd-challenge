package models;

import models.card.Card;
import models.card.Rank;
import models.card.Suit;
import models.hand.Hand;
import models.player.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private Player player1;
    private Player player2;

    @Before
    public void setup() {
        List< Card > cards1 = Arrays.asList(
                new Card(Rank.ACE, Suit.DIAMONDS),
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

        player1 = new Player("You", hand1);
        player2 = new Player("Me", hand2);
    }

    @Test
    public void shouldReturnTheWinner() {
        Player expected = player1;

        assertEquals(expected, Player.getWinner(player1, player2));
    }

    @Test
    public void shouldResolveATie() {
        String string1 = "3H 4D 5C 6S 7C";
        String string2 = "6H 7H 8D 9D 10C";

        Hand hand1 = Hand.fromString(string1);
        Hand hand2 = Hand.fromString(string2);

        Player player1 = new Player("Me", hand1);
        Player player2 = new Player("You", hand2);

        assertEquals(player2, Player.getWinner(player1, player2));
    }
}
