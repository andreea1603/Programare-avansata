import java.util.Arrays;

public class Problem {
    Source[] s;
    Destination []d;
    int[][] costs;

    public Problem(Source[] s, Destination d[], int[][] costs) {
        int ok = 0;

        if (s[0] != null)
            for (int i = 0; i < s.length - 1; i++)
                for (int j = i + 1; j < s.length; j++)
                    if (s[i].equals(s[j])) {
                        System.out.println("Exista doua surse identice!");
                        throw new ArithmeticException("They are not unique");
                        //ok=1;
                    }
        for (int i = 0; i < d.length - 1; i++)
            for (int j = i + 1; j < d.length; j++)
                if (d[i].equals(d[j])) {
                    System.out.println("Exista doua destinatii identice!");
                    throw new ArithmeticException("They are not unique");
                }

        this.s = s;
        this.d = d;
        System.out.println(this.d[0].name);
        this.costs = costs;

    }

    public Source[] getS() {
        return s;
    }

    public void setS(Source[] s) {
        this.s = s;
    }

    public Destination[] getD() {
        return d;
    }

    public void setD(Destination[] d) {
        this.d = d;
    }

    public int[][] getCapacities() {
        return costs;
    }

    public int add(Source s1) {
        if (s[0] != null)
            for (int i = 0; i < this.s.length; i++) {
                if (this.s[i].equals(s1) == true) {
                    System.out.println("Exista deja!");
                    return 0;
                }
            }

        this.s = Arrays.copyOf(this.s, this.s.length + 1);
        this.s[this.s.length - 1] = s1;
        System.out.println(this.s.toString());
        return 1;

    }

    public int add(Destination d1) {
        for (int i = 0; i < this.d.length; i++) {
            if (this.d[i].equals(d1) == true) {
                System.out.println("Exista deja!");
                return 0;
            }
        }

        this.d = Arrays.copyOf(this.d, this.d.length + 1);
        this.d[this.d.length - 1] = d1;
        return 1;

    }

    public void setCapacities(int[][] capacities) {
        this.costs = capacities;
    }

    @Override
    public String toString() {
        String addC = new String();
        for (int capacity[] : costs)
            addC = addC + Arrays.toString(capacity);
        return "Problem{" +
                "\ns=" + Arrays.toString(s) +
                ", \nd=" + Arrays.toString(d) +
                ", \ncapacities=" + addC + "\n" +
                '}';
    }
}
