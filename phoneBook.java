import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class phoneBook {
    private Set<Contact> contacts;

    public phoneBook() {
        contacts = new TreeSet<>(Comparator.comparing(Contact::getName));
    }

    public boolean addContact(Contact contact) {
        return contacts.add(contact);
    }

    public Contact findContact(String name) {
        for (Contact i : contacts) {
            if (i.getName().equalsIgnoreCase(name))
                return i;
        }
        return null;
    }

    public void removeContact(String name) {
        Contact remove = findContact(name);
        if (remove != null) {
            contacts.remove(remove);
        } else {
            System.out.println("\uD83D\uDED1There are no contacts like that\uD83D\uDED1");
        }
    }

    public void listOfContacts() {
        if (!contacts.isEmpty()) {
            for (Contact i : contacts) {
                System.out.println("Name: " + i.getName() + " number: " + i.getNumber());
            }
        } else {
            System.out.println("You have no contacts!");
        }
    }

    public void editContact(String name, String newName, String newNumber) {
        Contact remove = findContact(name);
            if (remove != null) {
                contacts.remove(remove);
                Contact edit = new Contact(newName, newNumber);
                contacts.add(edit);
            }
        }
}









































