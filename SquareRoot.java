import java.util.Scanner;
class NegativeNumberException extends Exception{
    public NegativeNumberException(String message){
        super(message);
    }
}
public class SquareRoot {
    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        input = scanner.nextLine();
        scanner.close();
        try {
            double number = Double.parseDouble(input);
            if(number<=0){
            throw new NegativeNumberException("Negative number");
            }
           
            double squareRoot = Math.sqrt(number);
            System.out.println("The square root of " + number + " is " + squareRoot);
        } catch (NumberFormatException | NegativeNumberException e) {
            System.out.println(e.getMessage()+", Invalid input. Please enter a number.");
           
        } finally {
            System.out.println("Goodbye!");
        }
    }
}
