package br.com.gft.entity;

public class Vendedor extends Funcionario {
    public Vendedor(String nome, int idade, float salario) {
        super(nome, idade, salario);
    }

    @Override
    public float bonificacao() {
        return salario + 3000;
    }
}
