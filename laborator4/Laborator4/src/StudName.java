import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
public class StudName implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2){
        return (s1.name.compareTo(s2.name));
    }

}
