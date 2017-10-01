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

        choice = JOptionPane.showOptionDialog(null, yourCards + dealersCards + yourChoice, gameName,
                0, JOptionPane.QUESTION_MESSAGE, null, options, null);
    }
}
