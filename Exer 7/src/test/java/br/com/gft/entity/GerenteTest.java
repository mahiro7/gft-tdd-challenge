package br.com.gft.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GerenteTest {
    @Test
    public void deveRetornarBonificacao() {
        Gerente gerente = new Gerente("Rafaela", 36, 6000);

        float actualBonificacao = gerente.bonificacao();

        assertEquals(16000, actualBonificacao, 0.0001);
    }
}
