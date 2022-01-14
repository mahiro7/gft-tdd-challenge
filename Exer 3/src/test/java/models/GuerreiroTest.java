package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuerreiroTest {
    private Guerreiro guerreiro;

    @Before
    public void setup() {
        guerreiro = new Guerreiro("Guerreiro", 550, 200, 0, 20, 75, 0);
    }

    @Test
    public void deveSubirDeLevel() {
        guerreiro.lvlUp();

        assertEquals(1, guerreiro.getLevel());
        assertEquals(670, guerreiro.getVida());
        assertEquals(91, guerreiro.getForca());
    }

    @Test
    public void deveAtacar() {
        guerreiro.attack();
    }

}
