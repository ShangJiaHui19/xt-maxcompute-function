package com.xt.udtf;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;


public class JsonArrayToRowsUDTFTest {

    @Test
    public void main() {
        String jsonString = "[{\"name\":\"a\",\"age\":\"1\"},{\"name\":\"b\",\"age\":\"2\"}]";
        parseAndPrint(jsonString);
    }

    private void parseAndPrint(String jsonString) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Map<String, String>>>(){}.getType();

        try {
            List<Map<String, String>> jsonArray = gson.fromJson(jsonString, listType);
            if (jsonArray != null && !jsonArray.isEmpty()) {
                for (Map<String, String> jsonObject : jsonArray) {
                    System.out.println(jsonObject);
                }
            } else {
                throw new IllegalArgumentException("Parsed JSON array is null or empty.");
            }
        } catch (Exception e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
        }
    }
}
