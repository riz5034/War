/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;

/**
 * A class that represents the War card game
 * It contains fields to capture 2 players and methods
 * that the card game can do
 * @author wisp
 */
public class Game {
    private Player player;
    private Player cpu;
    private Deck deck;
    
    /**
     * Default constructor to initialize player names
     * @param playerName 
     */
    public Game(String playerName) {
        deck = new Deck();
        player = new Player(playerName);
        cpu = new Player("CPU");
    }
    
    /**
     * Setup each player's deck by shuffling a deck of 52 cards and dividing
     * the deck evenly between the player and the CPU
     */
    public void setup() {
        int size = deck.getDeck().size();
        deck.shuffle();
        
        player.setDeck(new ArrayList<Card>(deck.getDeck().subList(0, size / 2)));   // Excluding size/2
        cpu.setDeck(new ArrayList<Card>(deck.getDeck().subList(size / 2, size)));   // Excluding size
    }
    
    public boolean checkGameOver() {
        boolean gameOver = true;
        if((player.getDeck().size() == deck.getDeck().size()) && cpu.getDeck().size() == 0) {
            System.out.println("You win!");
        } else if((cpu.getDeck().size() == deck.getDeck().size()) && player.getDeck().size() == 0) {
            System.out.println("You lose!");
        } else {
            // Game over conditions not met
            gameOver = false;
        }
        
        return gameOver;
    }
    
    /**
     * Check for game over conditions
     */
    public void play() {
        boolean gameover = false;
        
        while(!gameover) {
            // do stuff
            
            // Check game over condition
            gameover = checkGameOver();
        }
    }
    
    public void start() {
        setup();
        
    }    
}
