/*   Created By: IntelliJ Idea
 *    Author: Naman Agarwal (naman2807)
 *    Date: 26-07-2020
 *    Time: 07:47 AM
 *    Package: PACKAGE_NAME
 */

//        Create a program that implements a simple mobile phone with the following capabilities.
//        Able to store,modify,remove and query contact.
//        you will want to create a separate class for contacts( name and phne no.)
//        create a master class(Mobileclass) that holds the ArrayList of contacts.
//        Mobilephone class has the functionality listed above.
//        when adding or updating make sure that if the contact already exist.
//        Be sure not to xpose the inner working of ArryList to Mobilephone
//        eg: no int, no.get(i);
//        Mobilepone should do everything with contacts object only.


import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Mobile mobile = new Mobile();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        System.out.println("Phone boosting up....");
        instructions();
        while (!quit) {
            System.out.println("Enter action: ");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    mobile.showContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    queryContact();
                    break;
                case 5:
                    updateContact();
                    break;
            }
        }
    }

    private static void instructions() {
        System.out.println("Available Actions:\n Press:");
        System.out.println("\t0. Quit application");
        System.out.println("\t1. Show contact list.");
        System.out.println("\t2. Add a new contact.");
        System.out.println("\t3. Delete a contact.");
        System.out.println("\t4. Find a contact.");
        System.out.println("\t5. Replace a contact.");
    }

    private static void addContact() {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Phone number: ");
        String number = scanner.nextLine();
        Contacts contacts = Contacts.addNewContact(name, number);
        mobile.addContact(contacts);
    }

    private static void deleteContact() {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        mobile.removeContact(name);

    }

    private static void queryContact() {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        Contacts contacts = mobile.findRecord(name);
        if (contacts != null) {
            System.out.println(contacts.getName() + " found. Phone number: " + contacts.getPhoneNumber());
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void updateContact() {
        System.out.println("Enter the name to be replaced: ");
        String name = scanner.nextLine();
        Contacts contacts = mobile.findRecord(name);
        if (contacts == null) {
            System.out.println("Contact does not exist.");
            return;
        } else {
            System.out.println("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter phone number: ");
            String number = scanner.nextLine();
            Contacts newContact = Contacts.addNewContact(newName, number);
            mobile.updateContact(contacts, newContact);
        }
    }
}

