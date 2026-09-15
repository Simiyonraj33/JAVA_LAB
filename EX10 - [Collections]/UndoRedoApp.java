// Program: Undo and Redo Simulation using Collections
// Aim: To perform menu-driven undo and redo operations
// using Stack collection in Java.

import java.util.*;

public class UndoRedoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> actions = new Stack<>();
        Stack<String> redoStack = new Stack<>();
        int choice;

        do {
            System.out.println("\n1. Action\n2. Undo\n3. Redo\n4. Display Last Action\n5. Exit");
            System.out.print("Choose any one: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Action: ");
                    String action = sc.nextLine();
                    actions.push(action);
                    redoStack.clear();
                    break;
                case 2:
                    if (!actions.isEmpty()) {
                        redoStack.push(actions.pop());
                        System.out.println("Undo performed.");
                    } else {
                        System.out.println("No action to undo.");
                    }
                    break;
                case 3:
                    if (!redoStack.isEmpty()) {
                        actions.push(redoStack.pop());
                        System.out.println("Redo performed.");
                    } else {
                        System.out.println("No action to redo.");
                    }
                    break;
                case 4:
                    if (!actions.isEmpty())
                        System.out.println("Last action: " + actions.peek());
                    else
                        System.out.println("No last action.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        sc.close();
    }
}
