import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Users {
    List<String> names=new ArrayList<>();
    List<Friendship> friendships= new ArrayList<>();

    @Override
    public String toString() {
        return "Users{" +
                "names=" + names +
                ", friendships=" + friendships +
                '}';
    }
}
