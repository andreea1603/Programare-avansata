import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    Problem p;
    Map<Student, School> matching= new HashMap<>();

    public Solution(Problem p) {
        this.p = p;
    }
    public void solve(){

        for(Map.Entry<Student, List<School>> entry : this.p.StudPrefMap.entrySet()){
            System.out.println("Preferences " + entry.getKey() );

            for(int i=0; i < entry.getValue().size(); i++)
            {
                System.out.println( entry.getValue().get(i).name + "\tCapacity: " +  entry.getValue().get(i).capacity);
                if(entry.getValue().get(i).capacity>0){
                    matching.put(entry.getKey(), entry.getValue().get(i));
                    entry.getValue().get(i).capacity--;
                    i=entry.getValue().size();
                }
            }
        }
        for(Map.Entry<Student,School> entry : this.matching.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        }

        }

    }


