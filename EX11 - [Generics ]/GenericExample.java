import java.util.*;

class DataStore<T> {
    private ArrayList<T> list = new ArrayList<>();

    // Add item
    public void addItem(T item) {
        list.add(item);
    }

    // Sort data (works for String, Integer)
    public void sortData() {
        try {
            Collections.sort((ArrayList) list);
        } catch (Exception e) {
            System.out.println("Sorting not supported for this type.");
        }
    }

    // Print all data
    public void printData() {
        for (T item : list) {
            System.out.println(item);
        }
    }
}

public class GenericExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Work with Integers");
            System.out.println("2. Work with Strings");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                DataStore<Integer> intStore = new DataStore<>();
                System.out.print("Enter number of integers: ");
                int n = sc.nextInt();
                System.out.println("Enter " + n + " integers:");
                for (int i = 0; i < n; i++) {
                    intStore.addItem(sc.nextInt());
                }

                System.out.println("\nBefore Sorting:");
                intStore.printData();

                intStore.sortData();
                System.out.println("\nAfter Sorting:");
                intStore.printData();

            } else if (choice == 2) {
                DataStore<String> strStore = new DataStore<>();
                System.out.print("Enter number of strings: ");
                int n = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.println("Enter " + n + " strings:");
                for (int i = 0; i < n; i++) {
                    strStore.addItem(sc.nextLine());
                }

                System.out.println("\nBefore Sorting:");
                strStore.printData();

                strStore.sortData();
                System.out.println("\nAfter Sorting:");
                strStore.printData();

            } else if (choice == 3) {
                System.out.println("Exiting program... Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}










