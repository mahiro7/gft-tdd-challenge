package br.com.gft.entity;

public class Gerente extends Funcionario {

    public Gerente(String nome, int idade, float salario) {
        super(nome, idade, salario);
    }

    @Override
    public float bonificacao() {
        return salario + 10000;
    }
}
