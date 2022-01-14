/**
 * @author Guilherme Molina
 */

package src.br.com.gft;

import src.br.com.gft.models.*;
import src.br.com.gft.models.livro.CalculaImpostoPorTema;
import src.br.com.gft.models.livro.CalculaImpostoTemaEducativo;
import src.br.com.gft.models.livro.CalculaImpostoTemaOutro;
import src.br.com.gft.models.livro.Livro;
import src.br.com.gft.models.videoGame.VideoGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CalculaImpostoPorTema calculaImpostoPorTema = new CalculaImpostoTemaEducativo(
                new CalculaImpostoTemaOutro(null)
        );

        Livro l1 = new Livro("Harry Potter", 40, 50, "J. K Rowling", "fantasia", 300);
        Livro l2 = new Livro("Senhor dos Anéis", 60, 30, "J. R. R. Tolkien", "fantasia", 500);
        Livro l3 = new Livro("Java POO", 20, 50, "GFT", "educativo", 500);

        VideoGame ps4 = new VideoGame("PS4", 1800, 100, "Sony", "Slim", false);
        VideoGame ps4usado = new VideoGame("PS4", 1000, 7, "Sony", "Slim", true);
        VideoGame xbox = new VideoGame("XBOX", 1500, 500, "microsoft", "One", false);

        List<Livro> livros = Arrays.asList(l1, l2, l3);
        List<VideoGame> games = Arrays.asList(ps4, ps4usado, xbox);

        Loja americanas = new Loja("Americanas", "12345678", livros, games);

        l2.calculaImposto();
        l3.calculaImposto();

        ps4usado.calculaImposto();
        ps4.calculaImposto();

        americanas.listaLivros();
        americanas.listaVideoGames();
        americanas.calculaPatrimonio();
    }
}
