package br.com.gft.entity;

public class Supervisor extends Funcionario {
    public Supervisor(String nome, int idade, float salario) {
        super(nome, idade, salario);
    }

    @Override
    public float bonificacao() {
        return salario + 5000;
    }
}
