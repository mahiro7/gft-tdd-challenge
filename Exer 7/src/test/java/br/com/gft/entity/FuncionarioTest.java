package br.com.gft.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuncionarioTest {
    @Test
    public void deveRetornarSalario() {
        Funcionario funcionario = new Funcionario("Guilherme", 20, 1600) {};

        float actualBonificacao = funcionario.bonificacao();

        assertEquals(1600, actualBonificacao, 0.0001);
    }
}
