/*   Created By: IntelliJ Idea
 *    Author: Naman Agarwal (naman2807)
 *    Date: 26-07-2020
 *    Time: 06:52 AM
 *    Package: PACKAGE_NAME
 */


import java.util.ArrayList;

public class Mobile {
    private final ArrayList<Contacts> myContact;

    public Mobile() {
        this.myContact = new ArrayList<Contacts>();
    }

    private int findContact(Contacts contacts) {
        return this.myContact.indexOf(contacts);
    }

    private int findContact(String name) {
        for (int i = 0; i < myContact.size(); i++) {
            Contacts contacts = this.myContact.get(i);
            if (contacts.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void showContacts() {
        System.out.println("Your contact list has " + this.myContact.size() + " contacts.");
        for (int i = 0; i < myContact.size(); i++) {
            System.out.println((i + 1) + ". " + this.myContact.get(i).getName() + "====> " + this.myContact.get(i).getPhoneNumber());
        }
    }

    public void addContact(Contacts contacts) {
        if (findContact(contacts) >= 0) {
            System.out.println("Contact already exist in the record");

        } else {
            myContact.add(contacts);
            System.out.println("Success...");
            System.out.println(contacts.getName() + " has been added with phone number: " + contacts.getPhoneNumber());
        }


    }

    public void removeContact(String name) {
        if (findContact(name) < 0) {
            System.out.println("Contact does not exist in the record");

        } else {
            int index = findContact(name);
            System.out.println("Deleted " + this.myContact.get(index).getName());
            this.myContact.remove(index);
        }
    }

    public void updateContact(Contacts oldContact, Contacts newContact) {
        if (findContact(oldContact) >= 0) {
            int i = findContact(oldContact);
            this.myContact.set(i, newContact);
            System.out.println(oldContact.getName() + " is replaced with " + newContact.getName());
        } else {
            System.out.println("Contact does not exist.");
        }
    }

    public Contacts findRecord(String contacts) {
        int index = findContact(contacts);
        if (index >= 0) {
            return this.myContact.get(index);
        } else {
            return null;
        }
    }
}














