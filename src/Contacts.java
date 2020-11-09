/*   Created By: IntelliJ Idea
 *    Author: Naman Agarwal (naman2807)
 *    Date: 26-07-2020
 *    Time: 06:49 AM
 *    Package: PACKAGE_NAME
 */


public class Contacts {
    private final String name;
    private final String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static Contacts addNewContact(String name, String number) {
        return new Contacts(name, number);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
