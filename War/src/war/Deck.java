/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class that represents a physical deck of playing cards
 * @author wisp
 */
public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();
    
    /**
     * Default constructor that will initialize the deck to 52 playing cards
     * of corresponding suit and rank
     */
    public Deck() {
        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }
    
    /**
     * Display the cards in the deck
     */
    public void display() {
        for(Card card : cards) {
            card.display();
        }
    }
    
    /**
     * Shuffle the cards in the deck
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public void setDeck(ArrayList<Card> subDeck) {
        cards = subDeck;
    }
    
    /**
     * Access to get deck
     * @return the deck
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
        
}
