import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Pets {
    /* Data Fields */
    private ArrayList<Animal> animals;
    private int count;
    private int[][] totals;


    /* Constructor */
    public Pets() {
        animals = new ArrayList<>();
        count = 0;

        totals = new int[][]{ {0, 0, 0, 0},     /* Not Adopted: Dogs, Cats, Birds, Fish */
                              {0, 0, 0, 0} };   /* Adopted: Dogs, Cats, Birds, Fish */
    }


    /* Other methods */
    public int getCount() {
        return this.count;
    }

    public boolean add(Animal a) {
        if (!this.contains(a)) {
            animals.add(a);
            count++;

            if (a instanceof Dog) {
                this.totals[0][0]++;
            } else if (a instanceof Cat) {
                this.totals[0][1]++;
            } else if (a instanceof Bird) {
                this.totals[0][2]++;
            } else if (a instanceof Fish) {
                this.totals[0][3]++;
            }

            return true;
        }

        return false;
    }


    public boolean remove(Animal a) {
        if (this.count > 0 && contains(a)) {
            if (a.isAdopted()) {
                if (a instanceof Dog) {
                    this.totals[1][0]--;
                } else if (a instanceof Cat) {
                    this.totals[1][1]--;
                } else if (a instanceof Bird) {
                    this.totals[1][2]--;
                } else if (a instanceof Fish) {
                    this.totals[1][3]--;
                }
            } else {
                if (a instanceof Dog) {
                    this.totals[0][0]--;
                } else if (a instanceof Cat) {
                    this.totals[0][1]--;
                } else if (a instanceof Bird) {
                    this.totals[0][2]--;
                } else if (a instanceof Fish) {
                    this.totals[0][3]--;
                }
            }

            int location = indexOf(a);
            animals.remove(location);
            count--;

            return true;
        }

        return false;
    }

    public void newAdopted(Animal a) {
        if (a instanceof Dog) {
            this.totals[0][0]--;
            this.totals[1][0]++;
        } else if (a instanceof Cat) {
            this.totals[0][1]--;
            this.totals[1][1]++;
        } else if (a instanceof Bird) {
            this.totals[0][2]--;
            this.totals[1][2]++;
        } else if (a instanceof Fish) {
            this.totals[0][3]--;
            this.totals[1][3]++;
        }
    }

    public int getTotals(int adopted, int animal) {
        return this.totals[adopted][animal];
    }

    public int totalNotAdopted() {
        return (this.totals[0][0] + this.totals[0][1] + this.totals[0][2] + this.totals[0][3]);
    }

    public int totalAdopted() {
        return (this.totals[1][0] + this.totals[1][1] + this.totals[1][2] + this.totals[1][3]);
    }

    private int indexOf(Animal a) {
        for (int i = 0; i < count; i++) {
            if (this.animals.get(i).equals(a)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(Animal a) {
        for (int i = 0; i < count; i++) {
            if (this.animals.get(i).equals(a)) {
                return true;
            }
        }

        return false;
    }

    public Animal findByChipID(int chip) {
        for (int i = 0; i < count; i++) {
            if (animals.get(i).getChipID() == chip) {
                return animals.get(i);
            }
        }

        return null;
    }

    public Animal findByIndex(int index) {
        if (animals.size() >= (index + 1)) {
            return animals.get(index);
        }

        return null;
    }

    /**
     * Display all of the Animals in an easy-to-read format
     */
    public String toString() {
        String pets = "";

        for (int i = 0; i < count; i++) {
            pets += animals.get(i).toString();

            if (i < (count - 1)) {
                pets += "\n";
            }
        }

        return pets;
    }

    public int writePets(String filename) throws FileNotFoundException {
        File file = new File(filename);

        PrintWriter pw = new PrintWriter(file);

        int total = 0;
        for (int i = 0; i < animals.size(); i++) {
            pw.println(animals.get(i).toText());

            total++;
        }

        pw.close();

        return total;
    }
}
