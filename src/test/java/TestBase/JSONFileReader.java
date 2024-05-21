package TestBase;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONFileReader {


    public static  JsonNode getPlatformNode(String filePath, String platformName) {
        try {
            File file = new File(filePath);
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the root node of the JSON file
            JsonNode rootNode = objectMapper.readTree(file);

            // Retrieve the node specific to the platform
            return rootNode.path(platformName);

        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null in case of an error
        }
    }



}
