import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class PetShop {
    public static Scanner input = new Scanner(System.in);

    private static Pets pets = new Pets();


    public static void main(String[] args) {
        System.out.print("\n"
                       + "                  __                             __             __    __      \n"
                       + "   _    __ ___   / / ____ ___   __ _  ___       / /_ ___       / /_  / /  ___ \n"
                       + "  | |/|/ // -_) / / / __// _ \\ /  ' \\/ -_)     / __// _ \\     / __/ / _ \\/ -_)\n"
                       + "  |__,__/ \\__/ /_/  \\__/ \\___//_/_/_/\\__/      \\__/ \\___/     \\__/ /_//_/\\__/ "
                       + "                                                                              \n"
                       + "              _____         _        _____   _                                \n"
                       + "             |  _  |  ___  | |_     |   __| | |_   ___   ___                  \n"
                       + "             |   __| | -_| |  _|    |__   | |   | | . | | . |                 \n"
                       + "             |__|    |___| |_|      |_____| |_|_| |___| |  _|                 \n"
                       + "                                                        |_|                   \n"
                       + "                                                                              \n"
                       + "           Your one-stop shop for dogs and cats, birds and fish!              \n"
                       + "                         We also rescue pets too!                             \n"
                       + "                                                                              \n"
                       + " ------------<===============================================>----------------\n"
                       + "                                                                              \n"
                       + "    All of our pets are chipped for your convenience (yes, even the fish!)    \n"
                       + "    and are up to date on all vaccinations.                                   \n");

        char command;
        printMenu();

        do {
            /* Ask a user to choose a command */
            String inputing = "";
            do {
                System.out.print("\n\nPlease enter a command or type ?\nCommand: ");
                inputing = input.nextLine().toLowerCase();

                if (inputing.length() != 1) {
                    System.out.println("\nInvalid input.");
                }
            } while (inputing.length() != 1);
            command = inputing.charAt(0);
            System.out.println();

            String name = "";
            int age = 0;
            char gender;
            char rescue;
            boolean isrescue = false;
            String owner = "";
            String breed = ""; /* Also type */
            String color = "";
            char size;
            int chip = 0;
            String toy = "";
            char confirm;

            switch (command) {
                case 'a': /* Add a pet */
                    System.out.println("It's time to welcome a new friend!\n");

                    System.out.print("Please enter the pet's name: ");
                    name = input.nextLine();

                    System.out.println("What kind of animal is " + name + "?\n"
                                     + "  1 - Dog\n"
                                     + "  2 - Cat\n"
                                     + "  3 - Bird\n"
                                     + "  4 - Fish");
                    int type;
                    do {
                        System.out.print("Choose a pet type: ");
                        type = Integer.parseInt(input.nextLine());

                        if (type < 1 || type > 4) {
                            System.out.println("Invalid Input.");
                        }
                    } while (type < 1 || type > 4);

                    do {
                        System.out.print("Please enter " + name + "'s gender: ");
                        gender = input.nextLine().toUpperCase().charAt(0);

                        if (gender != 'M' && gender != 'F') {
                            System.out.println("Invalid input.");
                        }
                    } while (gender != 'M' && gender != 'F');

                    do {
                        System.out.print("Please enter " + name + "'s age in years (if younger than 1 year old, enter 0): ");
                        age = Integer.parseInt(input.nextLine());

                        if (age < 0) {
                            System.out.println("Invalid Input. Age must be greater than or equal to 0.");
                        }
                    } while (age < 0);

                    owner = "Pet Shop";

                    Animal a;
                    if (type == 1) {
                        System.out.print("Please enter " + name + "'s breed: ");
                        breed = input.nextLine();

                        do {
                            System.out.println("Is " + name + " a rescue?\tY / N");
                            rescue = input.nextLine().toUpperCase().charAt(0);

                            if (rescue == 'Y') {
                                isrescue = true;
                            } else if (rescue == 'N') {
                                isrescue = false;
                            } else {
                                System.out.println("Invalid input.");
                            }
                        } while (rescue != 'Y' && rescue != 'N');

                        a = new Dog(name, age, gender, isrescue, owner, breed);
                    } else if (type == 2) {
                        System.out.print("Please enter " + name + "'s color: ");
                        color = input.nextLine();

                        do {
                            System.out.println("Is " + name + " a rescue?\tY / N");
                            rescue = input.nextLine().toUpperCase().charAt(0);

                            if (rescue == 'Y') {
                                isrescue = true;
                            } else if (rescue == 'N') {
                                isrescue = false;
                            } else {
                                System.out.println("Invalid input.");
                            }
                        } while (rescue != 'Y' && rescue != 'N');

                        a = new Cat(name, age, gender, isrescue, owner, color);
                    } else if (type == 3) {
                        System.out.print("Please enter " + name + "'s size (\"S\" for Small, \"M\" for Medium, and \"L\" for Large): ");
                        size = input.nextLine().toUpperCase().charAt(0);

                        System.out.print("Please enter " + name + "'s color: ");
                        color = input.nextLine();

                        do {
                            System.out.println("Is " + name + " a rescue?\tY / N");
                            rescue = input.nextLine().toUpperCase().charAt(0);

                            if (rescue == 'Y') {
                                isrescue = true;
                            } else if (rescue == 'N') {
                                isrescue = false;
                            } else {
                                System.out.println("Invalid input.");
                            }
                        } while (rescue != 'Y' && rescue != 'N');

                        a = new Bird(name, age, gender, isrescue, owner, size, color);
                    } else {
                        System.out.print("Please enter " + name + "'s type: ");
                        breed = input.nextLine();

                        System.out.print("Please enter " + name + "'s color: ");
                        color = input.nextLine();

                        a = new Fish(name, age, gender, owner, breed, color);
                    }

                    if (pets.add(a)) {
                        System.out.print("\n" + a.getName() + " was successfully added!\n\n" + a.toString());
                    } else {
                        System.out.println("\nSomething went wrong and " + a.getName() + " could not be added.");
                    }

                    break;
                case 'b': /* Update adoption records */
                    if (pets.getCount() > 0) {
                        System.out.println("It's adoption day!\n");
                        System.out.print("Please enter the pet's chip ID: ");
                        chip = Integer.parseInt(input.nextLine());

                        Animal b = pets.findByChipID(chip);
                        if (b == null) {
                            System.out.println("A pet with that chip ID could not found.");

                            break;
                        }

                        System.out.print("Please enter the name of the new owner: ");
                        owner = input.nextLine();

                        if (b.adopt(owner)) {
                            pets.newAdopted(b);

                            do {
                                System.out.println("Would you like to change " + b.getName() + "'s name?\tY / N");
                                confirm = input.nextLine().toUpperCase().charAt(0);

                                if (confirm == 'Y') {
                                    System.out.print("Please enter the new name: ");
                                    name = input.nextLine();

                                    b.changeName(name);
                                } else if (confirm == 'N') {
                                    break;
                                } else {
                                    System.out.println("Invalid input.");
                                }
                            } while (confirm != 'Y');

                            System.out.println("\n" + b.speak() + " Congratulations " + b.getName() + "! You have found your new fur-ever home with " + owner + "!");
                        } else {
                            System.out.println("\nSomething went wrong and " + b.getName() + "'s adoption status could not be updated.");
                        }
                    } else {
                        System.out.println("No pets currently exist.");
                    }

                    break;
                case 'c': /* Remove a pet */
                    if (pets.getCount() > 0) {
                        System.out.println("! !  W A R N I N G  ! !");
                        System.out.println("This option will completely remove the pet from the system.\nIf the pet is being adopted, please use Option B in the main menu, as we like to continue to receive updates from our adopted pet friends.");

                        do {
                            System.out.println("Continue?\tY / N");
                            confirm = input.nextLine().toUpperCase().charAt(0);

                            if (confirm == 'Y') {
                                System.out.print("Please enter the pet's chip ID: ");
                                chip = Integer.parseInt(input.nextLine());

                                Animal c = pets.findByChipID(chip);
                                if (c == null) {
                                    System.out.println("\nA pet with that chip ID could not found.");

                                    break;
                                }

                                name = c.getName();

                                if (pets.remove(c)) {
                                    System.out.println("\nPet successfully removed from the system. Goodbye, " + name + ".");
                                } else {
                                    System.out.println("\nSomething went wrong and " + name + " could not be removed from the system.");
                                }
                            } else if (confirm == 'N') {
                                break;
                            } else {
                                System.out.println("Invalid input.");
                            }
                        } while (confirm != 'Y');
                    } else {
                        System.out.println("No pets currently exist.");
                    }

                    break;
                case 'd': /* Display the pets */
                    if (pets.getCount() > 0) {
                        System.out.println("Pets of the Pet Shop:\n\n");

                        System.out.print(pets.toString());
                    } else {
                        System.out.println("No pets currently exist.");
                    }

                    break;
                case 'e': /* Count the pets */
                    Animal e;

                    if (pets.getCount() == 0) {
                        System.out.println("There are no pets in or adopted from the shop.");
                    } else if (pets.getCount() == 1) {
                        e = pets.findByIndex(0);

                        if (pets.totalNotAdopted() == 1 && pets.totalAdopted() == 0) {
                            System.out.println("There is 1 pet in the shop!");

                            if (e instanceof Dog) {
                                System.out.println("It's a dog!");
                            } else if (e instanceof Cat) {
                                System.out.println("It's a cat!");
                            } else if (e instanceof Bird) {
                                System.out.println("It's a bird!");
                            } else if (e instanceof Fish) {
                                System.out.println("It's a fish!");
                            }
                        } else if (pets.totalNotAdopted() == 0 && pets.totalAdopted() == 1) {
                            System.out.println("There was 1 pet adopted from the shop!");

                            if (e instanceof Dog) {
                                System.out.println("It was a dog!");
                            } else if (e instanceof Cat) {
                                System.out.println("It was a cat!");
                            } else if (e instanceof Bird) {
                                System.out.println("It was a bird!");
                            } else if (e instanceof Fish) {
                                System.out.println("It was a fish!");
                            }
                        }
                    } else {
                        if (pets.totalNotAdopted() > 0) {
                            System.out.println("There are " + pets.totalNotAdopted() + " pets in the shop!");

                            if (pets.getTotals(0, 0) > 1) {
                                System.out.println("\t" + pets.getTotals(0, 0) + " are dogs!");
                            } else if (pets.getTotals(0, 0) == 1) {
                                System.out.println("\t1 is a dog!");
                            }
                            if (pets.getTotals(0, 1) > 1) {
                                System.out.println("\t" + pets.getTotals(0, 1) + " are cats!");
                            } else if (pets.getTotals(0, 1) == 1) {
                                System.out.println("\t1 is a cat!");
                            }
                            if (pets.getTotals(0, 2) > 1) {
                                System.out.println("\t" + pets.getTotals(0, 2) + " are birds!");
                            } else if (pets.getTotals(0, 2) == 1) {
                                System.out.println("\t1 is a bird!");
                            }
                            if (pets.getTotals(0, 3) > 1) {
                                System.out.println("\t" + pets.getTotals(0, 3) + " are fish!");
                            } else if (pets.getTotals(0, 3) == 1) {
                                System.out.println("\t1 is a fish!");
                            }
                        }

                        if (pets.totalAdopted() > 0) {
                            System.out.println("There were " + pets.totalAdopted() + " pets adopted from the shop!");

                            if (pets.getTotals(1, 0) > 1) {
                                System.out.println("\t" + pets.getTotals(1, 0) + " were dogs!");
                            } else if (pets.getTotals(1, 0) == 1) {
                                System.out.println("\t1 was a dog!");
                            }
                            if (pets.getTotals(1, 1) > 1) {
                                System.out.println("\t" + pets.getTotals(1, 1) + " were cats!");
                            } else if (pets.getTotals(1, 1) == 1) {
                                System.out.println("\t1 was a cat!");
                            }
                            if (pets.getTotals(1, 2) > 1) {
                                System.out.println("\t" + pets.getTotals(1, 2) + " were birds!");
                            } else if (pets.getTotals(1, 2) == 1) {
                                System.out.println("\t1 was a bird!");
                            }
                            if (pets.getTotals(1, 3) > 1) {
                                System.out.println("\t" + pets.getTotals(1, 3) + " were fish!");
                            } else if (pets.getTotals(1, 3) == 1) {
                                System.out.println("\t1 was a fish!");
                            }
                        }
                    }

                    break;
                case 'f': /* Add a favorite toy */
                    if (pets.getCount() > 0) {
                        System.out.println("Someone has a new favorite toy!\n");
                        System.out.print("Please enter the pet's chip ID: ");
                        chip = Integer.parseInt(input.nextLine());

                        Animal f = pets.findByChipID(chip);
                        if (f == null) {
                            System.out.println("A pet with that chip ID could not found.");

                            break;
                        }

                        System.out.print("Please enter the toy: ");
                        toy = input.nextLine();

                        if (f.addToy(toy)) {
                            System.out.println("\n" + f.speak() + " " + toy + " is one of " + f.getName() + "'s favorite toys!");
                        } else {
                            System.out.println("\nSomething went wrong and " + f.getName() + "'s favorite toys could not be updated.");
                        }
                    } else {
                        System.out.println("No pets currently exist.");
                    }

                    break;
                case 'g': /* Remove a favorite toy */
                    if (pets.getCount() > 0) {
                        System.out.println("Someone has a no longer likes a certain toy!\n");
                        System.out.print("Please enter the pet's chip ID: ");
                        chip = Integer.parseInt(input.nextLine());

                        Animal g = pets.findByChipID(chip);
                        if (g == null) {
                            System.out.println("A pet with that chip ID could not found.");

                            break;
                        }

                        System.out.print("Please enter the toy: ");
                        toy = input.nextLine();

                        if (g.removeToy(toy)) {
                            System.out.println("\n" + g.speak() + " " + toy + " is not longer " + g.getName() + "'s favorite toy.");
                        } else {
                            System.out.println("\nSomething went wrong and " + g.getName() + "'s favorite toys could not be updated.");
                        }
                    } else {
                        System.out.println("No pets currently exist.");
                    }

                    break;
                case 'h': /* Celebrate a birthday */
                    if (pets.getCount() > 0) {
                        System.out.println("It's someone's birthday today!\n");
                        System.out.print("Please enter the pet's chip ID: ");
                        chip = Integer.parseInt(input.nextLine());

                        Animal h = pets.findByChipID(chip);
                        if (h == null) {
                            System.out.println("A pet with that chip ID could not found.");

                            break;
                        }

                        h.birthday();
                        System.out.println("\n"
                                         + "Happy Birthday to you!\n"
                                         + "Happy Birthday to you!\n"
                                         + "Happy Birthday dear " + h.getName() + "!\n"
                                         + "Happy Birthday to you!");
                        System.out.println(h.speak());

                        if (h.getAge() > 1) {
                            System.out.println("\n" + h.getName() + " is now " + h.getAge() + " years old!");
                        } else {
                            System.out.println("\n" + h.getName() + " is now 1 year old!");
                        }

                    } else {
                        System.out.println("No pets currently exist.");
                    }

                    break;
                case 'i': /* Write the pets to a file */
                    System.out.print("Enter file name to write the pets to: ");
                    String filei = input.nextLine();

                    int written = 0;
                    try {
                        written = pets.writePets(filei);
                    } catch (FileNotFoundException i) {
                        System.out.println("The file \"" + filei + "\" could not be found.");

                        i.printStackTrace();
                    }

                    if (written == 1) {
                        System.out.println("1 pet was written to the file \"" + filei + "\".");
                    } else if (written > 1) {
                        System.out.println(written + " pets were written to the file \"" + filei + "\".");
                    } else {
                        System.out.println("No pets were written to the file \"" + filei + "\".");
                    }

                    break;
                case 'j': /* Read the pets listed in a file */
                    System.out.print("Enter file name to read pets from: ");
                    String filej = input.nextLine();

                    try {
                        System.out.println(readPets(filej) + " were read in the file " + filej);
                    } catch (FileNotFoundException j) {
                        System.out.println("The file \"" + filej + "\" could not be found.");

                        j.printStackTrace();
                    }

                    break;
                case 'q': /* Quit the program */
                    System.out.println("\nThank you for visiting!\nCome again!");

                    break;
                case '?': /* Reprint menu options */
                    printMenu();

                    break;
                default:
                    System.out.println("Invalid Input.");

                    break;
            }

        } while (command != 'q');

        input.close();
    }

    /**
     * Print the menu containing the actions that the user can preform
     */
    public static void printMenu() {
        System.out.println();
        System.out.println("            Pet Shop  OPTIONS           \n"
                         + "----<===============================>----\n"
                         + "\t a: Add a new pet to the shop\n"
                         + "\t b: Update adoption records\n"
                         + "\t c: Remove a pet from the shop\n"
                         + "\t d: Display the pets in the shop\n"
                         + "\t e: Count the pets in the shop\n"
                         + "\t f: Add a favorite toy\n"
                         + "\t g: Remove a favorite toy\n"
                         + "\t h: Celebrate a birthday!\n"
                         + "\t i: Write the pets to a file\n"
                         + "\t j: Read the pets from a file\n"
                         + "\t q: Quit this program\n\n"
                         + "\t ?: Display this menu again");
    }

    public static int readPets(String filename) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File(filename));

        int animals = 0;
        while(fileScan.hasNext()){
            String line = fileScan.nextLine();

            try {
                pets.add(parseAnimals(line));

                animals++;
            } catch (PetShopFileFormatException e) {
                System.out.println("The file format is not valid.");
            } catch (ParseException p) {
                System.out.println("Could not parse data.");
            }
        }

        return animals;
    }

    public static Animal parseAnimals(String data) throws PetShopFileFormatException, ParseException {
        String[] tokens = data.split("\t");

        if(tokens[0].equals("Dog")) {
            if (tokens.length != 8) {
                throw new PetShopFileFormatException("Not enough information given about the accounts in the file.");
            }

            return new Dog(tokens);
        }  else if(tokens[0].equals("Cat")) {
            if (tokens.length != 8) {
                throw new PetShopFileFormatException("Not enough information given about the accounts in the file.");
            }

            return new Cat(tokens);
        } else if(tokens[0].equals("Bird")) {
            if (tokens.length != 9) {
                throw new PetShopFileFormatException("Not enough information given about the accounts in the file.");
            }

            return new Bird(tokens);
        } else {
            if (tokens.length != 8) {
                throw new PetShopFileFormatException("Not enough information given about the accounts in the file.");
            }

            return new Fish(tokens);
        }
    }
}
