/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ConnorReilly
 */
abstract public class CardCollection {
    protected ArrayList<Card> cards;
    protected static final int CARDS_PER_LINE = 3;
    
    public CardCollection() { cards = new ArrayList<>(); }
    
    @Override
    public String toString() {
        String str = "";
        int count = 0;
        for (Iterator<Card> it = cards.iterator(); it.hasNext();) {
            Card card = it.next();
            str = str.concat(card.toString());
            count++;
            if (it.hasNext())
                str = str.concat(", ");
            if (count == CARDS_PER_LINE) {
                str = str.concat("\n");
                count = 0;
            }
        }
        return str;
    }
    
}
