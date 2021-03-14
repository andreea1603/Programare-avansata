import java.util.*;

public class School {
    String name;
    int capacity;
    List<Student> preferences= new ArrayList<Student>();

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity + '\'' +
                ", preferences=" + preferences.toString() +
                '}'+ '\n';
    }

    public School(String name) {
        this.name = name;
    }

    public School(String name, int capacity, List<Student> preferences) {
        this.name = name;
        this.capacity = capacity;
        this.preferences = preferences;
    }
    public void addCapacity(int capacity){
        this.capacity= capacity;
    }
    public void addPreferences(List<Student> preferences){
        for(int i=0; i< preferences.size(); i++)
            this.preferences.add(preferences.get(i));
    }
    public void addPreferences(Student preferences){

        this.preferences.add(preferences);
    }
}
