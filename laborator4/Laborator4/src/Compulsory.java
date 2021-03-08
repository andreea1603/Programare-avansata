import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.*;
public class Compulsory {
    public static void main(String[] args) {

        var Students= IntStream.rangeClosed(0,3)
                .mapToObj(i-> new Student("S" + i))
                .toArray(Student[] ::new);
        var Schools= IntStream.rangeClosed(0,3)
                .mapToObj(i-> new School("H" + i))
                .toArray(School[] ::new);
        Schools[0].addCapacity(1);  Schools[1].addCapacity(2);  Schools[2].addCapacity(2);
        Schools[0].addPreferences(Arrays.asList(Students[3],Students[0], Students[1],Students[2]));
        Schools[1].addPreferences(Arrays.asList(Students[0], Students[2], Students[1]));
        Schools[2].addPreferences(Arrays.asList(Students[0], Students[1], Students[3]));
        Students[0].addPreferences(Arrays.asList(Schools[0], Schools[1], Schools[2]));
        Students[1].addPreferences(Arrays.asList(Schools[0], Schools[1], Schools[2]));
        Students[2].addPreferences(Arrays.asList(Schools[0], Schools[1]));
        Students[3].addPreferences(Arrays.asList(Schools[0], Schools[2]));


        for(int i=0; i< 4; i++)
            System.out.println(Students[i]);


        ///LinkedList
        LinkedList<Student> listOfStudents= new LinkedList<Student>();
        listOfStudents.add(Students[0]); listOfStudents.add(Students[1]);
        listOfStudents.add(Students[2]); listOfStudents.add(Students[3]);
        listOfStudents.sort(new StudName());

        //TreeSet
        TreeSet<School> listOfSchools = new TreeSet<School>(new SchoolName());
        listOfSchools.add(Schools[2]);
        listOfSchools.add(Schools[1]);
        listOfSchools.add(Schools[0]);

        System.out.println("Studenti in lista:  \n\t" + listOfStudents + '\n');
        System.out.println("Scoli in treeset:  \n\t" + listOfSchools + '\n');

        ////Maps

        Map<Student, List<School>> prefernces1= new HashMap<Student, List<School>>();

        prefernces1.put(Students[0], Arrays.asList(Schools[0], Schools[1], Schools[2]));
        prefernces1.put(Students[1], Arrays.asList(Schools[0], Schools[1], Schools[2]));
        prefernces1.put(Students[2], Arrays.asList(Schools[0], Schools[1]));
        prefernces1.put(Students[3], Arrays.asList(Schools[0], Schools[2]));

        System.out.println("Map Students");
        for(Map.Entry<Student, List<School>> it : prefernces1.entrySet()){
            System.out.print("\t"+ it.getKey()+ " + " );
            System.out.println(it.getValue());
        }

        ///Map School
        Map<School, LinkedList<Student>> prefernces2= new HashMap<School, LinkedList<Student>>();
        LinkedList<Student> ListOfStudents= new LinkedList<Student>();
        ListOfStudents.add(Students[3]);    ListOfStudents.add(Students[0]);
        ListOfStudents.add(Students[1]);    ListOfStudents.add(Students[2]);

        LinkedList<Student> ListofStudents1= new LinkedList<Student>();
        ListofStudents1.add(Students[0]);   ListofStudents1.add(Students[2]); ListofStudents1.add(Students[1]);

        LinkedList<Student> ListofStudents2= new LinkedList<Student>();
        ListofStudents2.add(Students[0]);       ListofStudents2.add(Students[1]);ListofStudents2.add(Students[3]);

        prefernces2.put(Schools[0], ListOfStudents);
        prefernces2.put(Schools[1],ListofStudents1);
        prefernces2.put(Schools[2],ListofStudents2);

        System.out.println("Map Students");
        for(Map.Entry<School, LinkedList<Student>> it : prefernces2.entrySet()){
            System.out.print("\t"+ it.getKey()+ " + " );
            System.out.println(it.getValue());
        }

    }
}
