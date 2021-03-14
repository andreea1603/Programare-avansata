import java.util.*;
public class Student implements Comparable<Student>{
    String name;
    List<School> preferences= new ArrayList<School>();
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public Student(String name, List<School> preferences, int grade) {
        this.name = name;
        this.preferences = preferences;
        this.grade = grade;
    }

    public void addPreferences(List<School> preferences){
        // System.out.println("hei, sunt aici" + preferences.size());

        for(int i=0; i< preferences.size(); i++) {
            this.preferences.add(preferences.get(i));
        }
        // System.out.println(this.preferences.toString() + " paa1");

    }

    public void addPreferences(School preferences){

        this.preferences.add(preferences);
        System.out.println(preferences );
    }
    public void afis(){
        //System.out.println(preferences.size());
    }
    @Override
    public int compareTo(Student other) {
        return ( other.grade- this.grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", preferences=" + preferences +
                ", grade=" + grade +
                '}';
    }
}
