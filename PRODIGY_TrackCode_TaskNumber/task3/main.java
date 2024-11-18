// import java.io.*;
// import java.util.*;

// class Contact {
//     String name;
//     String phone;
//     String email;

//     public Contact(String name, String phone, String email) {
//         this.name = name;
//         this.phone = phone;
//         this.email = email;
//     }

//     @Override
//     public String toString() {
//         return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
//     }
// }

// public class contactmanager {

//     private static final String CONTACTS_FILE = "contacts.csv";
//     private static List<Contact> contacts = new ArrayList<>();

//     public static void main(String[] args) {
//         loadContacts();
//         Scanner scanner = new Scanner(System.in);
        
//         while (true) {
//             System.out.println("\n--- Contact Management ---");
//             System.out.println("1. Add Contact");
//             System.out.println("2. View Contacts");
//             System.out.println("3. Edit Contact");
//             System.out.println("4. Delete Contact");
//             System.out.println("5. Exit");
//             System.out.print("Enter your choice (1-5): ");
            
//             int choice = scanner.nextInt();
//             scanner.nextLine();  // Consume the newline character

//             switch (choice) {
//                 case 1:
//                     addContact(scanner);
//                     break;
//                 case 2:
//                     viewContacts();
//                     break;
//                 case 3:
//                     editContact(scanner);
//                     break;
//                 case 4:
//                     deleteContact(scanner);
//                     break;
//                 case 5:
//                     saveContacts();
//                     System.out.println("Exiting the program.");
//                     return;
//                 default:
//                     System.out.println("Invalid choice. Please try again.");
//             }
//         }
//     }

//     // Load contacts from the CSV file
//     private static void loadContacts() {
//         File file = new File(CONTACTS_FILE);
//         if (file.exists()) {
//             try (BufferedReader br = new BufferedReader(new FileReader(CONTACTS_FILE))) {
//                 String line;
//                 while ((line = br.readLine()) != null) {
//                     String[] contactInfo = line.split(",");
//                     if (contactInfo.length == 3) {
//                         contacts.add(new Contact(contactInfo[0], contactInfo[1], contactInfo[2]));
//                     }
//                 }
//             } catch (IOException e) {
//                 System.out.println("Error reading contacts from file.");
//             }
//         }
//     }

//     // Save contacts to the CSV file
//     private static void saveContacts() {
//         try (BufferedWriter bw = new BufferedWriter(new FileWriter(CONTACTS_FILE))) {
//             for (Contact contact : contacts) {
//                 bw.write(contact.name + "," + contact.phone + "," + contact.email);
//                 bw.newLine();
//             }
//         } catch (IOException e) {
//             System.out.println("Error saving contacts to file.");
//         }
//     }

//     // Add a new contact
//     private static void addContact(Scanner scanner) {
//         System.out.print("Enter contact name: ");
//         String name = scanner.nextLine();
//         System.out.print("Enter phone number: ");
//         String phone = scanner.nextLine();
//         System.out.print("Enter email address: ");
//         String email = scanner.nextLine();

//         contacts.add(new Contact(name, phone, email));
//         System.out.println("Contact added successfully.");
//     }

//     // View all contacts
//     private static void viewContacts() {
//         if (contacts.isEmpty()) {
//             System.out.println("No contacts found.");
//         } else {
//             System.out.println("Contacts List:");
//             for (int i = 0; i < contacts.size(); i++) {
//                 System.out.println((i + 1) + ". " + contacts.get(i));
//             }
//         }
//     }

//     // Edit an existing contact
//     private static void editContact(Scanner scanner) {
//         if (contacts.isEmpty()) {
//             System.out.println("No contacts available to edit.");
//             return;
//         }

//         // viewContacts();
//         System.out.print("Enter the contact number to edit: ");
//         int index = scanner.nextInt() - 1;
//         scanner.nextLine();  // Consume newline

//         if (index >= 0 && index < contacts.size()) {
//             Contact contact = contacts.get(index);

//             System.out.print("Enter new name (current: " + contact.name + "): ");
//             String name = scanner.nextLine();
//             if (!name.isEmpty()) contact.name = name;

//             System.out.print("Enter new phone (current: " + contact.phone + "): ");
//             String phone = scanner.nextLine();
//             if (!phone.isEmpty()) contact.phone = phone;

//             System.out.print("Enter new email (current: " + contact.email + "): ");
//             String email = scanner.nextLine();
//             if (!email.isEmpty()) contact.email = email;

//             System.out.println("Contact updated successfully.");
//         } else {
//             System.out.println("Invalid contact number.");
//         }
//     }

//     // Delete a contact
//     private static void deleteContact(Scanner scanner) {
//         if (contacts.isEmpty()) {
//             System.out.println("No contacts available to delete.");
//             return;
//         }
//         // viewContacts();
//         System.out.print("Enter the contact number to delete: ");
//         int index = scanner.nextInt() - 1;

//         if (index >= 0 && index < contacts.size()) {
//             Contact removed = contacts.remove(index);
//             System.out.println("Contact " + removed.name + " deleted successfully.");
//         } else {
//             System.out.println("Invalid contact number.");
//         }
//     }
// }

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;
    String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + ": " + phoneNumber + " (" + email + ")";
    }
}

class ContactManager {
    List<Contact> contacts;
    String filename;

    public ContactManager(String filename) {
        this.filename = filename;
        contacts = new ArrayList<>();
        loadContacts();
    }

    public void addContact(String name, String phoneNumber, String email) {
        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
    }

    public void viewContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void editContact(String name, String phoneNumber, String email) {
        for (Contact contact : contacts) {
            if (contact.name.equals(name)) {
                if (!phoneNumber.isEmpty()) {
                    contact.phoneNumber = phoneNumber;
                }
                if (!email.isEmpty()) {
                    contact.email = email;
                }
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public void deleteContact(String phoneNumber) {
        contacts.removeIf(contact -> contact.phoneNumber.equals(phoneNumber));
    }

    public void saveContacts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Contact contact : contacts) {
                writer.write(contact.name + "," + contact.phoneNumber + "," + contact.email);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving contacts.");
        }
    }

    public void loadContacts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    addContact(parts[0], parts[1], parts[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading contacts.");
        }
    }
}

public class main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager("contacts.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("!!!Contact Manager!!!");
            System.out.println();
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    manager.addContact(name, phoneNumber, email);
                }

                case 2 -> manager.viewContacts();

                case 3 -> {
                    System.out.print("Enter name: ");
                    String editName = scanner.nextLine();
                    System.out.print("Enter new phone number (optional, press Enter to skip): ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter new email (optional, press Enter to skip): ");
                    String newEmail = scanner.nextLine();
                    manager.editContact(editName, newPhoneNumber, newEmail);
                }

                case 4 -> {
                    System.out.print("Enter phoneNumber: ");
                    String deleteName = scanner.nextLine();
                    manager.deleteContact(deleteName);
                }

                case 5 -> {
                    manager.saveContacts();
                    System.out.println("Contacts saved. Exiting...");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }
}