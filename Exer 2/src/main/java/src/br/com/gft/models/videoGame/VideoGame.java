package src.br.com.gft.models.videoGame;

import src.br.com.gft.interfaces.Imposto;
import src.br.com.gft.models.Produto;

public class VideoGame extends Produto implements Imposto {
    String marca;
    String modelo;
    boolean isUsado;

    public VideoGame() {
    }
    public VideoGame(String nome, double preco, int qtd, String marca, String modelo, boolean isUsado) {
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
        this.marca = marca;
        this.modelo = modelo;
        this.isUsado = isUsado;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean getIsUsado() {
        return isUsado;
    }
    public void setIsUsado(boolean isUsado) {
        this.isUsado = isUsado;
    }

    @Override
    public double calculaImposto() {
        double imposto;

        if (isUsado)
            imposto = 0.25*getPreco();
        else
            imposto = 0.45*getPreco();

        System.out.printf("Imposto %s %s %s R$%.2f. \n", nome, modelo, isUsado ? "usado " : "", imposto);
        return imposto;
    }
}
