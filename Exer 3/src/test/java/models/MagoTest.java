package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagoTest {
    private Mago mago;

    @Before
    public void setup() {
        mago = new Mago("Mago", 375, 400, 0, 55, 40, 0);
    }

    @Test
    public void deveSubirDeLevel() {
        mago.lvlUp();

        assertEquals(1, mago.getLevel());
        assertEquals(67, mago.getInteligencia());
        assertEquals(417, mago.getMana());
    }

    @Test
    public void deveAtacar() {
        mago.attack();
    }
}
