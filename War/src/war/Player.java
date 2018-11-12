/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;

/**
 * A class that represents a player of the game
 * It contains a list that will represent the player deck as well as methods
 * that a player can perform
 * @author wisp
 */
public class Player {
    private String name;
    private ArrayList<Card> deck = new ArrayList<>();
    
    /**
     * Default constructor to player that will initialize the name
     * @param name 
     */
    public Player(String name) {
        this.name = name;
    }
    
    /**
     * Access to get the player name
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Access to get the player deck
     * @return the deck
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }
    
    /**
     * Access to set the player deck
     * @param deck 
     */
    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
}
