import java.util.Arrays;

public class Problem {
    Source[] s;
    Destination[] d;
    int[][] capacities;

    public Problem(Source[] s, Destination[] d, int[][] capacities) {

        this.s = s;
        this.d = d;
        this.capacities = capacities;
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
        return capacities;
    }

    public void setCapacities(int[][] capacities) {
        this.capacities = capacities;
    }

    @Override
    public String toString() {
        String cap= new String();
        for(int i[] : capacities)
            cap = cap + Arrays.toString(i);
        return "Problem{" +
                "\ns=" + Arrays.toString(s) +
                ", \nd=" + Arrays.toString(d) +
                ", \ncapacities=" + cap + "\n" +
                '}';
    }
}
