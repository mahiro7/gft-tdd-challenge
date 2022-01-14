package br.com.gft.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SupervisorTest {
    @Test
    public void deveRetornarBonificacao() {
        Supervisor supervisor = new Supervisor("Daniel", 28, 4000);

        float actualBonificacao = supervisor.bonificacao();

        assertEquals(9000, actualBonificacao, 0.0001);
    }
}
