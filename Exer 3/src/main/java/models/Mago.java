package models;

import java.util.List;

public class Mago extends Personagem {
    public List<String> magia;

    public Mago(String nome, int vida, int mana, float xp, int inteligencia, int forca, int level) {
        super(nome, vida, mana, xp, inteligencia, forca, level);
    }

    public List<String> getMagia() {
        return magia;
    }
    public void setMagia(List<String> magia) {
        this.magia = magia;
    }

    @Override
    public void lvlUp() {
        this.mana += 17;
        this.inteligencia += 12;
        this.vida += 70;
        this.forca += 5;
        this.level++;
    }

    public double attack() {
        double dano = inteligencia*level + Math.floor(Math.random()*(301));
        System.out.printf("Mago ataca causando %2f de dano", dano);
        return dano;
    }

    public void aprenderMagia(String magia) {
        this.magia.add(magia);
    }
}
