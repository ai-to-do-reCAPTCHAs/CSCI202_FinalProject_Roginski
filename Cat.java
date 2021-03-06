import java.text.ParseException;

class Cat extends Animal {
    /* Data Fields */
    private String color;


    /* Constructor */
    public Cat (String name, int age, char gender, boolean rescue, String owner, String color) {
        super(name, age, gender, rescue, owner);
        this.color = color;
    }

    public Cat(String[] tokens) throws ParseException {
        super(Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]), tokens[4].charAt(0), Boolean.parseBoolean(tokens[5]), tokens[6]);
        this.color = tokens[7];
    }


    /* Other methods */
    public String getColor() {
        return this.color;
    }

    @Override
    public String speak() {
        String speak = "\"";

        int phrase = (int)(Math.random() * 2);      /* Generate random number from 0 to 1 */
        int amount = (int)(Math.random() * 2) + 1;  /* Generate random number from 1 to 2 */

        for (int i = 0; i < amount; i++) {
            if (phrase == 0) {
                speak += "Meow";
            } else if (phrase == 1) {
                speak += "Mew";
            }

            if (amount > 1 && i < (amount - 1)) {
                speak += " ";
            }
        }

        speak += "!\"";

        return speak;
    }

    /**
     * Mittens [Cat]    Meow!
         Rescued and Adopted!
         Adopted by John Doe on 03/14/2021
         Chip ID: 123456789
         Gender: Female
         Age: 2 years old
         Color: Calico
         Favorite Toy:
             - Yellow Yarn
     */
    public String toString() {
        String details = this.getName() + " [Cat]\t" + this.speak() + "\n";

        if (this.isRescue() && this.isAdopted()) {
            details += "  Rescued and Adopted!\n  Adopted by " + this.getOwner();
        } else if (this.isRescue() && !this.isAdopted()) {
            details += "  Rescued!\n";
        } else if (!this.isRescue() && this.isAdopted()) {
            details += "  Adopted!\n  Adopted by " + this.getOwner();
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

        details += "  Color: " + this.getColor() + "\n";

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
        return ("Cat\t" + this.getChipID() + "\t" + this.getName() + "\t" + this.getAge() + "\t" + this.getGender() + "\t" + this.isRescue() + "\t" + this.getOwner() + "\t" + this.getColor());
    }
}
