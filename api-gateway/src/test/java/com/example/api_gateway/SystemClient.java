package com.example.api_gateway;

import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SystemClient {
    private static final String GATEWAY_URL = "http://localhost:8080/api";
    private static String jwtToken = "";
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Distributed Inventory System CLI ===");

        while (true) {
            System.out.println("\n1. Login\n2. View Inventory\n3. View Notifications\n4. Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> login(scanner);
                case "2" -> fetchInventory();
                case "3" -> fetchNotifications();
                case "4" -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        // In a real JWT setup, this would return a token. 
        // For now, we simulate the success.
        String json = "{\"username\":\"" + user + "\", \"password\":\"" + pass + "\"}";
        
        sendRequest("/auth/login", "POST", json);
        jwtToken = "dummy-token-for-demo"; 
        System.out.println("Logged in successfully!");
    }

    private static void fetchInventory() {
        System.out.println("--- Current Inventory ---");
        sendRequest("/products", "GET", null);
    }

    private static void fetchNotifications() {
        System.out.println("--- Notification History ---");
        sendRequest("/notifications/history", "GET", null);
    }

    private static void sendRequest(String path, String method, String body) {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder()
                    .uri(URI.create(GATEWAY_URL + path))
                    .header("Content-Type", "application/json");

            if (!jwtToken.isEmpty()) {
                builder.header("Authorization", "Bearer " + jwtToken);
            }

            if (method.equals("POST")) {
                builder.POST(HttpRequest.BodyPublishers.ofString(body));
            } else {
                builder.GET();
            }

            HttpResponse<String> response = httpClient.send(builder.build(), HttpResponse.BodyHandlers.ofString());
            System.out.println("Response: " + response.body());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}