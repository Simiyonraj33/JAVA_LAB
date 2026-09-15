import java.util.Scanner;

// Abstract class
abstract class CreditCard {
    String cardHolderName;
    long cardNumber;
    double creditLimit;

    CreditCard(String name, long number) {
        this.cardHolderName = name;
        this.cardNumber = number;
    }

    void displayDetails() {
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Credit Limit: Rs." + creditLimit);
    }

    // Abstract method
    abstract void calculateBill(double purchaseAmount);
}

// SilverCard subclass
class SilverCard extends CreditCard {
    SilverCard(String name, long number) {
        super(name, number);
        this.creditLimit = 200000;
    }

    @Override
    void calculateBill(double purchaseAmount) {
        System.out.println("Card Type: Silver Card");
        System.out.println("No discount applicable.");
        System.out.println("Final Bill: Rs." + purchaseAmount);
    }
}

// GoldCard subclass
class GoldCard extends CreditCard {
    GoldCard(String name, long number) {
        super(name, number);
        this.creditLimit = 500000;
    }

    @Override
    void calculateBill(double purchaseAmount) {
        double discount = purchaseAmount * 0.05;
        double finalAmount = purchaseAmount - discount;
        System.out.println("Card Type: Gold Card");
        System.out.println("5% discount applied.");
        System.out.println("Final Bill: Rs." + finalAmount);
    }
}

// PlatinumCard subclass
class PlatinumCard extends CreditCard {
    PlatinumCard(String name, long number) {
        super(name, number);
        this.creditLimit = 1000000;
    }

    @Override
    void calculateBill(double purchaseAmount) {
        double discount = purchaseAmount * 0.10;
        double finalAmount = purchaseAmount - discount;
        System.out.println("Card Type: Platinum Card");
        System.out.println("10% discount applied.");
        System.out.println("Final Bill: Rs." + finalAmount);
    }
}

// Main class with main() method
public class CardTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input details
        System.out.print("Enter Card Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Card Number: ");
        long number = sc.nextLong();

        System.out.println("\nChoose Card Type:");
        System.out.println("1. Silver Card");
        System.out.println("2. Gold Card");
        System.out.println("3. Platinum Card");
        System.out.print("Enter your choice (1-3): ");
        int choice = sc.nextInt();

        System.out.print("Enter Purchase Amount: Rs.");
        double purchaseAmount = sc.nextDouble();

        CreditCard card;

        switch (choice) {
            case 1:
                card = new SilverCard(name, number);
                break;
            case 2:
                card = new GoldCard(name, number);
                break;
            case 3:
                card = new PlatinumCard(name, number);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                sc.close();
                return;
        }

        // Display output
        System.out.println("\n--- Card Details ---");
        card.displayDetails();
        System.out.println("\n--- Billing Info ---");
        card.calculateBill(purchaseAmount);

        sc.close();
    }
}
