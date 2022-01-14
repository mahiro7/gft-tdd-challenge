/**
 * @author Guilherme Molina
 */

package br.com.gft;

import br.com.gft.entity.Gerente;
import br.com.gft.entity.Supervisor;
import br.com.gft.entity.Vendedor;

public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Gabriela", 29, 6353);
        Vendedor vendedor = new Vendedor("Ariel", 22, 2100);
        Supervisor supervisor = new Supervisor("Michael", 25, 3500);

        System.out.println("Gerente >>");
        System.out.printf("Nome: %s; Bonificação: %.2f\n\n", gerente.getNome(), gerente.bonificacao());

        System.out.println("Supervisor >>");
        System.out.printf("Nome: %s; Bonificação: %.2f\n\n", supervisor.getNome(), supervisor.bonificacao());

        System.out.println("Vendedor >>");
        System.out.printf("Nome: %s; Bonificação: %.2f\n\n", vendedor.getNome(), vendedor.bonificacao());
    }
}
