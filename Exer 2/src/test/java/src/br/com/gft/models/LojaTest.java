package src.br.com.gft.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import src.br.com.gft.models.livro.Livro;
import src.br.com.gft.models.videoGame.VideoGame;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LojaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private Loja loja;
    private List<Livro> livros;
    private List<VideoGame> videoGames;
    private Livro l1, l2, l3;
    private VideoGame ps4, ps4usado, xbox;

    @Before
    public void setUpStreams() {
        loja = new Loja();
        livros = Arrays.asList();
        videoGames = Arrays.asList();

        l1 = new Livro("Harry Potter", 40, 50, "J. K Rowling", "fantasia", 300);
        l2 = new Livro("Senhor dos Anéis", 60, 30, "J. R. R. Tolkien", "fantasia", 500);
        l3 = new Livro("Java POO", 20, 50, "GFT", "educativo", 500);

        ps4 = new VideoGame("PS4", 1800, 100, "Sony", "Slim", false);
        ps4usado = new VideoGame("PS4", 1000, 7, "Sony", "Slim", true);
        xbox = new VideoGame("XBOX", 1500, 500, "microsoft", "One", false);

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void deveLidarComAListaDeLivrosVazia() {
        loja.setLivros(livros);
        loja.listaLivros();

        Assert.assertThat(outContent.toString(), containsString("A loja não tem livros no seu estoque."));
    }

    @Test
    public void deveListarTodosLivros() {
        List<Livro> actualLivros = Arrays.asList(l1, l2);

        loja.setLivros(actualLivros);
        loja.listaLivros();

        assertThat(outContent.toString(), containsString("Título: Harry Potter; Preço: 40,00; Quantidade: 50 em estoque."));
        assertThat(outContent.toString(), containsString("Título: Senhor dos Anéis; Preço: 60,00; Quantidade: 30 em estoque."));
    }

    @Test
    public void deveLidarComListaDeVideoGamesVazia() {
        loja.setVideoGames(videoGames);
        loja.listaVideoGames();

        Assert.assertThat(outContent.toString(), containsString("A loja não tem video-games no seu estoque."));
    }

    @Test
    public void deveCalcularPatrimonioDaLoja() {
        List<Livro> actualLivros = Arrays.asList(l1, l2, l3);
        List<VideoGame> actualVideoGames = Arrays.asList(ps4, ps4usado, xbox);

        Loja actualLoja = new Loja("Americanas", "12345678", actualLivros, actualVideoGames);

        assertEquals(941800.0, actualLoja.calculaPatrimonio(), 0.0001);
    }
}
