package src.br.com.gft.models;

import org.junit.Before;
import org.junit.Test;
import src.br.com.gft.models.videoGame.VideoGame;

import static org.junit.Assert.assertEquals;

public class VideoGameTest {
    private VideoGame videoGame;

    @Before
    public void setup() {
        videoGame = new VideoGame();
    }

    @Test
    public void deveCalcularImpostoDeVideoGameUsado() {
        videoGame.setIsUsado(true);
        videoGame.setPreco(800.0);

        assertEquals(200.0, videoGame.calculaImposto(), 0.0001);
    }

    @Test
    public void deveCalcularImpostoDeVideoGameNovo() {
        videoGame.setIsUsado(false);
        videoGame.setPreco(1000.0);

        assertEquals(450.0, videoGame.calculaImposto(), 0.0001);
    }
}
