import java.util.*;

//write a java program to analyze a string input by the user. The program should count the number of vowels, consonants, digits, and special characters

public class StringAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        String chr=input.toLowerCase();
        int vowels = 0, consonants = 0, digits = 0, specialCharacters = 0;
        String vowelSet = "aeiou";
        
        for (char ch : chr.toCharArray()) {
            if (vowelSet.indexOf(ch) != -1) {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z') ) {
                consonants++;
            } else if (ch >= '0' && ch <= '9') {
                digits++;
            } else {
                specialCharacters++;
            }
        }
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + specialCharacters);
        
        scanner.close();
    }
}