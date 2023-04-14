/********************************************************************************************************
*Task                           : 02
*Programmer              	: Kolli Dhanus Datta
*Program name           	: GuessNumber.java

*********************************************************************************************************/
import java.lang.*;
import java.util.*;

public class ATMinterface {
    double minInterest = 0.05; // minimum interest rate
    double minBalance = 1000.0; // minimum balance required
    double maxWithdrawal = 5000.0; // maximum withdrawal limit
    double balance;
    Scanner sc=new Scanner(System.in);
    int choice;
    int car;
    HashMap<Integer, Integer> pinMap;
    HashMap<Integer, Integer> balanceMap;
    ArrayList<String> transactionHistory;
    
    public ATMinterface() {
        // Initialize the PIN and balance HashMaps
        pinMap = new HashMap<>();
        pinMap.put(10001, 1234);
        pinMap.put(10002, 5678);
        // Add more card numbers, PINs, and balances as needed
        
        balanceMap = new HashMap<>();
        balanceMap.put(10001, 10000);
        balanceMap.put(10002, 5000);
        // Add more card numbers and balances as needed

        // Initialize the transaction history ArrayList
        transactionHistory = new ArrayList<>();
        
    }

    void details() {
        System.out.print("\n\tEnter your 5 digit number on the card:");
        car = sc.nextInt();
        if (car < 10000 || car >= 100000) {
            System.out.print("\tEnter the valid Card Number");
            details();
        } else {
            int pin = pinMap.getOrDefault(car, -1);
            if (pin == -1) {
                System.out.print("\tInvalid Card Number");
                details();
            } else {
                System.out.print("\tEnter your 4 digit PIN:");
                int userPin = sc.nextInt();
                if (userPin != pin) {
                    System.out.print("\tInvalid PIN");
                    details();
                } else {
                    balance = balanceMap.get(car);
                    System.out.println("\n\t\t  $$ Welcome!  $$");
                    System.out.println("\n\tSelect the operations you want to perform:");
                    System.out.println("\n\t1. Check Balance");
                    System.out.println("\n\t2. Withdraw");
                    System.out.println("\n\t3. Deposit");
                    System.out.println("\n\t4. Transaction History");
                    System.out.println("\n\t5. Exit");
                }
            }
        }
    }

    void withdraw(double amount) {
        

        if ( maxWithdrawal < amount) {
            System.out.println("Withdraw Limit Exceeded");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else if ((balance - amount) < minBalance) {
            System.out.println("Minimum Balance is not maintained");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawal of " + amount);
            System.out.println("\n\tTransaction Successful!");
            System.out.println("\n\tAfter Withdrawal Balance amount:" + balance);
        }
    }

    void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit of " + amount);
        System.out.println("\n\tTransaction Successful!");
        System.out.println("\n\tAfter Deposit Balance amount:" + balance);
    }
    void showTransactionHistory() {
        System.out.println("\n\tTransaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("\n\tNo transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println("\n\t  " + transaction);
            }
        }
    }
}

class InLab6Task1 {
    public static void main(String atgs[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n            Welcome to the ATM!");
        System.out.println("\n    ###  Insert your card into the slot ###");
        ATMinterface A = new ATMinterface();
        A.details();

        int choice;
        do {
            System.out.print("\n\tEnter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n\tYour account balance is " + A.balance);
                    break;

                case 2:
                    System.out.print("\n\tEnter money to be withdrawn:");
                    double amount = sc.nextDouble();
                    A.withdraw(amount);
                    break;

                case 3:
                    System.out.print("\n\tEnter money to be deposited:");
                    double amount1 = sc.nextDouble();
                    A.deposit(amount1);
                    break;
                case 4:System.out.print("\n\tYour transaction history:");
                       A.showTransactionHistory();
                       break;

                case 5:
                    System.out.println("\nThank you for using the ATM!");
                    return;
                default:
                    System.out.println("\tInvalid choice. Please try again.");
            }
        }while(true);
    }
}
