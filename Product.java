public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void displayProductDetails() {
        System.out.println("Product Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Product product = new Product(101, "Laptop", 75000);
        Product product1 = new Product(102, "Mobile", 25000);
        Product product2 = new Product(103, "Tablet", 15000);

        product.displayProductDetails();
        product1.displayProductDetails();
        product2.displayProductDetails();
    }
}