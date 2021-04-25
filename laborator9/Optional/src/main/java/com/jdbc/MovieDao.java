package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovieDao implements Dao {
    List<Movie> movie= new ArrayList<>();

    public void insert(Connection conn, int id, String titlu) throws SQLException {
        Statement stm= conn.createStatement();
        String sql;
        int duration=80; int score=10;
        this.movie.add(new Movie(id, duration, score, titlu));
        sql="INSERT INTO movies values (" + id+", '"+ titlu +"', '2015-12-13',"+ duration +"," + score +")";
        stm.executeUpdate(sql);
    }
    public Movie findById(int id, Connection conn) throws SQLException {
        Statement stm= conn.createStatement();

        int duration=0, score=0, cod=0;
        String nume="";

        String sql="SELECT * FROM movies where id=" + id;
        ResultSet res=stm.executeQuery(sql);
        while (res.next()) {
             cod=res.getInt("id");
             nume= res.getString("title");
             duration=res.getInt("duration");
             score=res.getInt("score");
        }
        return (new Movie(id,duration, score, nume));
    }
     MovieDao(Statement stm, List<String> movie, List<Integer> duration, List<Integer> score) throws SQLException {

        /* for (int i = 0; i < movie.size(); i++) {
             try {
                 String state = "INSERT INTO movies values(" + i + ",'" + movie.get(i) + "'," + " '2017/12/13' , " + duration.get(i) + ", " + score.get(i) + ")";
                 this.movie.add(new Movie(i, duration.get(i), score.get(i), movie.get(i)));
                 stm.executeUpdate(state);
             } catch (SQLException e) {
                 System.out.println( "Filmul" + i + " nu a fost adaugat");
             }
         }
         */
     }
}
