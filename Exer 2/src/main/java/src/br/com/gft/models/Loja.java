package src.br.com.gft.models;

import src.br.com.gft.models.livro.Livro;
import src.br.com.gft.models.videoGame.VideoGame;

import java.util.List;

public class Loja {
    String nome;
    String cnpj;
    List<Livro> livros;
    List<VideoGame> videoGames;

    public Loja() {
    }
    public Loja(String nome, String cnpj, List<Livro> livros, List<VideoGame> videoGames) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.livros = livros;
        this.videoGames = videoGames;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Livro> getLivros() {
        return livros;
    }
    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<VideoGame> getVideoGames() {
        return videoGames;
    }
    public void setVideoGames(List<VideoGame> videoGames) {
        this.videoGames = videoGames;
    }

    public void listaLivros() {
        System.out.println("----------------------------------------");
        if (!livros.isEmpty()) {
            System.out.printf("A loja %s possui estes livros para venda: \n", nome);
            livros.forEach(livro -> {
                System.out.printf("Título: %s; Preço: %.2f; Quantidade: %d em estoque.\n", livro.getNome(), livro.getPreco(), livro.getQtd());
            });
        } else {
            System.out.print("A loja não tem livros no seu estoque. \n");
        }
    }

    public void listaVideoGames() {
        System.out.println("----------------------------------------");
        if (!videoGames.isEmpty()) {
            System.out.printf("A loja %s possui estes video-games para venda: \n", nome);
            videoGames.forEach(videoGame -> {
                System.out.printf("Video-game: %s %s %s; Preço: %.2f; Quantidade: %d.\n", videoGame.getNome(), videoGame.getModelo(), videoGame.getIsUsado() ? "usado " : "", videoGame.getPreco(), videoGame.getQtd());
            });
        } else {
            System.out.println("A loja não tem video-games no seu estoque.");
        }
    }

    public double calculaPatrimonio() {
        double patrimonio = 0;
        System.out.println("----------------------------------------");
        for (Livro livro: livros) patrimonio += livro.getPreco()*livro.getQtd();
        for (VideoGame videoGame: videoGames) patrimonio += videoGame.getPreco()*videoGame.getQtd();
        System.out.printf("O patrimonio da loja %s é de R$%.2f.", nome, patrimonio);
        return patrimonio;
    }
}
