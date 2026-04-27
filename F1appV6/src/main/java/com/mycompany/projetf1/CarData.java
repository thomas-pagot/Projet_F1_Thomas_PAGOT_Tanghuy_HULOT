/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetf1;

/**
 *
 * @author thoma
 */
public class CarData {
    // On utilise Integer (avec majuscule) pour éviter les crashs si l'API renvoie du vide
    private Integer speed; 
    private Integer rpm;   
    private Integer drs;   

    public CarData() {}

    public Integer getSpeed() {
        return speed;
    }

    public Integer getRpm() {
        return rpm;
    }

    public Integer getDrs() {
        return drs;
    }
}
