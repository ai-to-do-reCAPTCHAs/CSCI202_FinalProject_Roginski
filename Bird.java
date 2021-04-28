import java.text.ParseException;

class Bird extends Animal {
    /* Data Fields */
    private char size;
    private String color;


    /* Constructor */
    public Bird (String name, int age, char gender, boolean rescue, String owner, char size, String color) {
        super(name, age, gender, rescue, owner);
        this.size = size;
        this.color = color;
    }

    public Bird(String[] tokens) throws ParseException {
        super(Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]), tokens[4].charAt(0), Boolean.parseBoolean(tokens[5]), tokens[6]);
        this.size = tokens[7].charAt(0);
        this.color = tokens[8];
    }


    /* Other methods */
    public char getSize() {
        return this.size;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public String speak() {
        String speak = "\"";

        int phrase = (int)(Math.random() * 2);      /* Generate random number from 0 to 1 */
        int amount = (int)(Math.random() * 3) + 1;  /* Generate random number from 1 to 3 */

        for (int i = 0; i < amount; i++) {
            if (phrase == 0) {
                speak += "Tweet";
            } else if (phrase == 1) {
                speak += "Chirp";
            }

            if (amount > 1 && i < (amount - 1)) {
                speak += " ";
            }
        }

        speak += "!\"";

        return speak;
    }

    /**
     * Walter [Bird]    Tweet Tweet!
         Rescued and Adopted!
         Adopted by John Doe on 03/14/2021
         Chip ID: 123456789
         Gender: Male
         Age: 2 years old
         Size: Small
         Color: Blue
         Favorite Toy:
             - Millet
     */
    public String toString() {
        String details = this.getName() + " [Bird]\t";
        if (this.getName().equals("Walter") && this.getGender() == 'M' && this.getSize() == 'S' && this.getColor().equals("Blue")) {
            details += "\"The Goodest Boy\"\n"; /* In loving memory of Walter */
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

        if (this.getSize() == 'S') {
            details += "  Size: Small\n";
        } else if (this.getSize() == 'M') {
            details += "  Size: Medium\n";
        } else if (this.getSize() == 'L') {
            details += "  Size: Large\n";
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
        return ("Bird\t" + this.getChipID() + "\t" + this.getName() + "\t" + this.getAge() + "\t" + this.getGender() + "\t" + this.isRescue() + "\t" + this.getOwner() + "\t" + this.getSize() + "\t" + this.getColor());
    }
}
