package main;

import fileio.CardInput;

public class TempPlayerHero {
    public String command = "getPlayerHero";
    public int playerIdx;
    public CardsWithoutAttack output = new CardsWithoutAttack();

    public TempPlayerHero(CardInput hero, int playerIdx) {
        if (hero.getAttackDamage() == 0) {
            output.setDescription(hero.getDescription());
            output.setColors(hero.getColors());
            output.setMana(hero.getMana());
            output.setName(hero.getName());
            output.setHealth(30);
        }
        this.playerIdx = playerIdx;
    }
}
