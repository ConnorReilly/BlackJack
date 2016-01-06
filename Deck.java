/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ConnorReilly
 */
public class Deck extends CardCollection {
    private int size = 0;
    
    public Deck() {
        rebuild();
    }
    
    // Builds deck
    public final void rebuild() {
        cards = new ArrayList<>();
        for (Rank rank : Rank.values())
            for (Suit suit : Suit.values()) {
                cards.add(new Card(rank, suit, false));
                size++;
            }
    }
    
    // Draw a card from the top of the deck
    /**
     * @return the card on top of the deck
     */
    public Card draw() {
        return cards.remove(0);
    }
    
    // Shuffles the deck
    public void shuffle() {
        Random random = new Random();
        Card card;
        ArrayList<Card> temp = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            card = cards.remove(random.nextInt(size-i));
            temp.add(card);
        }
        cards = temp;
    }
    
}
