import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class PetDatabase {
    private static final int MAX_PETS = 5;
    private ArrayList<Pet> pets = new ArrayList<>();
    private static final String FILE_NAME = "pets.txt";

    public PetDatabase() {
        loadPetsFromFile();
    }

    /**
     * Adds a new pet to the database if there is available space and the age is valid.
     * Displays an error message if the database is full or the age is out of the valid range (1-20).
     *
     * @param name the name of the pet to add
     * @param age  the age of the pet to add; must be between 1 and 20, inclusive
     */
    public void addPet(String name, int age) {
        if (pets.size() >= MAX_PETS) {
            System.out.println("Error: Database is full.");
        } else if (age < 1 || age > 20) {
            System.out.println("Error: " + age + " is not a valid age.");
        } else {
            pets.add(new Pet(name, age));
            System.out.println("Pet added successfully.");
        }
    }

    /**
     * Displays all pets in the database in a formatted table.
     * Each pet is listed with an ID (index in the list), name, and age.
     * The table includes headers and a footer showing the number of rows.
     */
    public void showPets() {
        System.out.println("+----------------------+");
        System.out.println("| ID | NAME      | AGE |");
        System.out.println("+----------------------+");
        for (int i = 0; i < pets.size(); i++) {
            System.out.printf("| %-3d| %s |\n", i, pets.get(i));
        }
        System.out.println("+----------------------+");
        System.out.println(pets.size() + " rows in set.");
    }

    /**
     * Removes a pet from the database based on its ID (index in the list).
     * If the ID is invalid, an error message is displayed.
     *
     * @param id  the ID (index) of the pet to remove
     */
    public void removePet(int id) {
        if (id < 0 || id >= pets.size()) {
            System.out.println("Error: ID " + id + " does not exist.");
        } else {
            pets.remove(id);
            System.out.println("Pet removed successfully.");
        }
    }

    /**
     * Loads pet data from a file into the database.
     * Each line in the file should contain a pet's name and age separated by a comma.
     * If a line does not contain exactly two values or if the name is invalid, an error message is displayed.
     * If the file cannot be found or accessed, an error message is displayed.
     */
    public void loadPetsFromFile() {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int age = Integer.parseInt(parts[1].trim());
                    if (name == null || name.length() == 0) {
                        System.out.println("Error: Invalid pet: " + Arrays.toString(parts));
                    }
                    pets.add(new Pet(name, age));
                } else {
                    System.out.println("Error: Need a name and age for every pet in file.");
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load pets from file.");
        }
    }

    /**
     * Saves all pets in the database to a file.
     * Each pet's name and age are written on a new line, separated by a comma.
     * If the file cannot be written to, an error message is displayed.
     */
    public void savePetsToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Pet pet : pets) {
                writer.write(pet.getName() + "," + pet.getAge() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Could not save pets to file.");
        }
    }
}
