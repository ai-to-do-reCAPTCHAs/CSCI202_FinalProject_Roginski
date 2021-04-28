import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class Cat extends Animal {
    /* Data Fields */
    private String color;


    /* Constructor */
    public Cat (String name, int age, char gender, boolean rescue, String owner, String color) {
        super(name, age, gender, rescue, owner);
        this.color = color;
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

        if (isRescue() && isAdopted()) {
            details += "  Rescued and Adopted!\n  Adopted by " + this.getOwner() + " on " + (new SimpleDateFormat("MM/dd/yyyy").format(this.getAdoptionDate())) + "\n";
        } else if (isRescue() && !isAdopted()) {
            details += "  Rescued!\n";
        } else if (!isRescue() && isAdopted()) {
            details += "  Adopted!\n  Adopted by " + this.getOwner() + " on " + (new SimpleDateFormat("MM/dd/yyyy").format(this.getAdoptionDate())) + "\n";
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
}
