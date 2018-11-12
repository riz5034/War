/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

/**
 * An enumueration to capture the rank of a card
 * The card rank from highest to lowest is A,K,Q,J,10,9,8,7,6,5,4,3,2
 * This will be used to compare values of ranks
 * @author wisp
 */
public enum Rank {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);
    
    private final int value;
    
    /**
     * Default constructor of rank enumeration
     * @param rank 
     */
    private Rank(int rank) {
        this.value = rank;
    }
    
    /**
     * Access for value of rank
     * @return the value
     */
    public int getValue() {
        return value;
    }
}
