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
            System.out.println("2) Add new pets");
            System.out.println("3) Remove a pet");
            System.out.println("4) Exit program");
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
                            try {
                                int age = Integer.parseInt(parts[1]);
                                database.addPet(name, age);
                            } catch (NumberFormatException e) {
                                System.out.println("Error: " + parts[1] + " is not a valid age.");
                            }
                        } else {
                            System.out.println("Error: " + input + " is not a valid input.");
                        }
                    }
                    break;
                case 3:
                    database.showPets();
                    System.out.print("Enter the pet ID to remove: ");
                    int removeId = scanner.nextInt();
                    database.removePet(removeId);
                    break;
                case 4:
                    database.savePetsToFile();
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
