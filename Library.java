abstract class Book {
    protected String title;
    protected String author;
    protected double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    abstract void displayDetails();
}

class Fiction extends Book {
    public Fiction(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    void displayDetails() {
        System.out.println("\nFiction Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

class NonFiction extends Book {
    public NonFiction(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    void displayDetails() {
        System.out.println("\nNon-Fiction Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class Library {
    public static void main(String[] args) {
        Fiction fiction = new Fiction("Harry Potter", "J.K. Rowling", 500);
        NonFiction nonFiction = new NonFiction("Sapiens", "Yuval Noah Harari", 700);

        fiction.displayDetails();
        nonFiction.displayDetails();
    }
}