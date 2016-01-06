/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author ConnorReilly
 */
public class Dealer {
    private Deck deck;
    private Hand hand;
    private final int HIT_LIMIT = 17;
    public static final int BUST_LIMIT = Hand.BUST_LIMIT;
    
    public Dealer() {
        reset();
    }
    
    public String handToString() {
        return hand.toString();
    }
    
    public String deckToString() {
        return deck.toString();
    }
    
    public Card hit() {
        return deck.draw();
    }
    
    public int scoreHand() {
        return hand.getScore();
    }
    
    public void shuffleDeck() {
        deck.shuffle();
    }
    
    /**
     * @return true if busted
     */
    public boolean play() {
        hand.add(hit());
        hand.add(hit());
        while (hand.getScore() < HIT_LIMIT)
            hand.add(hit());
        return hand.getScore() > BUST_LIMIT;
    }
    
    final public void reset() {
        deck = new Deck();
        hand = new Hand();
    }
    
}
