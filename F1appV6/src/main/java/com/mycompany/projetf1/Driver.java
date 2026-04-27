/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetf1;

public class Driver {
    private String full_name;
    private int driver_number;
    private String team_name;

    public Driver() {}

    //getter
    public String getFullName() { return full_name; }
    public int getDriverNumber() { return driver_number; }
    public String getTeamName() { return team_name; }

    @Override
    public String toString() {
        return driver_number + " - " + full_name + " (" + team_name + ")";
    }
}