/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Iterator;

/**
 *
 * @author ConnorReilly
 */
public class Hand extends CardCollection {
    private int score;
    public static final int BUST_LIMIT = 21;
    private static final int REDUCE_AMOUNT = 10;
    
    public Hand() {
        super();
        score = 0;
    }
    
    // Score hand
    private void setScore() {
        score = 0;
        for (Card card : cards)
            score += card.score();
        if (score > BUST_LIMIT) {
            for (Card card : cards) {
                if (card.getRank() == Rank.ACE && !card.reduce) {
                    card.reduce = true;
                    score -= REDUCE_AMOUNT;
                    break;
                }
            }
        }
    }
    
    public int getScore() { return score; }
    
    public void add(Card card) {
        cards.add(card);
        setScore();
    }
    
    @Override
    public String toString() {
        String str = "";
        int count = 0;
        for (Iterator<Card> it = cards.iterator(); it.hasNext();) {
            Card card = it.next();
            str = str.concat(card.toString());
            str = str.concat(" (" + card.score() + ")");
            count++;
            if (it.hasNext()) {
                str = str.concat(",");
                if (count == CARDS_PER_LINE)
                    str = str.concat("\n");
                else
                    str = str.concat(" ");
            }
        }
        return str;
    }
}
