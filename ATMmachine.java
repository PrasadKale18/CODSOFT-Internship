import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

class ATM {
    private float balance = 500;
    private int pin = 1234;
    private ArrayList<String> transactionHistory = new ArrayList<>();

    void checkPin() {
        System.out.print("Enter a valid PIN : ");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();
        if (enteredPin == pin) {
            menu();
        } else {
            System.out.println("Incorrect PIN please Enter a valid PIN...!");
            checkPin();
        }
    }

    void menu() {
        while (true) {
            System.out.println("\nMenu : ");
            System.out.println("1. Check A/C Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");
            System.out.print("Enter your choice : ");

            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    viewTransactionHistory();
                    break;
                case 5:
                    changePIN();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Enter a valid choice.");
            }
        }
    }

    void checkBalance() {
        System.out.println("Balance: $" + balance);
        recordTransaction("Checked balance: $" + balance);
    }

    void withdrawMoney() {
        System.out.print("Enter amount to withdraw: $");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            balance -= amount;
            System.out.println("Amount Withdrawn Successfully.");
            recordTransaction("Withdrawn: $" + amount);
        }
    }

    void depositMoney() {
        System.out.print("Enter amount to deposit: $");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        balance += amount;
        System.out.println("Money Deposited Successfully.");
        recordTransaction("Deposited: $" + amount);
    }

    void viewTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    void changePIN() {
        System.out.print("Enter your new PIN: ");
        Scanner sc = new Scanner(System.in);
        int newPin = sc.nextInt();
        pin = newPin;
        System.out.println("PIN changed successfully.");
    }

    private void recordTransaction(String description) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date());
        transactionHistory.add(timestamp + " - " + description);
    }
}

public class ATMmachine {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.checkPin();
    }
}
