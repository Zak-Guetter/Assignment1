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