/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

/**
 *
 * @author wisp
 */
public enum Suit {
    SPADE("Spade"),
    CLUB("Club"),
    DIAMOND("Diamond"),
    HEART("Heart");
    
    // Can not change at run time
    private final String suit;
    
    // Constructor to set value
    private Suit(String suit) {
        this.suit = suit;
    }
    
    public String display() {
        return suit;
    }
}
