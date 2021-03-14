import java.util.Comparator;
import java.util.TreeSet;

public class SchoolName implements Comparator<School>{
    public int compare(School h1, School h2){
        return(h1.name.compareTo(h2.name));
    }
}

