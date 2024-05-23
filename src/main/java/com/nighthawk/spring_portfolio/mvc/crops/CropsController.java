package com.nighthawk.spring_portfolio.mvc.crops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
public class CropsController {

    @GetMapping("/corn")
    public ResponseEntity<String> calcCornPrice() {
        String price = null;
        HttpURLConnection connection = null;
        InputStream responseStream = null;

        try {
            URL url = new URL("https://api.api-ninjas.com/v1/commodityprice?name=Corn");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("X-Api-Key", "YOUR_API_KEY"); // Replace with your actual API key

            int status = connection.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK) {
                System.err.println("Error: Received HTTP status code " + status);
                InputStream errorStream = connection.getErrorStream();
                if (errorStream != null) {
                    String errorResponse = new BufferedReader(new InputStreamReader(errorStream))
                            .lines()
                            .reduce("", (acc, line) -> acc + line + "\n");
                    System.err.println("Error response: " + errorResponse);
                }
                return ResponseEntity.status(status).body("Error fetching corn price");
            }

            responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);
            price = root.path("price").asText(); // Adjust path according to actual API response structure

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(502).body("Bad Gateway: Unable to fetch corn price");
        } finally {
            if (responseStream != null) {
                try {
                    responseStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        return ResponseEntity.ok(price);
    }
}