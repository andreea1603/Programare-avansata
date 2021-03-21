import java.util.HashMap;
import java.util.Map;

public abstract class Item implements java.io.Serializable {
    private String id;
    private String name;

    private String location;

    private Map<String, Object> tags=new HashMap<>();

    public void addTag(String key, Object obj){
        tags.put(key, obj);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public Item() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "\n\t\tItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}' + '\n';
    }
}
