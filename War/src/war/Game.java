/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
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
public class Game {
    private Player player;
    private Player cpu;
    private ArrayList<Card> stage;  // Holds cards in stage
    private int cardsForWar;
    
    /**
     * Default constructor to initialize player names
     * @param playerName 
     */
    public Game(String playerName) {
        player = new Player(playerName);
        cpu = new Player("CPU");
        stage = new ArrayList<Card>();
        cardsForWar = 4;    // Number of face down cards + 1
    }
    
    /**
     * Setup each player's deck by shuffling a deck of 52 cards and dividing
     * the deck evenly between the player and the CPU
     */
    public void setup() {
        Deck deck = new Deck();
        int size = deck.getCards().size();
        deck.shuffle();
        
        Deck playerDeck = new Deck();
        playerDeck.setDeck(new ArrayList<Card>(deck.getCards().subList(0, size / 2)));       // Excluding size/2
        
        Deck cpuDeck = new Deck();
        cpuDeck.setDeck(new ArrayList<Card>(deck.getCards().subList(size / 2, size)));    // Excluding size

        player.setDeck(playerDeck);
        cpu.setDeck(cpuDeck);
    }
    
    /**
     * Check for game over conditions
     * If the player has all 52 cards and the CPU has 0 cards, player wins
     * If the CPU has all 52 cards and the player has 0 cards, CPU wins
     * @return true if game over, false if not game over
     */
    public boolean checkGameOver() {
        boolean gameOver = true;
        if(cpu.getDeck().getCards().size() == 0 && player.getDeck().getCards().size() == 0) {
            System.out.println("Draw!");
        } else if(cpu.getDeck().getCards().size() == 0) {
            System.out.println("You win!");
        } else if(player.getDeck().getCards().size() == 0) {
            System.out.println("You lose!");
        } else {
            // Game over conditions not met
            gameOver = false;
        }
        
        return gameOver;
    }
    
    /**
     * Displays the current battle with the amount of cards in both players deck
     * as well as the cards played on the field
     * @param playerCard
     * @param cpuCard 
     */
    public void displayBattle(Card playerCard, Card cpuCard) {
        System.out.println(String.format("%s [Deck: %d Card: %s]", player.getName(), player.getDeck().getSize(), playerCard.display()));
        System.out.println("VS");
        System.out.println(String.format("CPU [Deck: %d Card: %s]", cpu.getDeck().getCards().size(), cpuCard.display()));
    }
    
    /**
     * Simulates checking if the added cards from the stage becomes the new deck
     * and shuffles 
     * In the actual game, cards obtained are added faceup to the bottom of the 
     * deck and the deck is shuffled when the first card is reached
     */
    public void checkShuffle() {
        if(player.getDeck().getCards().get(0).getShuffle()) {
            player.getDeck().getCards().get(0).setShuffle(false);
            player.getDeck().shuffle();
            System.out.println("You shuffled your deck.");
        }
        
        if(cpu.getDeck().getCards().get(0).getShuffle()) {
            cpu.getDeck().getCards().get(0).setShuffle(false);
            cpu.getDeck().shuffle();
            System.out.println("CPU shuffled its deck.");
        }
        System.out.println("");
        
    }
    
    /**
     * Recursive method with three checks - one if the cards played have the 
     * same rank, another if the player has a greater rank than the cpu, and
     * last if the cpu has a greater tank than the player
     * Cards are added to the stage array list at the beginning of each battle
     * and only added to either player when one card has a higher value than the
     * other player
     */
    public void battle() {
        // Each player removes the first card from their deck
        // Player with higher rank keeps cards in stage list
        // If tie, players play the next 3 cards facedown followed by one face up
        // Continue until there is no tie or a player runs out of cards
        Card playerCard = player.getDeck().getCards().get(0);
        Card cpuCard = cpu.getDeck().getCards().get(0);
        
        stage.add(playerCard);
        stage.add(cpuCard);
        
        player.getDeck().getCards().remove(0);
        cpu.getDeck().getCards().remove(0);
        
        displayBattle(playerCard, cpuCard);
        
        if(playerCard.getRank().getValue() == cpuCard.getRank().getValue()) {
            if(player.getDeck().getSize() < cardsForWar && cpu.getDeck().getSize() < cardsForWar) {
                System.out.println("\nBoth players are out of cards for war.\n");
                player.getDeck().getCards().clear();
                cpu.getDeck().getCards().clear();
            } else if(player.getDeck().getSize() < cardsForWar) {
                System.out.println("\nYou are out of cards for war.\n");
                cpu.getDeck().getCards().addAll(player.getDeck().getCards());
                player.getDeck().getCards().clear();
            } else if(cpu.getDeck().getSize() < cardsForWar) {
                System.out.println("\nCPU is out of cards for war.\n");
                player.getDeck().getCards().addAll(cpu.getDeck().getCards());
                cpu.getDeck().getCards().clear();
            } else {
                // Remove the first 3 cards from each players deck and add
                // to stage
                // Then, battle
                for(int i = 0; i < cardsForWar - 1; i++) {
                    stage.add(player.getDeck().getCards().get(0));
                    stage.add(cpu.getDeck().getCards().get(0));

                    player.getDeck().getCards().remove(0);
                    cpu.getDeck().getCards().remove(0);
                }
                System.out.println("\nEach player adds 3 cards face down.\n");
                battle();
            }
        } else if(playerCard.getRank().getValue() > cpuCard.getRank().getValue()) {
            stage.get(0).setShuffle(true);
            player.getDeck().getCards().addAll(stage);
            System.out.println(String.format("\nYou win %d cards this round!\n", stage.size()));
            stage.clear();
        } else if(playerCard.getRank().getValue() < cpuCard.getRank().getValue()) {
            stage.get(0).setShuffle(true);
            cpu.getDeck().getCards().addAll(stage);
            System.out.println(String.format("\nCPU wins %d cards this round!\n", stage.size()));
            stage.clear();
        }
    }
    
    /**
     * Main logic to play game
     */
    public void play() {
        boolean gameover = false;
        int counter = 1;
        while(!gameover) {
            System.out.println(String.format("--- Round %d ---", counter));
            checkShuffle();
            battle();
            gameover = checkGameOver();
            counter++;
            
            // Comment this section out to print out all rounds at once
            
            System.out.println("Press \"ENTER\" to continue...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine(); 
        }
    }
    
    public void start() {
        setup();
        play();
        
    }
}
