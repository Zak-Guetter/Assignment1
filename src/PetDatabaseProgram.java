import java.util.ArrayList;
import java.util.Scanner;

public class PetDatabaseProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetDatabase database = new PetDatabase();
        boolean running = true;

        System.out.println("Pet Database Program.");
        while (running) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1) View all pets");
            System.out.println("2) Add more pets");
            System.out.println("3) Search pets by name");
            System.out.println("4) Search pets by age");
            System.out.println("5) Exit program");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    database.showPets();
                    break;
                case 2:
                    System.out.println("Add pet (name, age): ");
                    while (true) {
                        System.out.print("Enter name and age (or type 'done' to finish): ");
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("done")) break;
                        String[] parts = input.split(" ");
                        if (parts.length == 2) {
                            String name = parts[0];
                            int age = Integer.parseInt(parts[1]);
                            database.addPet(name, age);
                        } else {
                            System.out.println("Invalid input. Please enter name and age.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter a name to search: ");
                    String searchName = scanner.nextLine();
                    database.searchByName(searchName);
                    break;
                case 4:
                    System.out.print("Enter age to search: ");
                    int searchAge = scanner.nextInt();
                    database.searchByAge(searchAge);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        scanner.close();
    }
}