package src.br.com.gft.models.livro;

public abstract class CalculaImpostoPorTema {
    private CalculaImpostoPorTema proximo;

    public CalculaImpostoPorTema(CalculaImpostoPorTema proximo) {
        this.proximo = proximo;
    }

    public double calculaImposto(Livro livro) {
        double imposto = calcular(livro);

        if (imposto == -1)
            return proximo.calculaImposto(livro);

        return imposto;
    }

    protected abstract double calcular(Livro livro);
}
