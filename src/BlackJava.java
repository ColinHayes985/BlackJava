import java.util.*;
import javax.swing.*;

public class BlackJava {
    private static final String gameName = "BlackJava";
    private static final String yourCards = "Here are your cards: ";
    private static final String dealersCards = "Here are the dealer's cards: ";
    private static final String yourChoice= "What would you like to do?";
    public static void main(String[] args) {
        int choice;
        String[] options = {"Hit", "Stand"};
        choice = JOptionPane.showConfirmDialog(null, "Welcome to BlackJava!\nAre you ready to play?", gameName, JOptionPane.YES_NO_OPTION);
        if (choice != 0) {
            System.exit(1);
        }
        // THE GAME CONTINUES...
        ArrayList<Character> playerDeck = new ArrayList<Character>();
        ArrayList<Character> dealerDeck = new ArrayList<Character>();
        char[] deck={'A','A','A','A','2','2','2','2','3','3','3','3','4','4','4','4','5','5','5','5','6','6','6','6','7','7','7','7','8','8','8','8','9','9','9','9','T','T','T','T','J','J','J','J','Q','Q','Q','Q','K','K','K','K'};
        Random r = new Random();


            for(int i=0; i<2; i++) {
                int index=r.nextInt(52);
                while (deck[index] != '*') {
                    playerDeck.add(deck[index]);
                    deck[index]='*';
            }

            //add deck[index] to player deck
            //set deck index to null

        }
        System.out.println("Player Cards:"+playerDeck);
        choice = JOptionPane.showOptionDialog(null, yourCards + dealersCards + yourChoice, gameName,
                0, JOptionPane.QUESTION_MESSAGE, null, options, null);
    }
}
