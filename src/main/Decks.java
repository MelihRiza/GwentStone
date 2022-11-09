package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Decks {

    public ArrayList<DecksInput> player1Decks = new ArrayList<>();
    public ArrayList<DecksInput> player2Decks = new ArrayList<>();

    public void readCards(Input input) {
        player1Decks.add(input.getPlayerOneDecks());
        //System.out.println(player1Decks);
        player2Decks.add(input.getPlayerTwoDecks());
    }

    public void shuffleDecks(int seed) {
        Collections.shuffle(player1Decks, new Random(seed));
        //System.out.println(player1Decks);
        Collections.shuffle(player2Decks, new Random(seed));
    }

    public void writeToJson(Input inputData, ArrayNode output) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<GameInput> jocuri = inputData.getGames();
        System.out.println(jocuri);
        for (GameInput joc : jocuri) {
            readCards(inputData);
            //shuffleDecks(joc.getStartGame().getShuffleSeed());
            Collections.shuffle(player1Decks, new Random(joc.getStartGame().getShuffleSeed()));
            Collections.shuffle(player2Decks, new Random(joc.getStartGame().getShuffleSeed()));
            System.out.println(joc.getStartGame().getShuffleSeed());
            ArrayList<ActionsInput> actiuni = joc.getActions();
            for (ActionsInput actiune : actiuni) {
                if (actiune.getCommand().equals("getPlayerDeck")) {
                    int whatPlayer = actiune.getPlayerIdx();
                    System.out.println(whatPlayer);
                    if (whatPlayer == 1) {

                        Temp temp = new Temp(player1Decks, whatPlayer);
                        output.addPOJO(temp);
                    } else {
                        Temp temp = new Temp(player2Decks, whatPlayer);
                        output.addPOJO(temp);
                    }
                }
            }
        }
    }


    public static String stringify(Object o) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
            printer.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
            return mapper.writer(printer).writeValueAsString(o);
        } catch (Exception e) {
            return null;
        }
    }
}
