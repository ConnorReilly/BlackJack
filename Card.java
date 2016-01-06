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
public class Card {
    private final Rank rank;    // This card's rank
    private final Suit suit;    // This card's suit
    public boolean reduce;      // Indicates whether this card's score has been
                                //      reduced (applies to ACE only)
    
    public Card(Rank rank, Suit suit, boolean reduce) { 
        this.rank = rank;   this.suit = suit;   this.reduce = reduce;
    }
    
    public Rank getRank() { return rank; }
    public Suit getSuit() { return suit; }
    
    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }
    
    // Calculates this card's current score
    /**
     * @return this card's current score
     */
    public int score() { 
        int score;
        switch (rank) {
            case ACE:
                if (reduce)
                    score = 1;
                else
                    score = 11;
                break;
            case TWO:
                score = 2;
                break;
            case THREE:
                score = 3;
                break;
            case FOUR:
                score = 4;
                break;
            case FIVE:
                score = 5;
                break;
            case SIX:
                score = 6;
                break;
            case SEVEN:
                score = 7;
                break;
            case EIGHT:
                score = 8;
                break;
            case NINE:
                score = 9;
                break;
            default:
                score = 10;
        }
        return score;
    }
    
}
