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
    
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
    
    // Accessor for suit field
    public Suit getSuit() {
        return suit;
    }
    
    // Accessor for rank field
    public Rank getRank() {
        return rank;
    }
    
    public void display() {
        System.out.println(String.format("%s of %s", rank, suit));
    }
}
