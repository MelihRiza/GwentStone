package main;

import fileio.CardInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TempPlayerDeck {
    String command = "getPlayerDeck";
    int playerIdx;
    ArrayList<CardsWithoutHealthAndAttackDmg> choosenDeck = new ArrayList<>();

//    public TempPlayerDeck(ArrayList<ArrayList<CardInput>> decks, Player player, int seed, int deckIdx) {
//        ArrayList<CardInput> temp = decks.get(deckIdx);
//        Collections.shuffle(temp, new Random(seed));
//        player.setPlayingDeck(temp);
//        for (int i = 0; i < temp.size(); i++) {
//            if (temp.get(i).getHealth() != 0) {
//                CardsWithHealthAndAttackDmg cardsWithHealth = new CardsWithHealthAndAttackDmg();
//                cardsWithHealth.setMana(temp.get(i).getMana());
//                cardsWithHealth.setAttackDamage(temp.get(i).getAttackDamage());
//                cardsWithHealth.setHealth(temp.get(i).getHealth());
//                cardsWithHealth.setDescription(temp.get(i).getDescription());
//                cardsWithHealth.setColors(temp.get(i).getColors());
//                cardsWithHealth.setName(temp.get(i).getName());
//                choosenDeck.add(cardsWithHealth);
//            }
//            else if (temp.get(i).getHealth() == 0 && temp.get(i).getAttackDamage() == 0) {
//                CardsWithoutHealthAndAttackDmg cardsWithoutHealthAndAttackDmg = new CardsWithoutHealthAndAttackDmg();
//                cardsWithoutHealthAndAttackDmg.setColors(temp.get(i).getColors());
//                cardsWithoutHealthAndAttackDmg.setDescription(temp.get(i).getDescription());
//                cardsWithoutHealthAndAttackDmg.setMana(temp.get(i).getMana());
//                cardsWithoutHealthAndAttackDmg.setName(temp.get(i).getName());
//                choosenDeck.add(cardsWithoutHealthAndAttackDmg);
//            }
////            else if (temp.get(i).getHealth() == 0 && temp.get(i).getAttackDamage() != 0) {
////                CardsWithoutHealth cardsWithoutHealth = new CardsWithoutHealth();
////                cardsWithoutHealth.setAttackDamage(temp.get(i).getAttackDamage());
////                cardsWithoutHealth.setName(temp.get(i).getName());
////                cardsWithoutHealth.setMana(temp.get(i).getMana());
////                cardsWithoutHealth.setDescription(temp.get(i).getDescription());
////                cardsWithoutHealth.setColors(temp.get(i).getColors());
////                choosenDeck.add(cardsWithoutHealth);
////            }
//        }
//        if (player.playerIdx == 1) {
//            player.setCardInHand(choosenDeck.get(0));
//            choosenDeck.remove(0);
//        } else if (player.playerIdx == 2) {
//            player.setCardInHand(choosenDeck.get(0));
//            choosenDeck.remove(0);
//        }
//        this.playerIdx = player.playerIdx;
//        //player.cardsLeftInHand = choosenDeck;
//    }

    public TempPlayerDeck(ArrayList<CardInput> deck, int playerIdx) {
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i).getHealth() != 0) {
                CardsWithHealthAndAttackDmg cardsWithHealth = new CardsWithHealthAndAttackDmg();
                cardsWithHealth.setMana(deck.get(i).getMana());
                cardsWithHealth.setAttackDamage(deck.get(i).getAttackDamage());
                cardsWithHealth.setHealth(deck.get(i).getHealth());
                cardsWithHealth.setDescription(deck.get(i).getDescription());
                cardsWithHealth.setColors(deck.get(i).getColors());
                cardsWithHealth.setName(deck.get(i).getName());
                choosenDeck.add(cardsWithHealth);
            }
            else if (deck.get(i).getHealth() == 0 && deck.get(i).getAttackDamage() == 0) {
                CardsWithoutHealthAndAttackDmg cardsWithoutHealthAndAttackDmg = new CardsWithoutHealthAndAttackDmg();
                cardsWithoutHealthAndAttackDmg.setColors(deck.get(i).getColors());
                cardsWithoutHealthAndAttackDmg.setDescription(deck.get(i).getDescription());
                cardsWithoutHealthAndAttackDmg.setMana(deck.get(i).getMana());
                cardsWithoutHealthAndAttackDmg.setName(deck.get(i).getName());
                choosenDeck.add(cardsWithoutHealthAndAttackDmg);
            }
            this.playerIdx = playerIdx;
        }
    }

    public String getCommand() {
        return command;
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public ArrayList<CardsWithoutHealthAndAttackDmg> getOutput() {
        return choosenDeck;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setPlayerIdx(int playerIdx) {
        this.playerIdx = playerIdx;
    }

    public void setOutput(ArrayList<CardsWithoutHealthAndAttackDmg> choosenDeck) {
        this.choosenDeck = choosenDeck;
    }

}
