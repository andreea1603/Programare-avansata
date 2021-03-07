import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.time.LocalTime;


public class City {
    List<Locations> locations = new ArrayList<>();
    String name;

    City(List<Locations> locations, String name) {
        this.locations = locations;
        this.name = name;
    }

    City() {
    }

    ;

    public List<Locations> getLocations() {
        return locations;
    }

    public void setLocations(List<Locations> locations) {
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addLocation(Locations node) {
        locations.add(node);
    }

    public void Display() {
        List<Locations> l3 = new ArrayList<Locations>();

        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i) instanceof Visitable)
                if ((locations.get(i) instanceof Payable) == false) {
                    l3.add(locations.get(i));
                    //System.out.println(locations.get(i));
                }
        }
        l3.sort(Locations::compareTo);
        System.out.println("Visitable, but not payble locations: " + l3.toString());
    }

    @Override
    public String toString() {
        return "City{" +
                "locations=" + locations +
                ", name='" + name + '\'' +
                '}';
    }
}
