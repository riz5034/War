/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

/**
 * A class that represents a playing card
 * It contains a suit and a rank
 * @author wisp
 */
public class Card {
    private Suit suit;
    private Rank rank;
    private boolean shuffle;
    
    /**
     * Default constructor for card
     * @param suit 
     * @param rank 
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.shuffle = false;
    }
    
    /**
     * Access the suit field
     * @return the suit 
     */
    public Suit getSuit() {
        return suit;
    }
    
    /**
     * Access for rank field
     * @return the rank
     */
    public Rank getRank() {
        return rank;
    }
    
    /**
     * Access to get shuffle field
     * @return the shuffle boolean
     */
    public boolean getShuffle() {
        return shuffle;
    }
    
    /**
     * Access to set shuffle field
     * @param shuffle the shuffle boolean
     */
    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }
    
    /**
     * Display the rank and suit of the card
     */
    public String display() {
        return String.format("%s of %s", rank, suit);
    }
}
