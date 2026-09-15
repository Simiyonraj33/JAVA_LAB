import java.util.InputMismatchException;
import java.util.Scanner;

// Functional interface for arithmetic operation
@FunctionalInterface
interface Operation {
    int apply(int a, int b);
}

public class CalculatorLambda{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String you;

        // Lambda expressions for operations
        Operation add = (a, b) -> a + b;
        Operation sub = (a, b) -> a - b;
        Operation mul = (a, b) -> a * b;
        Operation div = (a, b) -> {
            if (b == 0) {
                System.out.println("Error: Division by zero is not allowed.");
                return 0;
            }
            return a / b;
        };
                 
        try {
         
            // Take input
            System.out.print("Enter first number: ");
            int x = sc.nextInt();

            System.out.print("Enter second number: ");
            int y = sc.nextInt();

            // Menu
            System.out.println("\nChoose Operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            int result = 0;
            switch (choice) {
                case 1: result = add.apply(x, y); break;
                case 2: result = sub.apply(x, y); break;
                case 3: result = mul.apply(x, y); break;
                case 4: result = div.apply(x, y); break;
                default:
                    System.out.println("Invalid choice. Please enter 1–4.");
                    return;
            }

            System.out.println("Result: " + result);


        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter only integer values.");
        }
    }
}