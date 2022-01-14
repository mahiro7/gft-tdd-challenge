/**
 * @author Guilherme Molina
 */

public class Veiculo {
    private String marca;
    private String modelo;
    private String placa;
    private String cor;
    private long km;
    private boolean isLigado;
    private int litrosCombustivel;
    private int velocidade;
    private double preco;

    public Veiculo() {

    }

    public Veiculo(String marca, String modelo, String placa, String cor, long km, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
        this.km = km;
        this.isLigado = false;
        this.litrosCombustivel = 0;
        this.velocidade = 0;
        this.preco = preco;
    }

    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return this.cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getKm() {
        return this.km;
    }
    public void setKm(long km) {
        this.km = km;
    }

    public boolean getIsLigado() {
        return this.isLigado;
    }
    public void setIsLigado(boolean isLigado) {
        this.isLigado = isLigado;
    }

    public int getLitrosCombustivel() {
        return this.litrosCombustivel;
    }
    public void setLitrosCombustivel(int litrosCombustivel) {
        this.litrosCombustivel = litrosCombustivel;
    }

    public int getVelocidade() {
        return this.velocidade;
    }
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public double getPreco() {
        return this.preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Veiculo acelerar() {
        if (getIsLigado())
            this.velocidade = getVelocidade() + 20;

        return this;
    }

    public Veiculo abastecer(int combustivel) {
        if (getLitrosCombustivel() + combustivel > 60)
            setLitrosCombustivel(60);
        else
            setLitrosCombustivel(getLitrosCombustivel() + combustivel);

        return this;
    }

    public Veiculo frear() {
        if (getVelocidade() != 0 && getVelocidade() >= 20)
            setVelocidade(getVelocidade() - 20);
        else
            setVelocidade(0);

        return this;
    }

    public Veiculo pintar(String cor) {
        this.cor = cor;
        return this;
    }

    public Veiculo ligar() {
        if (!getIsLigado())
            this.isLigado = true;
        return this;
    }

    public Veiculo desligar() {
        if (getIsLigado() && getVelocidade() == 0)
            this.isLigado = false;
        return this;
    }

}
