package src.br.com.gft.models.livro;

public class CalculaImpostoTemaOutro extends CalculaImpostoPorTema {
    public CalculaImpostoTemaOutro(CalculaImpostoPorTema proximo) {
        super(proximo);
    }

    @Override
    protected double calcular(Livro livro) {
        double imposto = livro.getPreco()*0.1;
        System.out.printf("R$%.2f de impostos sobre o livro %s.\n", imposto, livro.getNome());
        return imposto;
    }
}
