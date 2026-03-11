package com.f1; // Très important : indique dans quel dossier on se trouve

// Voici les fameux "imports" qui manquaient pour que Java comprenne les commandes :
import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {

    public static void main(String[] args) {
        // Création de la fenêtre principale
        JFrame frame = new JFrame("F1 Archives - Saison 2023");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> meetingsList = new JList<>(listModel);
        meetingsList.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JScrollPane scrollPane = new JScrollPane(meetingsList);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Connexion à l'API OpenF1
        try {
            String apiUrl = "https://api.openf1.org/v1/meetings?year=2023";
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONArray meetingsArray = new JSONArray(response.body());

            // Lecture et affichage des données JSON
            for (int i = 0; i < meetingsArray.length(); i++) {
                JSONObject meeting = meetingsArray.getJSONObject(i);
                
                String gpName = meeting.optString("meeting_name", "Nom inconnu");
                String country = meeting.optString("country_name", "Pays inconnu");
                String date = meeting.optString("date_start", "Date inconnue");

                if (date.length() > 10) {
                    date = date.substring(0, 10);
                }

                listModel.addElement(date + "  |  " + country + "  |  " + gpName);
            }

        } catch (Exception e) {
            e.printStackTrace();
            listModel.addElement("Erreur de connexion à l'API OpenF1.");
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}