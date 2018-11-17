/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * The main class that will call all other classes to play the War card game
 * @author wisp
 */
public class War {
    /**
     * Displays text for user to enter their name
     * @return the player name
     */
    public static String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("");
        return name;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name = getPlayerName();
        Game game = new Game(name);
        game.start();

    }
    
}
