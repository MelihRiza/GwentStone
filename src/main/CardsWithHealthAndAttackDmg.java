package main;

import java.util.ArrayList;

public class CardsWithHealth extends CardsWithoutHealthAndAttackDmg {
    //private int mana;
    private int attackDamage;
    private int health;
    //private String description;
    //private ArrayList<String> colors;
    //private String name;

    public CardsWithHealth() {
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return super.getMana();
    }

    public void setMana(final int mana) {
        super.setMana(mana);
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(final int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public String getDescription() {
        return super.getDescription();
    }

    public void setDescription(final String description) {
        super.setDescription(description);
    }

    public ArrayList<String> getColors() {
        return super.getColors();
    }

    public void setColors(final ArrayList<String> colors) {
        super.setColors(colors);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(final String name) {
        super.setName(name);
    }

}
