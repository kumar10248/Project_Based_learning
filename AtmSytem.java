/*
 Write a Java program to simulate an ATM
withdrawal system. The program should:
Ask the user to enter their PIN.
Allow withdrawal if the PIN is correct and the balance is sufficient.
Throw exceptions for invalid PIN or insufficient balance.
Ensure the system always shows the remaining balance, even if an
exception occurs.
 */
import java.util.Scanner;
public class AtmSytem {
    public static void main(String[] args) {
        int PIN=10248;
        double balance=1000;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your PIN: ");
        int pin=sc.nextInt();
       try{
           if(pin==PIN){
               System.out.println("Enter the amount you want to withdraw: ");
               double amount=sc.nextDouble();
               
               if(amount>balance){
                   throw new Exception("Insufficient balance");
               }
               balance-=amount;
               System.out.println("Amount withdrawn successfully");
           }
           else{
               throw new Exception("Invalid PIN");
               
           }
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
       finally{
           System.out.println("Remaining balance: "+balance);
           sc.close();
       }


    }
    

    
}
