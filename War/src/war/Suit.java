/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

/**
 * An enumeration to capture the suits of a card
 * @author wisp
 */
public enum Suit {
    SPADES("Spade"),
    CLUBS("Club"),
    DIAMONDS("Diamond"),
    HEARTS("Heart");
    
    // Can not change at run time
    private final String suit;
    
    // Constructor to set value
    private Suit(String suit) {
        this.suit = suit;
    }
    
    // Accessor for suit field
    public String getSuit() {
        return suit;
    }
}
