package main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EnvironmentCardErrorToJson {
    int handIdx;
    ArrayNode output;

    public EnvironmentCardErrorToJson(int handIdx, ArrayNode output) {
        this.handIdx = handIdx;
        this.output = output;
    }

    public void throwError() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode envPlacementError = objectMapper.createObjectNode();
        envPlacementError.put("command", "placeCard");
        envPlacementError.put("error", "Cannot place environment card on table.");
        envPlacementError.put("handIdx", handIdx);
        output.add(envPlacementError);
    }
}
