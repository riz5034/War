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
 * A class that describes the game of War card game
 * The objective of the game is to win all cards
 * The deck is divided evenly among the player and the AI, giving each a down stack
 * In unison, each player reveals the top card of their deck - the player with the
 * higher value wins and takes both cards played and moves them to their stack
 * Aces are high and suits are ignored
 * @author wisp
 */
public class War {
    
    public static String intro() {
        System.out.println("--War Card Game--\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        return name;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name = intro();
        Game game = new Game(name);
        game.start();

    }
    
}
