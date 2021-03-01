import java.util.List;

public class City {
    List<Locations> locations;
    String name;

    City(List<Locations> locations, String name)
    {
        this.locations=locations;
        this.name=name;
    }
    City(){};

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
    public void addLocation(Locations node){
        locations.add(node);
    }

    @Override
    public String toString() {
        return "City{" +
                "locations=" + locations +
                ", name='" + name + '\'' +
                '}';
    }
}
