import models.card.Rank;
import models.card.Suit;
import models.hand.Hand;
import models.player.Player;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Player player1 = createPlayer("1");
        Player player2 = createPlayer("2");

        Player winner = Player.getWinner(player1, player2);

        if (winner.getName() != "Empate") {
            System.out.println("A mão vencedora é: " + winner.getHand().showHand());
            System.out.println("De " + winner.getName());
        } else
            System.out.println("Empate!");
    }

    private static Player createPlayer(String number) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Digite o nome do jogador "+number+": ");
        String name = scanner.next();

        String baralho;
        do {
            System.out.println("Digite o baralho contendo 5 cartas separadas por espaço (exemplo: \"2C 3S 8S 8D JD\"): ");
            baralho = scanner.next();
            if (!validateHandStringFromConsole(baralho))
                System.out.println("Mão inválida!");
            if (!validateCards(baralho.split(" ")))
                System.out.println("Cartas devem seguir o modelo \"RANK\"\"SUIT\"! Exemplos: \"4D\", \"8C\"");
        } while(!validateHandStringFromConsole(baralho) || !validateCards(baralho.split(" ")));

        Hand hand = Hand.fromString(baralho);

        return new Player(name, hand);
    }

    private static boolean validateHandStringFromConsole(String hand) {
        if (hand.split(" ").length == 5)
            return validateCards(hand.split(" "));
        return false;
    }

    private static boolean validateCards(String[] hand) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].length() < 2 || hand[i].length() > 3)
                return false;

            int finalI = i;
            if (!Arrays.stream(Rank.values()).map(x -> x.cardRank)
                    .anyMatch(s -> hand[finalI].toUpperCase().startsWith(s))) {
                return false;
            }

            if (!Arrays.stream(Suit.values()).map(x -> x.cardSuit.charAt(0))
                    .anyMatch(s -> hand[finalI].toUpperCase().charAt(hand[finalI].length() - 1) == s))
                return false;
        }

        return true;
    }
}
