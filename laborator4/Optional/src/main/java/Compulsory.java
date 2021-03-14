import com.github.javafaker.Faker;
import com.github.javafaker.Superhero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;
public class Compulsory {
    public static void main(String[] args) {

        var students= IntStream.rangeClosed(0,3)
                .mapToObj(i-> new Student("S" + i, (int)(Math.random()*100000%10)))
                .toArray(Student[] ::new);
        var schools= IntStream.rangeClosed(0,2)
                .mapToObj(i-> new School("H" + i))
                .toArray(School[] ::new);
        schools[0].addCapacity(1);  schools[1].addCapacity(2);  schools[2].addCapacity(2);


        ////////////////OPTIONAL

        List<School> allSchools= new ArrayList<School>();
        List<Student> allStudents= new ArrayList<Student>();

        for(Student s : students)
            allStudents.add(s);
        for(School s: schools)
            allSchools.add(s);

        Collections.sort(allStudents);

        List<School> wantedSchools= Arrays.asList(schools[0], schools[1], schools[2]);
        List<Student> wantedStudents = Arrays.asList(students[2], students[1]);
        int m=0;

        Map<Student, List<School>> stdPrefMap = new TreeMap<>(new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2) {
                return (s2.grade-s1.grade);
            }
        });
        List <School> prefList = new ArrayList<>();
        prefList.add(schools[0]);prefList.add(schools[1]);prefList.add(schools[2]);
        stdPrefMap.put(students[0], prefList);

        stdPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        stdPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));

        for(Map.Entry<Student, List<School>> entry : stdPrefMap.entrySet()){
            System.out.println(entry.getKey() + "  H  " + entry.getValue());
        }
        List<Student> rez= allStudents.stream().filter(std -> stdPrefMap.get(std).contains(schools[2])).collect(Collectors.toList());

        System.out.println("Studentii care au ca preferinta liceul H2");
        for(int i=0; i < rez.size(); i++)
            System.out.println( rez.get(i).name);

        Map<School, List<Student>> prefSchool = new HashMap<>();
        Student stud= students[0];

        prefSchool.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        prefSchool.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        prefSchool.put(schools[2], Arrays.asList(students[0], students[1], students[3]));


        List<School> rez2= allSchools.stream().filter(std -> prefSchool.get(std).containsAll(Arrays.asList(students[3], students[2]))).collect(Collectors.toList());

        System.out.println("Scolile care au ca preferinte studentii s2 si s3");
        for(int i=0; i< rez2.size(); i++)
            System.out.println(rez2.get(i).name);

        Faker faker=new Faker();
        String s= faker.name().fullName();

        var students1= IntStream.rangeClosed(0,3)
                .mapToObj(i-> new Student( faker.name().fullName(), (int)(Math.random()*100000%11)))
                .toArray(Student[] ::new);

        Problem p1= new Problem(stdPrefMap);
        Solution s1= new Solution(p1);
        s1.solve();
    }
}

