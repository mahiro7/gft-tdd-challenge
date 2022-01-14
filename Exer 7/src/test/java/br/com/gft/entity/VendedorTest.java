package br.com.gft.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendedorTest {
    @Test
    public void deveRetornarBonificacao() {
        Vendedor vendedor = new Vendedor("Ariel", 22, 1600);

        float actualBonificacao = vendedor.bonificacao();

        assertEquals(4600, actualBonificacao, 0.0001);
    }
}
