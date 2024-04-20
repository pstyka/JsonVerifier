package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonVerifier {

    public static Boolean verifyJson(String json) throws JSONException {

        JSONObject jsonObject = new JSONObject(json);
        JSONArray statementList = jsonObject
                .getJSONObject("PolicyDocument")
                .getJSONArray("Statement");
        for(int i=0;i<statementList.length();i++){
            JSONObject statement = statementList.getJSONObject(i);
            String resourceField = statement.getString("Resource");
            if ("*".equals(resourceField)) {
                return false;
            }
        }
        return true;
    }
    public static String readJSONFile(String path) throws IOException {
        Path p = Paths.get(path);
        byte[] bytes = Files.readAllBytes(p);
        return new String(bytes);
    }

    public static void main(String[] args) {
        String path = "src/main/resources/valid.json";
        try {
            String content = readJSONFile(path);
            boolean isJsonValid = verifyJson(content);
            System.out.println(isJsonValid
                    ? "JSON is valid"
                    : "JSON is not valid");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e){
            throw new JSONException(e);
        }


    }
}
