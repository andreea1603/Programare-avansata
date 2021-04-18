import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    List<Director> director= new ArrayList<>();
    List<Actor> actor= new ArrayList<>();
    List<Genre> genre= new ArrayList<>();
    List<Movie> movie= new ArrayList<>();

    public void insertMovie(Connection conn, int id, String titlu, int duration, int score) throws SQLException {
        Statement stm= conn.createStatement();
        String sql;
        sql="INSERT INTO movies values (" + id+", '"+ titlu +"', '2015-12-13',"+ duration +"," + score +")";
        //System.out.println(sql);
        stm.executeUpdate(sql);
    }
    public void insertGenres(Connection conn, int id, String name) throws SQLException {
        Statement stm= conn.createStatement();
        String sql;
        sql="INSERT INTO genres values( " + id + ", '" + name+"')";
        stm.executeUpdate(sql);
    }
    public void findMovie(int id, Connection conn) throws SQLException {
        Statement stm= conn.createStatement();
        System.out.println("REZULTATUL CAUTARII ESTE: ");

        String sql="SELECT * FROM movies where id=" + id;
        ResultSet res=stm.executeQuery(sql);
        while (res.next()) {
            int cod=res.getInt("id");
            String nume= res.getString("title");
            System.out.println(nume);
        }
    }
    public void findGenre(int id, Connection conn) throws SQLException {
        Statement stm= conn.createStatement();
        String sql="SELECT * FROM genres where id=" + id;
        ResultSet res=stm.executeQuery(sql);
        System.out.println("REZULTATUL CAUTARII ESTE: ");
        while (res.next()) {
            int cod=res.getInt("id");
            String nume= res.getString("name");
            System.out.println(nume + " " + cod);
        }
    }

    void InsertGenreInit(Statement stm, int id, String title) throws SQLException {

        String state="INSERT INTO genres values("+ id + ",'" + title +  "')" ;
        stm.executeUpdate(state);
        genre.add(new Genre(id, title));
    }
    void InsertActorsInit(Statement stm, int id, String name) throws SQLException {

        String state="INSERT INTO actors values('"+ name + "'," + id +  ")" ;
        //System.out.println(state);
        actor.add(new Actor(name, id));
        stm.executeUpdate(state);
    }
    void InsertMoviesInit(Statement stm, int id, String title, int score, int duration) throws SQLException {

        try {
           // System.out.println(duration + " s " + score + " s " + title);
            String state = "INSERT INTO movies values(" + id + ",'" + title + "'," + " '2017/12/13' , " + duration + ", " + score + ")";
          //  System.out.println(state);
            movie.add(new Movie(id, duration, score, title));
            stm.executeUpdate(state);
        }
        catch (SQLException e){
            System.out.println(id + " nu a fost adaugat");
        }
    }

    void InsertDirectorsInit(Statement stm, int id, String name) throws SQLException {
        try {
            String state = "INSERT INTO directors values('" +name + "'," +  id + ")";
            director.add(new Director(id, name));
            //System.out.println(state);
            stm.executeUpdate(state);
        }
        catch (SQLException e){
            System.out.println(id + " nu a fost adaugat");
        }
    }
}
