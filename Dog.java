import java.text.ParseException;
import java.util.ArrayList;

class Dog extends Animal {
    /* Data Fields */
    private String breed;


    /* Constructors */
    public Dog (String name, int age, char gender, boolean rescue, String owner, String breed) {
        super(name, age, gender, rescue, owner);
        this.breed = breed;
    }

    public Dog(String[] tokens) throws ParseException {
        super(Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]), tokens[4].charAt(0), Boolean.parseBoolean(tokens[5]), tokens[6]);
        this.breed = tokens[7];
    }


    /* Other methods */
    public String getBreed() {
        return this.breed;
    }

    @Override
    public String speak() {
        String speak = "\"";

        int phrase = (int)(Math.random() * 3);      /* Generate random number from 0 to 2 */
        int amount = (int)(Math.random() * 3) + 1;  /* Generate random number from 1 to 3 */

        for (int i = 0; i < amount; i++) {
            if (phrase == 0) {
                speak += "Bow Wow";

                break;
            } else if (phrase == 1) {
                speak += "Woof";
            } else if (phrase == 2) {
                speak += "Bark";
            }

            if (amount > 1 && i < (amount - 1)) {
                speak += " ";
            }
        }

        speak += "!\"";

        return speak;
    }

    /**
     * Lucky [Dog]  Bow Wow!
         Rescued and Adopted!
         Adopted by John Doe on 03/14/2021
         Chip ID: 123456789
         Gender: Male
         Age: 2 years old
         Breed: Lab
         Favorite Toy:
             - Red Ball
     */
    public String toString() {
        String details = this.getName() + " [Dog]\t";
        if (this.getName().equals("Lily") && this.getGender() == 'F' && this.getBreed().equals("Tea Cup Poodle")) {
            details += "\"Lily Bug\"\n"; /* In loving memory of Lily */
        } else {
            details += this.speak() + "\n";
        }

        if (this.isRescue() && this.isAdopted()) {
            details += "  Rescued and Adopted!\n  Adopted by " + this.getOwner() + "\n";
        } else if (this.isRescue() && !this.isAdopted()) {
            details += "  Rescued!\n";
        } else if (!this.isRescue() && this.isAdopted()) {
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

        details += "  Breed: " + this.getBreed() + "\n";

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

    @Override
    public String toText() {
        return ("Dog\t" + this.getChipID() + "\t" + this.getName() + "\t" + this.getAge() + "\t" + this.getGender() + "\t" + this.isRescue() + "\t" + this.getOwner() + "\t" + this.getBreed());
    }
}
