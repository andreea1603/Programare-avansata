import java.util.HashMap;
import java.util.Map;
public abstract class Locations implements Comparable<Locations>{
    String name;
    double coordinates;
    Map<Locations, Integer> time1= new HashMap<>();

    Locations(String name, Map<Locations, Integer> time)
    {
        this.name=name;
        this.time1=time;
    }
    Locations(String name)
    {
        this.name=name;
    }
    Locations()
    {
    }
    public void setCost(Locations node, int value){
        time1.put(node, value);
    }
    public void setName(String name)
    {
        this.name=name;
    }
    @Override
    public int compareTo(Locations other){
        if(this.name!=null)
            return this.name.compareTo(other.name);
        return 0;
    }

    @Override
    public String toString() {
        return '\n'+"Locations{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
