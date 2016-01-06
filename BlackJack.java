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
public class BlackJack {
    private static final int BUFFER_SIZE = 1000;
    private static final int BUST_LIMIT = Dealer.BUST_LIMIT;
    private static final char PLAY = 'p';
    private static final char QUIT = 'q';
    private static final char HIT = '1';
    private static final char STAND = '2';
    private static final char NL = '\n';
    private static final String DRAW = "It's a push!";
    private static final String PLAYER_WIN = "Player wins!";
    private static final String DEALER_WIN = "Dealer wins!";
    private static final String BAD_INPUT = "Please enter a valid character.";
    private static final String BUSTED = "Busted!";
    private static final String DEALER_BUSTED = "Dealer busted!";
    private static final String WELCOME = "Welcome to Connor's BlackJack game!"; 
    private static final String BREAK = WELCOME.replaceAll(".", "-"); 
    private static final String SCORE = "Score:";
    private static final String PLAYER_HAND = "Player hand:";
    private static final String DEALER_HAND = "Dealer hand:";
    private static final String MAIN_MENU_TITLE = "Main Menu:";
    private static final String MAIN_MENU_OPTIONS = "Enter " + PLAY + " to play" 
                                        + NL + "Enter " + QUIT + " to quit";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte[] b;
        char c = ' ';
        System.out.println(BREAK + NL + WELCOME + NL + BREAK + NL);
        do {
            b = new byte[BUFFER_SIZE];
            System.out.println(MAIN_MENU_TITLE + NL + MAIN_MENU_OPTIONS);
            try {
                System.in.read(b, 0, 1);
                c = (char) b[0];
                System.out.println(System.in.available());
                switch (c) {
                    case PLAY:
                        System.out.println(NL + BREAK + NL);
                        play();
                        break;
                    case QUIT:
                        break;
                    default:
                        System.out.println(BAD_INPUT);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (c != QUIT);
    }
    
    private static void play() {
        Dealer dealer = new Dealer();
        Hand hand = new Hand();
        byte[] b;
        dealer.shuffleDeck();
        hand.add(dealer.hit());
        hand.add(dealer.hit());
        System.out.println(PLAYER_HAND + NL + hand.toString());
        do {
            System.out.println(SCORE + ' ' + hand.getScore() + NL);
            System.out.println(HIT + ": hit" + NL + STAND + ": stand");
            b = new byte[BUFFER_SIZE];
            try {
                System.in.read(b);
                System.out.println(NL + BREAK);
                switch ((char) b[0]) {
                    case HIT:
                        System.out.println();
                        hand.add(dealer.hit());
                        System.out.println(PLAYER_HAND + NL + hand.toString());
                        break;
                    case STAND:
                        break;
                    default:
                        System.out.println(BAD_INPUT);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (b[0] != (int) STAND && hand.getScore() <= BUST_LIMIT);
        boolean playerBust = hand.getScore() > BUST_LIMIT;
        if (playerBust) {
            System.out.println(SCORE + ' ' + hand.getScore());
            System.out.println(BUSTED + NL);
        } else
            System.out.println();
        boolean dealerBust = dealer.play();
        System.out.println(DEALER_HAND + NL + dealer.handToString());
        System.out.println(SCORE + ' ' + dealer.scoreHand());
        if (dealerBust) {
            System.out.println(DEALER_BUSTED + NL);
            if (playerBust)
                System.out.println(DRAW);
            else
                System.out.println(PLAYER_WIN);
        }
        else if (playerBust) {
            System.out.println(NL + DEALER_WIN);
        }
        else {
            System.out.println();
            if (hand.getScore() > dealer.scoreHand())
                System.out.println(PLAYER_WIN);
            else if (hand.getScore() < dealer.scoreHand())
                System.out.println(DEALER_WIN);
            else
                System.out.println(DRAW);
        }
        System.out.println();
    }
    
}
