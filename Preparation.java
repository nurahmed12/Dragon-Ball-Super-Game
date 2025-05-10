// Define the package for the class
package com.mycompany.dragon_ball_super_game;

// Import necessary Java utilities
import java.util.Scanner;
import java.util.Random;

// Implement the Fighters interface in the Preparation class
public class Preparation implements Fighters {
    // Create a Scanner object for user input
    Scanner s = new Scanner(System.in);

    // Create a Random object for generating random numbers
    Random r = new Random();

    // Declare variables for the chosen fighter code and opponent's index
    int choosen_code;
    int v;

    // Declare variables for opponent's name and power level
    String opponent;
    int opponent_power_lvl;

    // Declare variables for the chosen fighter's name and power level
    String choosen_fighter;
    int fighter_power_lvl;

    // Implement the chooseFighter method defined in the Fighters interface
    @Override
    public void chooseFighter() {
        // Generate a random index for selecting the opponent
        v = r.nextInt(fighter_names.length);

        // Assign opponent's name and power level based on the random index
        opponent = fighter_names[v];
        opponent_power_lvl = power_levels[v];

        // Display welcome and loading messages
        System.out.println("Welcome to Dragon Ball Super Game.");
        System.out.println("Here you have to fight in order to survive.");
        System.out.print("Loading Game.");
        
        // Pause execution for a short duration in a loop to simulate loading
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Internal Error.");
            }
            System.out.print("..");
        }

        // Display the list of available fighters
        System.out.println("\nHere are the list of all the available Fighters : ");
        for (int i = 0; i < fighter_names.length; i++) {
            System.out.printf("Code %d : %s \t\t", i + 1, fighter_names[i]);
            
            // Add a newline after half of the fighters for better formatting
            if (i == fighter_names.length / 2)
                System.out.println("");
        }

        // Prompt the user to choose a fighter and adjust the code accordingly
        System.out.println("\nChoose one of the given fighter : (Fighter Code)");
        choosen_code = s.nextInt();
        choosen_code -= 1; // Adjust the code to match array indexing

        // Assign the chosen fighter's name and power level based on the code
        choosen_fighter = fighter_names[choosen_code];
        fighter_power_lvl = power_levels[choosen_code];
    }
}
