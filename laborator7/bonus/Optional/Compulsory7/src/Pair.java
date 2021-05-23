public class Pair {
    int first, second, value;
    public Pair(int first, int second, int value){
        this.first = first;
        this.second = second;
        this.value =value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                ", value=" + value +
                '}';
    }
}
