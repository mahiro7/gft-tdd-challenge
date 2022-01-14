/**
 * @author Guilherme Molina
 */

import models.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Número de personagens: ");
        System.out.printf("%d\n\n", Personagem.getNumberChars());

        System.out.println("Criando um mago e um guerreiro...\n");
        Mago m1 = new Mago("Mago", 375, 400, 0, 55, 40, 0);
        Guerreiro g1 = new Guerreiro("Guerreiro", 550, 200, 0, 20, 75, 0);

        System.out.println("Número de personagens: ");
        System.out.printf("%d\n", Personagem.getNumberChars());
    }
}
