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

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}';
    }
}
