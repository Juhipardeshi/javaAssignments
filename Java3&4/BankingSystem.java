import java.io.*;
import java.util.*;

// User-defined Exceptions
class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) {
        super(msg);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class InvalidCustomerIdException extends Exception {
    public InvalidCustomerIdException(String msg) {
        super(msg);
    }
}


// Customer Class
class Customer {
    int cid;
    String cname;
    double amount;


    Customer(int cid, String cname, double amount) {
        this.cid = cid;
        this.cname = cname;
        this.amount = amount;
    }

    void display() {
        System.out.println("ID: " + cid + ", Name: " + cname + ", Balance: " + amount);
    }
}

// Main Class
public class BankingSystem {

    static Scanner sc = new Scanner(System.in);
    static Customer c;

    // Create Account
    static void createAccount() throws Exception {
        System.out.print("Enter Customer ID (1-20): ");
        int id = sc.nextInt();

        if (id < 1 || id > 20)
            throw new InvalidCustomerIdException("CID must be between 1 and 20");

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Initial Amount: ");
        double amt = sc.nextDouble();

        if (amt < 1000)
            throw new InvalidAmountException("Minimum balance should be Rs.1000");

        if (amt < 0)
            throw new InvalidAmountException("Amount must be positive");

        c = new Customer(id, name, amt);
        saveToFile();
        System.out.println("Account Created Successfully!");
    }

    // Deposit
    static void deposit() throws Exception {
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();

        if (amt <= 0)
            throw new InvalidAmountException("Amount must be positive");

        c.amount += amt;
        saveToFile();
        System.out.println("Amount Deposited!");
    }

    // Withdraw
    static void withdraw() throws Exception {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();

        if (amt > c.amount)
            throw new InsufficientBalanceException("Insufficient Balance");

        c.amount -= amt;
        saveToFile();
        System.out.println("Amount Withdrawn!");
    }

    // Save to File
    static void saveToFile() {
        try (FileWriter fw = new FileWriter("customer.txt")) {
            fw.write(c.cid + " " + c.cname + " " + c.amount);
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    // Display Data
    static void display() {
        try (BufferedReader br = new BufferedReader(new FileReader("customer.txt"))) {
            String data = br.readLine();
            System.out.println("Customer Data: " + data);
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        int choice;

        while (true) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        display();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}