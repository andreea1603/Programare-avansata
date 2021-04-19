import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ActorsDao {
    List<Actor> actor= new ArrayList<>();

     ActorsDao(Statement stm, List<String> actors) throws SQLException {

      /*   String state="";
         try {
             for (int i = 0; i < actors.size(); i++) {
                 state = "INSERT INTO actors values('" + actors.get(i) + "'," + i + ")";
                 actor.add(new Actor(actors.get(i), i));
                 stm.executeUpdate(state);
             }
         }
         catch (SQLException e){
             System.out.println("Nu s-a adaugat " + state);
         }

       */

    }



    @Override
    public String toString() {
        return "ActorsDao{" +
                "actor=" + actor +
                '}';
    }
}
