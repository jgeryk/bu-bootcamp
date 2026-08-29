import java.util.*;

public class ContactManager {

    public static void main(String[] args) {
        HashMap<String, Contact> contacts = new HashMap<>();

        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Jacob Geryk", new Contact("Jacob Geryk", "+1 123 456 7890"));
        contacts.put("Jacob Jones", new Contact("Jacob Jones", "+1 123 123 1234"));
        contacts.put("Cleo Johnson", new Contact("Cleo Johnson", "+1 333 333 3333"));
        contacts.put("Tom Yi", new Contact("Tom Yi", "+1 000 000 0000"));

        System.out.println("=== All Contacts === ");
        Contact found = contacts.get("Ada Lovelace");
        if (found == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Found: " + found);
        }
        String missingName = "Unknown";
        Contact missing = contacts.get(missingName);
        if (missing == null) {
            System.out.println("Contact " + missingName + " not found.");
        } else {
            System.out.println("Found: " + missing);
        }

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println();
        System.out.println("=== All Contacts ===");
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }

}
