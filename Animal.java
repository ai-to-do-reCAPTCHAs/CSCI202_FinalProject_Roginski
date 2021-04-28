import java.text.ParseException;
import java.util.ArrayList;

public abstract class Animal {
    /* Data Fields */
    protected String name;
    protected int age;
    protected char gender;
    protected ArrayList<String> toys;
    protected boolean rescue;
    protected String owner;
    protected int chipID;


    /* Constructors */
    public Animal(String name, int age, char gender, boolean rescue, String owner) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.toys = new ArrayList<>();
        this.rescue = rescue;
        this.owner = owner;
        this.chipID = generateChipID();
    }

    public Animal(int chipID, String name, int age, char gender, boolean rescue, String owner) throws ParseException {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.toys = new ArrayList<>();
        this.rescue = rescue;
        this.owner = owner;
        this.chipID = chipID;
    }


    /* Other methods */
    public String getName() {
        return this.name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void birthday() {
        this.age++;
    }

    public char getGender() {
        return this.gender;
    }

    public ArrayList<String> getToys() {
        return this.toys;
    }

    public int findToy(String toy) {
        if (this.toys.size() > 0) {
            for (int i = 0; i < this.toys.size(); i++) {
                if (this.toys.get(i).equals(toy)) {
                    return i;
                }
            }
        }

        return -1;
    }

    public boolean addToy(String toy) {
        if (this.findToy(toy) == -1) {
            this.toys.add(toy);

            return true;
        }

        return false;
    }

    public boolean removeToy(String toy) {
        if (this.findToy(toy) != -1) {
            this.toys.remove(this.findToy(toy));

            return true;
        }

        return false;
    }

    public boolean isRescue() {
        return this.rescue;
    }

    public boolean isAdopted() {
        if (this.owner.equals("Pet Shop")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean adopt(String owner) {
        if (!this.isAdopted()) {
            this.owner = owner;

            return true;
        }

        return false;
    }

    public String getOwner() {
        return this.owner;
    }

    public abstract String speak();

    private int generateChipID() {
        int num = 000000000;
        int multiplier = 100000000;

        for (int i = 0; i < 9; i++) {
            int digit = (int)(Math.random() * 10); /* Generate random number from 0 to 9 */

            num += digit * multiplier;

            multiplier = multiplier / 10;
        }

        return num;
    }

    public int getChipID() {
        return this.chipID;
    }

    /**
     * Buddy
         Rescued and Adopted!
         Adopted by John Doe on 03/14/2021
         Chip ID: 123456789
         Age: 2 years old
         Favorite Toy:
             - Teddy Bear
     */
    public String toString() {
        String details = (this.getName() + "\n");

        if (isRescue() && isAdopted()) {
            details += "  Rescued and Adopted!\n  Adopted by " + this.getOwner() + "\n";
        } else if (isRescue() && !isAdopted()) {
            details += "  Rescued!\n";
        } else if (!isRescue() && isAdopted()) {
            details += "  Adopted!\n  Adopted by " + this.getOwner() + "\n";
        }

        details += "  Chip ID: " + this.getChipID() + "\n";

        if (this.getGender() == 'M') {
            details += "  Gender: Male\n";
        } else if (this.getGender() == 'F') {
            details += "  Gender: Female\n";
        }

        if (this.getAge() > 1) {
            details += "  Age: " + this.getAge() + " years old\n";
        } else if (this.getAge() == 1) {
            details += "  Age: 1 year old\n";
        } else {
            details += "  Age: Less than 1 year old\n";
        }

        if (this.getToys().size() > 0) {
            if (this.getToys().size() > 1) {
                details += "  Favorite Toys:\n";
            } else if (this.getToys().size() == 1) {
                details += "  Favorite Toy:\n";
            }

            for (int i = 0; i < this.getToys().size(); i++) {
                details += "\t - " + this.toys.get(i) + "\n";
            }
        }

        return details;
    }

    public abstract String toText();
}
