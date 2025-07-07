/*  
 2 > Medium Problem Statement:
Create a Java program to manage a deck of playing cards using the Collection interface. The program should:
    • Allow users to add cards to the deck (each card has a symbol and value).
    • Group all cards by their symbol and display them.
    • Allow users to search for all cards of a given symbol.
Input Example:
Copy
Add Card:
Symbol: Hearts
Value: Ace

Add Card:
Symbol: Hearts
Value: King

Add Card:
Symbol: Spades
Value: Queen

Search Cards:
Symbol: Hearts
Output Example:
Copy
Cards in Deck:
Hearts: [Ace, King]
Spades: [Queen]

Cards Found for Symbol 'Hearts': [Ace, King]

 */
import java.util.*;

class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

public class PLayingCard {
    private static Map<String, List<Card>> deck = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPlaying Card Management System");
            System.out.println("1. Add Card");
            System.out.println("2. Display All Cards");
            System.out.println("3. Search Cards by Symbol");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    displayCards();
                    break;
                case 3:
                    searchCards();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addCard() {
        System.out.print("Enter Symbol (Hearts/Diamonds/Clubs/Spades): ");
        String symbol = scanner.nextLine();
        
        System.out.print("Enter Value (Ace/2-10/Jack/Queen/King): ");
        String value = scanner.nextLine();

        Card card = new Card(symbol, value);

        deck.computeIfAbsent(symbol, k -> new ArrayList<>()).add(card);
        System.out.println("Card added successfully!");
    }

    private static void displayCards() {
        if (deck.isEmpty()) {
            System.out.println("Deck is empty!");
            return;
        }

        System.out.println("\nCards in Deck:");
        for (Map.Entry<String, List<Card>> entry : deck.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void searchCards() {
        System.out.print("Enter symbol to search: ");
        String symbol = scanner.nextLine();

        List<Card> cards = deck.get(symbol);
        if (cards != null && !cards.isEmpty()) {
            System.out.println("Cards Found for Symbol '" + symbol + "': " + cards);
        } else {
            System.out.println("No cards found for symbol: " + symbol);
        }
    }
}