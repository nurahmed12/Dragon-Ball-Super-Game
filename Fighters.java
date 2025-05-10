// Define an interface named Fighters
package com.mycompany.dragon_ball_super_game;

// Declare an interface with the name Fighters
interface Fighters {
    // Declare an array of fighter names
    String[] fighter_names = {"Goku", "Vegeta", "Gohan", "Piccolo", "Krillin", "Goten", "Trunks", "Frieza", "Master Roshi", "Tien", "Broly", "Jiren", "Toppo", "Dispo", "Hit"};
    
    // Declare an array of power levels corresponding to the fighters
    int[] power_levels = {100000, 99000, 85000, 50000, 30000, 1500, 1400, 100000, 800, 1000, 200000, 180000, 98000, 99000, 100000};
    
    // Declare an abstract method for choosing a fighter
    void chooseFighter();
}

