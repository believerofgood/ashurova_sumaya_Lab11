import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int choice;

        do {
            printMenu();
            choice = SafeInput.getRangedInt(input, "Enter choice", 1, 5);

            switch (choice) {
                case 1:
                    printList(list);
                    break;
                case 2:
                    addItem(list, input);
                    break;
                case 3:
                    deleteItem(list, input);
                    break;
                case 4:
                    insertItem(list, input);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    public static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Print List");
        System.out.println("2 - Add Item");
        System.out.println("3 - Delete Item");
        System.out.println("4 - Insert Item");
        System.out.println("5 - Quit");
        System.out.print("Enter choice: ");
    }

    public static void printList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + ": " + list.get(i));
            }
        }
    }

    public static void addItem(ArrayList<String> list, Scanner input) {
        String item = SafeInput.getNonZeroLenString(input, "Enter item to add");
        list.add(item);
        System.out.println(item + " added.");
    }

    public static void deleteItem(ArrayList<String> list, Scanner input) {
        if (list.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        printList(list);
        int index = SafeInput.getRangedInt(input, "Enter index to delete", 0, list.size() - 1);
        System.out.println(list.remove(index) + " deleted.");
    }

    public static void insertItem(ArrayList<String> list, Scanner input) {
        String item = SafeInput.getNonZeroLenString(input, "Enter item to insert");
        int index = SafeInput.getRangedInt(input, "Enter index to insert at", 0, list.size());
        list.add(index, item);
        System.out.println(item + " inserted at index " + index);
    }
}
