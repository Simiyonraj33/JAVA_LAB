// Program: Contact List CRUD using HashMap
// Aim: To create and manage a contact list using Map collection.

import java.util.*;

public class ContactList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> contacts = new HashMap<>();
        int choice;
        do {
            System.out.println("\n1. Add Contact\n2. View Contact\n3. Update Contact\n4. Delete Contact\n5. Display All\n6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();
                    contacts.put(name, phone);
                    System.out.println("Contact added.");
                    break;
                case 2:
                    System.out.print("Enter name to view: ");
                    name = sc.nextLine();
                    System.out.println("Phone: " + contacts.getOrDefault(name, "Not found"));
                    break;
                case 3:
                    System.out.print("Enter name to update: ");
                    name = sc.nextLine();
                    if (contacts.containsKey(name)) {
                        System.out.print("Enter new phone: ");
                        contacts.put(name, sc.nextLine());
                        System.out.println("Updated.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter name to delete: ");
                    name = sc.nextLine();
                    contacts.remove(name);
                    System.out.println("Deleted if existed.");
                    break;
                case 5:
                    System.out.println("All Contacts: " + contacts);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 6);
        sc.close();
    }
}
