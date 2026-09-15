import java.util.Scanner;

// Base class
class Payment {
    static int counter = 1; // auto-increment id
    int id;
    String payeeName;
    double billAmount;
    String date;

    public Payment(String payeeName, double billAmount, String date) {
        this.id = counter++;
        this.payeeName = payeeName;
        this.billAmount = billAmount;
        this.date = date;
    }

    double calculateFinalAmount() {
        return billAmount; // base amount
    }

    void printBill() {
        System.out.println("\n--- BILL RECEIPT ---");
        System.out.println("Payment ID: " + id);
        System.out.println("Payee: " + payeeName);
        System.out.println("Bill Amount: " + billAmount);
        System.out.println("Date: " + date);
    }
}

// Card class
class Card extends Payment {
    static final double GST = 0.12;

    public Card(String payeeName, double billAmount, String date) {
        super(payeeName, billAmount, date);
    }

    @Override
    double calculateFinalAmount() {
        return billAmount + billAmount * GST; // add 12% GST
    }
}

// DebitCard class
class DebitCard extends Card {
    public DebitCard(String payeeName, double billAmount, String date) {
        super(payeeName, billAmount, date);
    }

    @Override
    double calculateFinalAmount() {
        return super.calculateFinalAmount() + billAmount * 0.10; // 10% transaction charge
    }
}

// CreditCard class
class CreditCard extends Card {
    public CreditCard(String payeeName, double billAmount, String date) {
        super(payeeName, billAmount, date);
    }

    @Override
    double calculateFinalAmount() {
        return super.calculateFinalAmount() + billAmount * 0.05 - 50; // 5% charge - Rs 50 discount
    }
}

// Cash class
class Cash extends Payment {
    public Cash(String payeeName, double billAmount, String date) {
        super(payeeName, billAmount, date);
    }

    @Override
    double calculateFinalAmount() {
        return billAmount + billAmount * 0.12; // 12% GST
    }
}

// Main class
public class Bill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Payee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Bill Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Date (dd/mm/yyyy): ");
        String date = sc.nextLine();

        System.out.println("Choose Payment Mode: 1. Card 2. Cash");
        int mode = sc.nextInt();
        sc.nextLine();

        Payment payment = null;

        if (mode == 1) {
            System.out.println("Choose Card Type: 1. Debit 2. Credit");
            int type = sc.nextInt();
            sc.nextLine();

            if (type == 1) {
                payment = new DebitCard(name, amount, date);
            } else {
                payment = new CreditCard(name, amount, date);
            }
        } else {
            payment = new Cash(name, amount, date);
        }

        payment.printBill();
        System.out.printf("Final Amount to Pay: %.2f\n", payment.calculateFinalAmount());

        sc.close();
    }
}