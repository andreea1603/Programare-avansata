import java.util.Objects;

public class Destination {
     String name;
     int demand;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return demand == that.demand && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, demand);
    }

    @Override
    public String toString() {
        return "\tDestination{" +
                "name='" + name + '\'' +
                ", demand=" + demand +
                '}' +" \n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public Destination(String name, int demand) {
        this.name = name;
        this.demand= demand;
    }
}
