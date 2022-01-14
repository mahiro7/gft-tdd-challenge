package src.br.com.gft.models;

import org.junit.Before;
import org.junit.Test;
import src.br.com.gft.models.livro.CalculaImpostoPorTema;
import src.br.com.gft.models.livro.CalculaImpostoTemaEducativo;
import src.br.com.gft.models.livro.CalculaImpostoTemaOutro;
import src.br.com.gft.models.livro.Livro;

import static org.junit.Assert.assertEquals;

public class LivroTest {
    private Livro livro;

    @Before
    public void setup() {
        livro = new Livro();
    }

    @Test
    public void deveCalcularImpostoDeLivrosEducativos() {
        livro.setTema("Educativo");
        livro.setPreco(30.0);

        assertEquals(0, livro.calculaImposto(), 0.0001);
    }

    @Test
    public void deveCalcularImpostoDoLivro() {
        livro.setTema("Fantasia");
        livro.setPreco(100.0);

        assertEquals(10.0, livro.calculaImposto(), 0.0001);
    }
}
