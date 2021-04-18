import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Compulsory {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        String diver="com.sql.jdbc.Driver";
        Singleton s= Singleton.getInstance();
        Connection conn= s.conn;

        Statement stm= conn.createStatement();

        String sql="CREATE TABLE IF NOT EXISTS movies (id INTEGER, title VARCHAR(200), release_date DATE, duration INTEGER, score INTEGER)";

        stm.executeUpdate(sql);
        sql="CREATE TABLE IF NOT EXISTS genres (id INTEGER, name VARCHAR(200))";
        stm.executeUpdate(sql);
        sql="CREATE TABLE IF NOT EXISTS assoc (id_movie INTEGER, id_gen INTEGER)";
        stm.executeUpdate(sql);

       // String state="INSERT INTO movies values(2, 'valoaer', '2015-12-13', 14, 18)";
       // stm.executeUpdate(state);

        String query="SELECT * from genres";
        ResultSet res=stm.executeQuery(query);
        //System.out.println(res.getMetaData());
     //   System.out.println("Afisez rezultatul genurilor:");

        while (res.next()) {
            int cod=res.getInt("id");
            String nume= res.getString("name");
      //      System.out.println(nume + cod);
        }
        Dao sts= new Dao();
        //CREARE DE TABELE
        sql="CREATE TABLE IF NOT EXISTS actors (name VARCHAR(200), id INTEGER)";
        stm.executeUpdate(sql);
        sql="CREATE TABLE IF NOT EXISTS directors (name VARCHAR(200), id INTEGER)";
        stm.executeUpdate(sql);

        /// IMPORT DATA

        Tool t=new Tool();

        t.addDifferentGenres();
        t.putMovies();
        t.putDuration();
        t.putScore();
        /*
        System.out.println("Genurile sunt:");
        for(int i=0; i<t.genres.size();  i++)
        {
            System.out.println(t.genres.get(i));
            //Inserarea genurilor
           // sts.InsertGenreInit(stm,i,t.genres.get(i));
        }

        System.out.println("Actorii sunt:");
        t.addDifferentActors();
        */

         System.out.println("Am inserat genurile");
        //Inserare actori
        /*
        for(int i=1; i<t.actors.size()-100;  i++)
        {
            System.out.println(t.actors.get(i));
          //  sts.InsertActorsInit(stm, i, t.actors.get(i));
        }
        */
        System.out.println("Am inserat actorii");

        /*
        for(int i=1; i<t.duration.size()-100;  i++)
        {
            //System.out.println(t.actors.get(i));
              sts.InsertMoviesInit(stm, i, t.movies.get(i),t.duration.get(i), t.score.get(i));
        }
        System.out.println("Am adaugat filmele");
         */

        /*
        t.addDifferentDirectors();
        System.out.println(t.directors.size());
        for(int i=11175; i<t.directors.size();  i++)
        {
              sts.InsertDirectorsInit(stm, i, t.directors.get(i));
        }

         */
        int ok=0, m=0;

        Scanner scan= new Scanner(System.in);
        while(ok==0){
            System.out.println("Alege optiunea potrivita: \n\t 1) Adauga un film \n\t 2)Adauga un gen");
            System.out.println("\t3)Cauta un film \n\t4)Cauta un gen\n\t5)Iesire");


            m=scan.nextInt();

            if(m==5)
                ok=1;
            else
                if(m==1){
                    System.out.println("Introduceti nume, durata si scor");
                    Scanner scan2= new Scanner(System.in);
                    String nume=scan2.nextLine();
                    int durata= scan2.nextInt();
                    int scor=scan2.nextInt();
                    sts.insertMovie(conn,t.movies.size()+1, nume, durata, scor);
                }
                else
                    if(m==2){
                        System.out.println("Introduceti numele genului");
                        Scanner scan2= new Scanner(System.in);
                        String nume=scan2.nextLine();
                        sts.insertGenres(conn, t.genres.size(), nume);

                    }
                    else
                        if(m==3){
                            System.out.println("Introduceti id-ul filmului");
                            Scanner scan2= new Scanner(System.in);
                            int id=scan2.nextInt();
                            sts.findMovie(id, conn);
                        }
                        else
                            if(m==4){
                                System.out.println("Introduceti id-ul genului");
                                Scanner scan2= new Scanner(System.in);
                                int id=scan2.nextInt();
                                sts.findGenre(id, conn);
                            }
        }

    }

}

