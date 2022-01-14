package src.br.com.gft.models.livro;

import src.br.com.gft.interfaces.Imposto;
import src.br.com.gft.models.Produto;

public class Livro extends Produto implements Imposto {
    String autor;
    String tema;
    int qtdPag;

    private CalculaImpostoPorTema calculaImpostoPorTema = new CalculaImpostoTemaEducativo(
            new CalculaImpostoTemaOutro(null)
    );

    public Livro() {
    }

    public Livro(String nome, double preco, int qtd, String autor, String tema, int qtdPag) {
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
        this.autor = autor;
        this.tema = tema;
        this.qtdPag = qtdPag;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getQtdPag() {
        return qtdPag;
    }
    public void setQtdPag(int qtdPag) {
        this.qtdPag = qtdPag;
    }

    @Override
    public double calculaImposto() {
        return calculaImpostoPorTema.calculaImposto(this);
    }
}
