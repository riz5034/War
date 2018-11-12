/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

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

    public void setupGame() {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test code
        Card card = new Card(Suit.CLUBS, Rank.KING);
        Player player = new Player("Ricky");
        player.getDeck().add(card);
        player.getDeck().add(new Card(Suit.HEARTS, Rank.ACE));
        for(Card cd : player.getDeck()) {
            cd.display();
        }
    }
    
}
