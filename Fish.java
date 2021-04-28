import java.text.SimpleDateFormat;

class Fish extends Animal {
    /* Data Fields */
    private String type;
    private String color;


    /* Constructor */
    public Fish (String name, int age, char gender, String owner, String type, String color) {
        super(name, age, gender, false, owner);
        this.type = type;
        this.color = color;
    }


    /* Other methods */
    public String getType() {
        return this.type;
    }

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
                speak += "Glub";
            } else if (phrase == 1) {
                speak += "Blub";
            }

            if (amount > 1 && i < (amount - 1)) {
                speak += " ";
            }
        }

        speak += "!\"";

        return speak;
    }

    /**
     * Douglas [Fish]    Glub Glub!
         Adopted!
         Adopted by John Doe on 03/14/2021
         Chip ID: 123456789
         Gender: Male
         Age: 2 years old
         Type: Betta Fish
         Color: Blue
         Favorite Toy:
             - Bubbles
     */
    public String toString() {
        String details = this.getName() + " ";
        if (this.getName().equals("Douglas") && this.getGender() == 'M' && this.getType().equals("Betta Fish") && this.getColor().equals("Blue")) {
            details += "the Betta Fish\t\"Long Live Douglas the Betta Fish\"\n"; /* In loving memory of Douglas the Betta Fish */
        } else {
            details += "[Fish]\t" + this.speak() + "\n";
        }

        if (isAdopted()) {
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

        details += "  Type: " + this.getType() + "\n";
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
