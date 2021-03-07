import java.util.HashMap;
import java.util.Map;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.*;

public abstract class Locations implements Comparable<Locations> {
    public String name;
    double coordinates;
    Map<Locations, Integer> time1 = new HashMap<>();

    Locations(String name, Map<Locations, Integer> time) {
        this.name = name;
        this.time1 = time;
    }

    Locations(String name) {
        this.name = name;
    }

    Locations() {
    }

    public void setCost(Locations node, int value) {
        time1.put(node, value);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Locations other) {
        return ((((Visitable) (this)).getOpeningTime()).compareTo(((Visitable) other).getOpeningTime()));
    }

    @Override
    public String toString() {
        return '\n' + '\t' + "Locations{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }

}
