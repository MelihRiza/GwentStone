package main;

import fileio.CardInput;
import fileio.DecksInput;

import java.util.ArrayList;

public class Temp {
    String command = "getPlayerDeck";
    int playerIdx;
    //ArrayList<ArrayList<CardInput>> output;
    //DecksInput output;
    ArrayList<DecksInput> decksInputs;

    public Temp(ArrayList<DecksInput> decksInputs, int playerIdx) {
        this.decksInputs = decksInputs;
        this.playerIdx = playerIdx;
    }

    public String getCommand() {
        return command;
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public ArrayList<DecksInput> getOutput() {
        return decksInputs;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setPlayerIdx(int playerIdx) {
        this.playerIdx = playerIdx;
    }

    public void setOutput(ArrayList<DecksInput> output) {
        this.decksInputs = output;
    }

    @Override
    public String toString() {
        return " ";
    }
}
