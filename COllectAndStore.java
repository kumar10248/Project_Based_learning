/*  
 *Medium Level:
 Create a program to collect and store all the cards to assist the users in finding all the cards in a given symbol using Collection interface.

 
    */
    import java.util.*;

    class Card {
        private String suit;
        private String rank;
    
        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }
    
        public String getSuit() {
            return suit;
        }
    
        public String getRank() {
            return rank;
        }
    
        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }
    
    public class COllectAndStore {
        private static Map<String, List<Card>> cardsBySuit = new HashMap<>();
        private static Scanner scanner = new Scanner(System.in);
    
        public static void main(String[] args) {
            initializeCards();
    
            while (true) {
                System.out.println("\nCard Collection System");
                System.out.println("1. Find cards by suit");
                System.out.println("2. Display all cards");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
    
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
    
                switch (choice) {
                    case 1:
                        findCardsBySuit();
                        break;
                    case 2:
                        displayAllCards();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }
    
        private static void initializeCards() {
            String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
            String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    
            for (String suit : suits) {
                List<Card> suitCards = new ArrayList<>();
                for (String rank : ranks) {
                    suitCards.add(new Card(suit, rank));
                }
                cardsBySuit.put(suit, suitCards);
            }
        }
    
        private static void findCardsBySuit() {
            System.out.println("\nAvailable suits: Hearts, Diamonds, Clubs, Spades");
            System.out.print("Enter suit name: ");
            String suit = scanner.nextLine();
    
            List<Card> cards = cardsBySuit.get(capitalize(suit));
            if (cards != null) {
                System.out.println("\nCards in " + capitalize(suit) + ":");
                for (Card card : cards) {
                    System.out.println(card);
                }
            } else {
                System.out.println("Invalid suit name!");
            }
        }
    
        private static void displayAllCards() {
            System.out.println("\nAll Cards:");
            for (String suit : cardsBySuit.keySet()) {
                System.out.println("\n" + suit + ":");
                for (Card card : cardsBySuit.get(suit)) {
                    System.out.println(card);
                }
            }
        }
    
        private static String capitalize(String str) {
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }
    }