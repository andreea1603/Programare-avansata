import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DirectorsDao {

    List<Director> director= new ArrayList<>();

       DirectorsDao(Statement stm, List<String> directors) throws SQLException {
          /* for(int i=0; i<directors.size(); i++) {
               try {
                   String state = "INSERT INTO directors values('" + directors.get(i) + "'," + i + ")";
                   director.add(new Director(i, directors.get(i)));
                   stm.executeUpdate(state);
               } catch (SQLException e) {
                  System.out.println( "Producatorul " + i + " nu a fost adaugat");
               }
           }

           */

    }

    @Override
    public String toString() {
        return "DirectorsDao{" +
                "director=" + director +
                '}';
    }
}
