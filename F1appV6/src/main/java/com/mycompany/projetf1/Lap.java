/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetf1;

/**
 *
 * @author thoma
 */
public class Lap {
    // On utilise Double et Integer (avec majuscule) au lieu de double et int
    // C'est très important car certains tours sont incomplets (crash, stand) et l'API renvoie "null" !
    private Double lap_duration; 
    private Integer st_speed;    

    public Lap() {}

    public Double getLapDuration() { 
        return lap_duration; 
    }
    
    public Integer getStSpeed() { 
        return st_speed; 
    }
}  