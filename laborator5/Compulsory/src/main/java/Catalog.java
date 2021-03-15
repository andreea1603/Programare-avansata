import java.util.ArrayList;
import java.util.List;

public class Catalog implements java.io.Serializable{
    private String path;
    private String name;
    private List<Item> items = new ArrayList<>();

    public void add(Item item){
        items.add(item);
    }
    public void list(){
        for( Item item : items){
            System.out.println(item);
        }
    }
    public Item findById(String id){

        for(int i=0; i < items.size(); i++){
            if(items.get(i).equals(id)){
                return items.get(i);
            }
        }
        return null;
    }
    public String getPath(){
        System.out.println(path);
        return this.path;
    }

    public Catalog(String name, String path) {
        this.path = path;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
