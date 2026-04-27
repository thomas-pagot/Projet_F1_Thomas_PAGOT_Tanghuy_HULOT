/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetf1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class F1Service {
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    // Récupérer les Grands Prix (Meetings) selon l'année
    public List<Meeting> fetchMeetings(int year) {
        try {
            String url = "https://api.openf1.org/v1/meetings?year=" + year;
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), new TypeToken<List<Meeting>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return new java.util.ArrayList<>(); // Retourne une liste vide en cas d'erreur
        }
    }

    // Récupérer les Pilotes (Drivers)
    public List<Driver> fetchDrivers(int meetingKey) {
        try {
            // On utilise meeting_key au lieu de session_key
            String url = "https://api.openf1.org/v1/drivers?meeting_key=" + meetingKey;
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), new TypeToken<List<Driver>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return new java.util.ArrayList<>();
        }
    }
    // Récupérer les tours (Laps) d'un pilote pour une session précise
    public List<Lap> fetchLaps(int sessionKey, int driverNumber) {
        try {
            String url = "https://api.openf1.org/v1/laps?session_key=" + sessionKey + "&driver_number=" + driverNumber;
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), new TypeToken<List<Lap>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return new java.util.ArrayList<>();
        }
    }
    // Récupérer la télémétrie de la voiture pour un pilote et une session
    public List<CarData> fetchCarData(int sessionKey, int driverNumber) {
        try {
            String url = "https://api.openf1.org/v1/car_data?session_key=" + sessionKey + "&driver_number=" + driverNumber;
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), new TypeToken<List<CarData>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return new java.util.ArrayList<>();
        }
    }
    // Trouver la clé de la Course (Race) pour un Grand Prix
    public int fetchRaceSessionKey(int meetingKey) {
        try {
            // On demande à l'API de chercher la session qui s'appelle "Race" (la course)
            String url = "https://api.openf1.org/v1/sessions?meeting_key=" + meetingKey + "&session_name=Race";
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // On traduit le JSON en liste de Sessions
            java.util.List<Session> sessions = gson.fromJson(response.body(), new TypeToken<java.util.List<Session>>(){}.getType());
            
            // Si on a trouvé la course, on renvoie sa vraie clé secrète !
            if (!sessions.isEmpty() && sessions.get(0).getSessionKey() != null) {
                return sessions.get(0).getSessionKey();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 9157; // Valeur de secours au cas où le GP n'a pas encore eu lieu
    }
    // Récupérer les positions X/Y d'une voiture (pour dessiner le circuit)
    public List<Location> fetchLocations(int sessionKey, int driverNumber) {
        try {
            String url = "https://api.openf1.org/v1/location?session_key=" + sessionKey + "&driver_number=" + driverNumber;
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), new TypeToken<List<Location>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return new java.util.ArrayList<>();
        }
    }
    // Récupérer le classement final d'une course
    public java.util.List<SessionResult> fetchRaceResults(int sessionKey) {
        try {
            String url = "https://api.openf1.org/v1/session_result?session_key=" + sessionKey;
            java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder().uri(java.net.URI.create(url)).build();
            java.net.http.HttpResponse<String> response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), new com.google.gson.reflect.TypeToken<java.util.List<SessionResult>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return new java.util.ArrayList<>();
        }
    }
}   