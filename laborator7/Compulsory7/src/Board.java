import java.util.ArrayList;
import java.util.List;

public class Board {
    int numberofTokens;
    List<Pair> pair=new ArrayList<>();

    public Board(int n)
    {
        int ok=1;
        for(int i=0; i<n; i++) {
            ok=1;
            int first, second, value;
            first = (int) (Math.random() * 100000) % n + 1;
            second = (int) (Math.random() * 100000) % n + 1;
            value = (int) (Math.random() * 100000) % n + 1;
            if (second == first)
            {
                i--;    ok=0;
            }
            else {
                for (int j = 0; j < pair.size(); j++) {
                    if (pair.get(j).first == first && pair.get(j).second == second) {
                        i--;
                        ok=0;
                    }
                }
            }
            if(ok==1)
                pair.add(new Pair(first, second, value));
        }

    }
}
