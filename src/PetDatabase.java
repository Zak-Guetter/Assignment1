import java.util.ArrayList;

class PetDatabase {
    private ArrayList<Pet> pets = new ArrayList<>();

    public void addPet(String name, int age) {
        pets.add(new Pet(name, age));
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
     * Updates the name and age of a pet specified by its ID (index in the list).
     * If the ID is invalid, an error message is displayed.
     *
     * @param id       the ID (index) of the pet to update
     * @param newName  the new name for the pet
     * @param newAge   the new age for the pet
     */
    public void updatePet(int id, String newName, int newAge) {
        if (id >= 0 && id < pets.size()) {
            Pet pet = pets.get(id);
            pet.setName(newName);
            pet.setAge(newAge);
            System.out.println("Pet updated successfully.");
        } else {
            System.out.println("Invalid pet ID.");
        }
    }

    /**
     * Removes a pet from the database based on its ID (index in the list).
     * If the ID is invalid, an error message is displayed.
     *
     * @param id  the ID (index) of the pet to remove
     */
    public void removePet(int id) {
        if (id >= 0 && id < pets.size()) {
            pets.remove(id);
            System.out.println("Pet removed successfully.");
        } else {
            System.out.println("Invalid pet ID.");
        }
    }

    /**
     * Searches for pets by name and displays a table of pets with the specified name.
     * The search is case-insensitive.
     * Displays the number of matching rows in the set.
     *
     * @param name  the name of the pet(s) to search for
     */
    public void searchByName(String name) {
        System.out.println("+----------------------+");
        System.out.println("| ID | NAME      | AGE |");
        System.out.println("+----------------------+");
        int count = 0;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getName().equalsIgnoreCase(name)) {
                System.out.printf("| %-3d| %s |\n", i, pets.get(i));
                count++;
            }
        }
        System.out.println("+----------------------+");
        System.out.println(count + " rows in set.");
    }

    /**
     * Searches for pets by age and displays a table of pets with the specified age.
     * Displays the number of matching rows in the set.
     *
     * @param age  the age of the pet(s) to search for
     */
    public void searchByAge(int age) {
        System.out.println("+----------------------+");
        System.out.println("| ID | NAME      | AGE |");
        System.out.println("+----------------------+");
        int count = 0;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getAge() == age) {
                System.out.printf("| %-3d| %s |\n", i, pets.get(i));
                count++;
            }
        }
        System.out.println("+----------------------+");
        System.out.println(count + " rows in set.");
    }
}
