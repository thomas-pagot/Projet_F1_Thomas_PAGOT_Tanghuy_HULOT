/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetf1;

public class Meeting {
   // --- LES VARIABLES (Tout en haut) ---
    private Integer meeting_key;    // <-- LA NOUVELLE LIGNE EST ICI
    private String meeting_name;
    private String country_name;
    private String date_start;

    // --- LE CONSTRUCTEUR ---
    public Meeting() {}

    // --- LES MÉTHODES (En bas) ---
    
    // <-- LA NOUVELLE MÉTHODE EST ICI
    public Integer getMeetingKey() {
        return meeting_key;
    }

    @Override
    public String toString() {
        // On formate l'affichage pour que ça soit lisible
        return "Nom : " + meeting_name +
               " | Pays : " + country_name +
               " | Date : " + date_start;
    }
}