import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenresDao {
    List<Genre> genre= new ArrayList<>();

    public void insertGenres(Connection conn, int id, String name) throws SQLException {
        Statement stm= conn.createStatement();
        String sql;
        this.genre.add(new Genre(id, name));
        sql="INSERT INTO genres values( " + id + ", '" + name+"')";
        stm.executeUpdate(sql);
    }

    Genre findGenre(int id, Connection conn) throws SQLException {
        Statement stm= conn.createStatement();
        String sql="SELECT * FROM genres where id=" + id;
        ResultSet res=stm.executeQuery(sql);
        int cod=0; String nume="";
        while (res.next()) {
            cod=res.getInt("id");
            nume= res.getString("name");
            System.out.println(nume + " " + cod);
        }
        return (new Genre(cod, nume));
    }

    GenresDao(Statement stm, List<String> genres) throws SQLException {

       /* for(int i=0; i<genres.size(); i++) {

            String state = "INSERT INTO genres values(" + i + ",'" + genres.get(i) + "')";
            stm.executeUpdate(state);
            genre.add(new Genre(i, genres.get(i)));
        }

        */


    }
}
