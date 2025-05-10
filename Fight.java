package com.mycompany.dragon_ball_super_game; // Package declaration for the game

import java.util.Random; // Importing the Random class for generating random numbers
import java.util.Scanner; // Importing the Scanner class for user input

// Fight class, extending the Preparation class
public class Fight extends Preparation {
    // Initial health values for the opponent and chosen fighter
    private int opponent_initial_health = 1000;
    private int choosen_fighter_initial_health = 1000;

    // Random number generator and Scanner for user input
    Random n = new Random();
    Scanner s = new Scanner(System.in);

    // Array of moves and corresponding damage values
    String[] moves = {" Regular Kick", " Intense Punch", " Signature Move(+100 dmg)", " Sensu Beans(Restores +300 hp)", " Regular Punch", " Intense Kick", " Ultra Sonic Scream", " Headpot", " Energy Blast", " Heat Vision", " Energy Beam"};
    int[] dmg = {50, 60, 100, 0, 20, 70, 30, 10, 150, 250, 200};

    // Method to handle the fight
    public void fight() {
        // Displaying fight initiation messages
        System.out.println("\n\t\tLet's start the fight"); // Starting the fight message
        System.out.println("Your opponent is : " + opponent); // Displaying opponent name
        System.out.println(choosen_fighter + " V/S " + opponent); // Displaying fighter versus opponent
        System.out.println("Fight Started....."); // Displaying fight start message

        // Variables to track Sensu Beans, Signature Moves, and damage taken
        int sensu_bean = 0; // Counter for opponent's Sensu Beans
        int sig_move = 0; // Counter for opponent's Signature Moves
        int dmg_taken; // Variable to store damage taken
        int player_sensu_bean = 0; // Counter for player's Sensu Beans
        int player_sig_move = 0; // Counter for player's Signature Moves
        int player_dmg_taken; // Variable to store player's damage taken
        int move_code; // Variable to store the player's chosen move code

        // Main loop for the fight
        while (opponent_initial_health >= 1 && choosen_fighter_initial_health >= 1) {
            // Opponent randomly selects a move
            int p = n.nextInt(moves.length);
            String opponent_move = moves[p];

            // Check opponent's move and apply effects
            if (" Sensu Beans(Restores +300 hp)".equals(opponent_move) && sensu_bean == 0) {
                System.out.println("Opponent used his only sensu bean to restore 300 hp."); // Displaying opponent's Sensu Beans usage
                sensu_bean += 1;
                choosen_fighter_initial_health = Math.min(choosen_fighter_initial_health + 300, 1000);
                System.out.println("Opponent's Health = " + choosen_fighter_initial_health); // Displaying opponent's health
            } else if (" Signature Move(+100 dmg)".equals(opponent_move) && sig_move < 3) {
                System.out.printf("%s hits you first with a %s\n", opponent, opponent_move); // Displaying opponent's Signature Move usage
                dmg_taken = (fighter_power_lvl < opponent_power_lvl) ? dmg[p] + 200 : dmg[p];
                opponent_initial_health = opponent_initial_health - (dmg_taken + 100);
                System.out.printf("%d damage taken from that special attack.\n", dmg_taken + 100); // Displaying damage taken by the player
                System.out.println("Your Health = " + opponent_initial_health); // Displaying player's health
                sig_move += 1;
            } else if (!" Sensu Beans(Restores +300 hp)".equals(opponent_move) && !" Signature Move(+100 dmg)".equals(opponent_move)) {
                System.out.printf("%s hits you first with a %s\n", opponent, opponent_move); // Displaying opponent's regular attack
                dmg_taken = (fighter_power_lvl < opponent_power_lvl) ? dmg[p] + 200 : dmg[p];
                opponent_initial_health = opponent_initial_health - dmg_taken;
                System.out.printf("%d damage taken from that attack.\n", dmg_taken); // Displaying damage taken by the player
                System.out.println("Your Health = " + opponent_initial_health); // Displaying player's health
            } else {
                continue; // Continue to the next iteration if opponent's move is Sensu Beans or Signature Move
            }
            
            // Break out of the loop if opponent's health is 0 or below
            if(opponent_initial_health <= 0)
                break;

            // Display available moves for the player to choose from
            System.out.println("\n\n\n\nChoose a move quickly!!");
            System.out.println("Here are all the moves, choose one (Move code)");
            for (int i = 0; i < moves.length; i++) {
                System.out.printf("Code %d : %s \t\t", i + 1, moves[i]);
                if (i == moves.length / 2)
                    System.out.println("");
            }
            System.out.printf("\nFight back with : ");
            move_code = s.nextInt();
            move_code -= 1;

            String player_move = moves[move_code];

            // Check player's move and apply effects
            if (" Sensu Beans(Restores +300 hp)".equals(player_move) && player_sensu_bean == 0) {
                System.out.println("You have used your only sensu bean to restore 300 hp."); // Displaying player's Sensu Beans usage
                sensu_bean += 1;
                opponent_initial_health = Math.min(opponent_initial_health + 300, 1000);
                System.out.println("\n\n\nYour Health = " + opponent_initial_health); // Displaying player's health
                player_sensu_bean += 1;
            } else if (" Signature Move(+100 dmg)".equals(player_move) && player_sig_move < 3) {
                System.out.printf("\n%s stroke your opponent %s with %s\n", choosen_fighter, opponent, player_move); // Displaying player's Signature Move usage
                player_dmg_taken = (fighter_power_lvl > opponent_power_lvl) ? dmg[move_code] + 200 : dmg[move_code];
                choosen_fighter_initial_health = choosen_fighter_initial_health - (player_dmg_taken + 100);
                System.out.printf("\n%d damage landed on the opponent %s from that special attack.\n", player_dmg_taken + 100, opponent); // Displaying damage dealt to the opponent
                System.out.println("\n\n\nOpponent Health = " + choosen_fighter_initial_health); // Displaying opponent's health
                player_sig_move += 1;
            } else if (!" Sensu Beans(Restores +300 hp)".equals(player_move) && !" Signature Move(+100 dmg)".equals(player_move)) {
                System.out.printf("%s stroke your opponent %s with %s\n", choosen_fighter, opponent, player_move); // Displaying player's regular attack
                player_dmg_taken = (fighter_power_lvl > opponent_power_lvl) ? dmg[move_code] + 200 : dmg[move_code];
                choosen_fighter_initial_health = choosen_fighter_initial_health - player_dmg_taken;
                System.out.printf("\n%d damage landed on the opponent %s from that attack.\n", player_dmg_taken, opponent); // Displaying damage dealt to the opponent
                System.out.println("\n\n\nOpponent Health = " + choosen_fighter_initial_health); // Displaying opponent's health
            } else if (player_sensu_bean != 0) {
                System.out.println("\n\nYou have used your only sensu bean to restore 300 hp. You don't have any sensu beans now."); // Displaying player's Sensu Beans usage
            } else {
                System.out.println("\n\nYou can't use your special move more than 3 times in a match."); // Displaying special move usage limit message
            }

            // Sleep for 1 second
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Internal Error."); // Displaying internal error message
            }
        }

        // Display the result of the fight
        if (opponent_initial_health <= 0) {
            System.out.printf("\n\n\n\nYou have lost the match against %s\tBetter luck next time.\n", opponent); // Displaying defeat message
        } else if (choosen_fighter_initial_health <= 0 && ("Broly".equals(opponent) || "Jiren".equals(opponent))) {
            System.out.printf("\n\n\n\nOMG!! You have defeated %s\t he is impossible to defeat.", opponent); // Displaying victory against tough opponent message
        } else {
            System.out.printf("\n\n\n\nCongratulations, you have defeated %s", opponent); // Displaying victory message
        }
    }
}
