import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        phoneBook phoneBook = new phoneBook();
        phoneBook.addContact(new Contact("Aman", "+996501587501"));
        phoneBook.addContact(new Contact("Daniel", "+996505055667"));
        phoneBook.addContact(new Contact("Akyl", "+996770549012"));
        while (true) {
            System.out.println("\n📱 PHONEBOOK MENU");
            System.out.println("--------------------------");
            System.out.println("If you want to add a new contact write: \"add\" ➕");
            System.out.println("If you want to find a contact write: \"find\" 🔍");
            System.out.println("If you want to see a list of contacts write: \"list\" 📋");
            System.out.println("If you want to remove some contacts write: \"remove\" ❌");
            System.out.println("If you want to edit some contacts write: \"edit\" ✏\uFE0F");
            System.out.println("If you want to exit from a phoneBook, please write: \"exit\" \uD83D\uDED1");
            String mainmenu = scan.nextLine();
            switch (mainmenu) {
                case "find":
                    findContact(phoneBook, scan);
                    break;

                case "add":
                    addContact(phoneBook, scan);
                    break;

                case "list":
                    listOfContacts(phoneBook, scan);
                    break;

                case "remove":
                    removeContact(phoneBook, scan);
                    break;

                case "edit":
                    editContact(phoneBook, scan);
                    break;

                case "exit":
                    System.exit(0);
                    break;

                default:
                    System.out.println("\uD83D\uDED1Invalid action!\uD83D\uDED1");
                    break;
            }
        }
    }

    public static void addContact(phoneBook phoneBook, Scanner scan) {
        System.out.println("\nEnter \"back\" to back in the main menu or \"exit\" to leave from the app");
        System.out.println("\n\n\uD83D\uDED1❗Write number with country code \"+996\" and 9 digits after it❗");

        while (true) {
            System.out.print("\nWrite name: ");
            String name = scan.nextLine();

            if (name.equalsIgnoreCase("back"))
                break;

            else if (name.equalsIgnoreCase("exit"))
                System.exit(0);

            System.out.print("\nWrite number: ");
            String number = scan.nextLine();

            if (number.equalsIgnoreCase("back"))
                break;

            else if (number.equalsIgnoreCase("exit"))
                System.exit(0);

            if (number.matches("\\+996\\d{9}")) {
                Contact add = new Contact(name, number);
                if (phoneBook.addContact(add)) {
                    phoneBook.addContact(add);
                    System.out.println("You have successfully added a new contact:");
                    System.out.println("=================================================================================================");
                    System.out.println("Name: " + name + "Number: " + number);
                    System.out.println("=================================================================================================");
                }
                else
                    System.out.println("There are already contact with that name or number!!!");
            }
            else
                System.out.println("Wrong type of number!");
            System.out.println(enterTwoOptions());
            String back = scan.nextLine();
            if (back.equalsIgnoreCase("back"))
                break;
            else if (back.isEmpty())
                continue;
        }
    }

    public static void findContact(phoneBook phoneBook, Scanner scan) {
        while (true) {
            System.out.println("\nEnter \"back\" to back in the main menu or \"exit\" to leave from the app");
            System.out.println("Enter by what do you want to find: \"name\" or \"number\"");
            String dec = scan.nextLine();
            if (dec.equalsIgnoreCase("name")) {
                System.out.print("\n\nWrite name: ");
                String name = scan.nextLine();
                if (name.equalsIgnoreCase("back")) {
                    return;
                } else if (name.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }
                Contact find = phoneBook.findContact(name);
                if (find != null) {
                    System.out.println("=================================================================================================");
                    System.out.println("Founded a contact: " + "\nName: " + find + "\nNumber: " + find.getNumber());
                    System.out.println("=================================================================================================");
                } else {
                    System.out.println("\uD83D\uDED1There are no contacts with that name\uD83D\uDED1");
                }
            } else if (dec.equalsIgnoreCase("number")) {
                System.out.print("\n\nWrite number: ");
                String number = scan.nextLine();
                if (number.matches("\\+996\\d{9}")) {
                    if (number.equalsIgnoreCase("back")) {
                        return;
                    }
                Contact find = phoneBook.findContactByNumber(number);
                if (find != null) {
                    System.out.println("=================================================================================================");
                    System.out.println("Founded a contact: " + "\nName: " + find + "\nNumber: " + find.getNumber());
                    System.out.println("=================================================================================================");
                } else {
                    System.out.println("\uD83D\uDED1There are no contacts with that number!\uD83D\uDED1");
                }
            }
                else
                    System.out.println("Wrong type of number!");
        }
            else if (dec.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            else if (dec.equalsIgnoreCase("back")) {
                return;
            }
            System.out.println(enterTwoOptions());
            String back = scan.nextLine();
            if (back.equalsIgnoreCase("back"))
                break;
            else if (back.isEmpty()) {
                continue;
            }
        }
    }

    public static void removeContact(phoneBook phoneBook, Scanner scan) {
        System.out.println("\nEnter \"back\" to back in the main menu or \"exit\" to leave from the app");
        System.out.print("\n\nWrite name: ");
        String name3 = scan.nextLine();
        if (name3.equalsIgnoreCase("back"))
            return;
        else if (name3.equalsIgnoreCase("exit"))
            System.exit(0);
        phoneBook.removeContact(name3);
        System.out.println("\nDo you want to see new list of contacts?" + "\nEnter \"yes\" if you want to see or enter \"no\" if not.");
        String decision = scan.nextLine();
        if (decision.equalsIgnoreCase("yes"))
            listOfContacts(phoneBook, scan);
        else if (decision.equalsIgnoreCase("no"))
            return;
    }

    public static void listOfContacts(phoneBook phoneBook, Scanner scan) {
        System.out.println("=================================================================================================");
        phoneBook.listOfContacts();
        System.out.println("=================================================================================================");
        System.out.println(enterOneOption());
        scan.nextLine();
    }

    public static void editContact(phoneBook phoneBook, Scanner scan) {
        System.out.println("\nEnter \"back\" to back in the main menu or \"exit\" to leave from the app");
        System.out.println("\n\uD83D\uDED1❗Write number with country code \"+996\" and 9 digits after it❗");
        System.out.print("\n\nWrite a contact that you want to edit: ");
        String name = scan.nextLine();
        Contact find = phoneBook.findContact(name);
        if (name.equalsIgnoreCase("back"))
            return;
        if (name.equalsIgnoreCase("exit"))
            System.exit(0);
        if (find != null) {
            System.out.print("\nWrite new name for the contact: ");
            String newName = scan.nextLine();
            if (newName.equalsIgnoreCase("back"))
                return;
            if (newName.equalsIgnoreCase("exit"))
                System.exit(0);
            System.out.print("\nWrite new number for the contact: ");
            String newNumber = scan.nextLine();
            if (newNumber.equalsIgnoreCase("back"))
                return;
            if (newNumber.equalsIgnoreCase("exit"))
                System.exit(0);

            phoneBook.editContact(name, newName, newNumber);
            System.out.println("You have successfully edited a contact: ");
            System.out.println("=================================================================================================");
            System.out.println("Name: " + newName + "\t Number: " + newNumber);
            System.out.println("=================================================================================================");
        } else {
            System.out.println("\n\uD83D\uDED1There no contacts like that\uD83D\uDED1");
        }
        System.out.println(enterOneOption());
        scan.nextLine();
    }

    public static String enterTwoOptions() {
        return "Press \"ENTER\" to continue, or enter \"back\" to return in the Main menu";
    }
    public static String enterOneOption() {
        return "Press \"ENTER\" to return in the main menu";
    }
}


































