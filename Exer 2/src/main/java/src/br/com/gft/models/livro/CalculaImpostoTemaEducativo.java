package src.br.com.gft.models.livro;

import java.util.Objects;

public class CalculaImpostoTemaEducativo extends CalculaImpostoPorTema {
    public CalculaImpostoTemaEducativo(CalculaImpostoPorTema proximo) {
        super(proximo);
    }

    @Override
    protected double calcular(Livro livro) {
        if (Objects.equals(livro.getTema().toLowerCase(), "educativo")) {
            System.out.printf("Livro educativo não tem imposto: %s.\n", livro.getNome());
            return 0;
        }
        return -1;
    }
}
