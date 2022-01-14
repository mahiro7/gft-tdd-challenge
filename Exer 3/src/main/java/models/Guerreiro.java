package models;

import java.util.List;

public class Guerreiro extends Personagem {
    public List<String> habilidade;

    public Guerreiro(String nome, int vida, int mana, float xp, int inteligencia, int forca, int level) {
        super(nome, vida, mana, xp, inteligencia, forca, level);
    }

    public List<String> getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(List<String> habilidade) {
        habilidade = habilidade;
    }

    @Override
    public void lvlUp() {
        this.mana += 5;
        this.inteligencia += 5;
        this.vida += 120;
        this.forca += 16;
        this.level++;
    }

    public double attack() {
        double dano = forca*level + Math.floor(Math.random()*(301));
        System.out.printf("Guerreiro ataca causando %2f de dano", dano);
        return dano;
    }

    public void aprenderHabilidade(String habilidade) {
        this.habilidade.add(habilidade);
    }
}
