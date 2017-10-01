import java.util.*; // Import Random class
import javax.swing.*; // Import JOptionPane class

public class BlackJava {
    private static final String gameName = "BlackJava";
    private static final String yourCards = "Here are your cards: ";
    private static final String dealersCards = "Here are the dealer's cards: ";
    private static final String yourChoice = "What would you like to do?";
    private static final String playAgain = "Would you like to play again?";
    private static final String goodbye = "Thank you for playing BlackJava!\n\nCredits:\nAndrew Davis - github.com/andrewsdavis\nColin Hayes - github.com/ColinHayes985";

    private static int deckTotal(ArrayList<Character> deck) {
        int total = 0;
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i) == 'T' || deck.get(i) == 'J' || deck.get(i) == 'Q' || deck.get(i) == 'K') {
                total += 10;
            } else if (deck.get(i) == 'A') {
                if (total > 10) {
                    total += 1;
                } else {
                    total += 11;
                }
            } else {
                String s = "";
                total += Integer.parseInt(s + deck.get(i));
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Random r = new Random(); // Create new Random object
        int choice; // int choice used for storing user's choice
        String[] options = {"Hit", "Stand"}; // User's options for JOptionPane
        choice = JOptionPane.showConfirmDialog(null, "Welcome to BlackJava!\nAre you ready to play?", gameName, JOptionPane.YES_NO_OPTION); // Startup message
        if (choice != 0) { // If the player does not want to play...
            System.exit(1); // Exit Java
        }


        // THE GAME CONTINUES...
        boolean playing = true;
        while (playing) {
            ArrayList<Character> playerDeck = new ArrayList<Character>();//Create a hand for player
            ArrayList<Character> dealerDeck = new ArrayList<Character>();//Create a hand for dealer
            char[] deck = {'A', 'A', 'A', 'A', '2', '2', '2', '2', '3', '3', '3', '3', '4', '4', '4', '4', '5', '5', '5', '5', '6', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '8', '9', '9', '9', '9', 'T', 'T', 'T', 'T', 'J', 'J', 'J', 'J', 'Q', 'Q', 'Q', 'Q', 'K', 'K', 'K', 'K'};
            // ^^^ Create a deck to pull cards from ^^^

            for (int i = 0; i < 2; i++) { // Deal initial cards to player
                int index = r.nextInt(52);
                while (deck[index] == '*') {
                    index = r.nextInt(52);
                }
                playerDeck.add(deck[index]);
                deck[index] = '*';
            }

            for (int i = 0; i < 2; i++) { // Deal initial cards to dealer
                int index = r.nextInt(52);
                while (deck[index] == '*') {
                    index = r.nextInt(52);
                }
                dealerDeck.add(deck[index]);
                deck[index] = '*';
            }


            choice = 0;
            while (choice == 0) {
                if (deckTotal(playerDeck) < 21) {
                    choice = JOptionPane.showOptionDialog(null, yourCards + "\n" + playerDeck + "  Total: " + deckTotal(playerDeck) + "\n" + dealersCards + "\n" + "[?, " + dealerDeck.get(1) + "]\n" + yourChoice, gameName,
                            0, JOptionPane.QUESTION_MESSAGE, null, options, null);
                    if (choice == 0) {
                        int index = r.nextInt(52);
                        while (deck[index] == '*') {
                            index = r.nextInt(52);
                        }
                        playerDeck.add(deck[index]);
                        deck[index] = '*';
                    }
                } else {
                    choice = 1;
                }
            }

            if (deckTotal(playerDeck) == 21) {
                choice = JOptionPane.showConfirmDialog(null, "Congratulations, you got a Blackjack!\n" + playAgain, gameName, JOptionPane.YES_NO_OPTION);
                if (choice != 0) {
                    JOptionPane.showMessageDialog(null, goodbye, gameName, JOptionPane.INFORMATION_MESSAGE);
                    playing = false;
                }
            }
            else if (deckTotal(playerDeck) > 21) {
                choice = JOptionPane.showConfirmDialog(null, "Sorry, you busted. Total: " + deckTotal(playerDeck) + "\n" + playAgain, gameName, JOptionPane.YES_NO_OPTION);
                if (choice != 0) {
                    JOptionPane.showMessageDialog(null, goodbye, gameName, JOptionPane.INFORMATION_MESSAGE);
                    playing = false;
                }
            }
            else {
                while (deckTotal(dealerDeck) < 17) {
                    int index = r.nextInt(52);
                    while (deck[index] == '*') {
                        index = r.nextInt(52);
                    }
                    dealerDeck.add(deck[index]);
                    deck[index] = '*';

                }
                if (deckTotal(dealerDeck) > 21) {
                    choice = JOptionPane.showConfirmDialog(null, "Congratulations! The dealer busted! You win!\n" + playAgain, gameName, JOptionPane.YES_NO_OPTION);
                    if (choice == 1 || choice == -1) {
                        JOptionPane.showMessageDialog(null, goodbye, gameName, JOptionPane.INFORMATION_MESSAGE);
                        playing = false;
                    }
                } else if (deckTotal(playerDeck) > deckTotal(dealerDeck)) {
                    choice = JOptionPane.showConfirmDialog(null, "Congratulations! You won!\n" + "Your total: " + deckTotal(playerDeck) + "  Dealer total: " + deckTotal(dealerDeck) + "\n" + playAgain, gameName, JOptionPane.YES_NO_OPTION);
                    if (choice != 0) {
                        JOptionPane.showMessageDialog(null, goodbye, gameName, JOptionPane.INFORMATION_MESSAGE);
                        playing = false;
                    }
                } else if (deckTotal(playerDeck) < deckTotal(dealerDeck)) {
                    choice = JOptionPane.showConfirmDialog(null, "Sorry, you lost.\n" + "Your total: " + deckTotal(playerDeck) + "  Dealer total: " + deckTotal(dealerDeck) + "\n" + playAgain, gameName, JOptionPane.YES_NO_OPTION);
                    if (choice != 0) {
                        JOptionPane.showMessageDialog(null, goodbye, gameName, JOptionPane.INFORMATION_MESSAGE);
                        playing = false;
                    }
                } else if (deckTotal(playerDeck) == deckTotal(dealerDeck)) {
                    choice = JOptionPane.showConfirmDialog(null, "No one won; it is a push.\n" + "Your total: " + deckTotal(playerDeck) + "  Dealer total: " + deckTotal(dealerDeck) + "\n" + playAgain, gameName, JOptionPane.YES_NO_OPTION);
                    if (choice != 0) {
                        JOptionPane.showMessageDialog(null, goodbye, gameName, JOptionPane.INFORMATION_MESSAGE);
                        playing = false;
                    }
                }
            }
        }
    }
}
