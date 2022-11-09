package main;

import checker.Checker;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import checker.CheckerConstants;
import fileio.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * The entry point to this homework. It runs the checker that tests your implentation.
 */
public final class Main {
    /**
     * for coding style
     */
    private Main() {
    }

    /**
     * DO NOT MODIFY MAIN METHOD
     * Call the checker
     * @param args from command line
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File(CheckerConstants.TESTS_PATH);
        Path path = Paths.get(CheckerConstants.RESULT_PATH);

        if (Files.exists(path)) {
            File resultFile = new File(String.valueOf(path));
            for (File file : Objects.requireNonNull(resultFile.listFiles())) {
                file.delete();
            }
            resultFile.delete();
        }
        Files.createDirectories(path);

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String filepath = CheckerConstants.OUT_PATH + file.getName();
            File out = new File(filepath);
            boolean isCreated = out.createNewFile();
            if (isCreated) {
                action(file.getName(), filepath);
            }
        }

        Checker.calculateScore();
    }

    /**
     * @param filePath1 for input file
     * @param filePath2 for output file
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void action(final String filePath1,
                              final String filePath2) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Input inputData = objectMapper.readValue(new File(CheckerConstants.TESTS_PATH + filePath1),
                Input.class);

        ArrayNode output = objectMapper.createArrayNode();

        //TODO add here the entry point to your implementation
        Decks decks = new Decks();
        decks.readCards(inputData);
        decks.writeToJson(inputData, output);

//        ArrayList<GameInput> jocuri = inputData.getGames();
//        for (GameInput joc : jocuri) {
//            ArrayList<ActionsInput> actiuni = joc.getActions();
//            for (ActionsInput actiune : actiuni) {
//                if (actiune.getCommand().equals("getPlayerDeck")) {
//                    int whatPlayer = actiune.getPlayerIdx();
//                    System.out.println(whatPlayer);
//                        if (whatPlayer == 1) {
//                            ArrayList<ArrayList<CardInput>> lista = inputData.getPlayerOneDecks().getDecks();
//////                            ArrayNode arrayNode = (ArrayNode) objectMapper.readTree(string).get("InfoInput");
//////                            if (arrayNode.isArray()) {
//////                                output.add(arrayNode);
//////                            }
////                            ObjectNode command = objectMapper.createObjectNode();
////                            for (ArrayList<CardInput> arrayList : lista) {
////                                for (CardInput cardInput : arrayList) {
////                                    command.put("")
////                                }
////                            }
//                            Temp temp = new Temp(inputData.getPlayerOneDecks().getDecks(), whatPlayer);
//                            String inp = inputData.getPlayerOneDecks().getDecks().toString();
//                            output.addPOJO(temp);
//
//                        }
//                        else {
//                            //output.add(inputData.getPlayerTwoDecks().toString());
////                            ObjectNode command = objectMapper.createObjectNode();
////                            command.put("command", "getPlayerDeck");
////                            command.put("playerIdx", whatPlayer);
////
////                            output.add(command);
////                            Temp temp = new Temp(inputData.getPlayerTwoDecks().getDecks(), whatPlayer);
////                            String inp = inputData.getPlayerTwoDecks().getDecks().toString();
////                            output.addPOJO(temp);
//                            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//                            Temp temp = new Temp(inputData.getPlayerTwoDecks().getDecks(), whatPlayer);
//                            JsonNode node = objectMapper.valueToTree(temp);
//                            output.add(node);
//                        }
//                    }
//                }
//            }

        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(filePath2), output);
    }
}
