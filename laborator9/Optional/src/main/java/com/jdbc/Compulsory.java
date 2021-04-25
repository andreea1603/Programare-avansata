package com.jdbc;

import com.jcg.jpa.Singleton;
import com.opencsv.CSVReader;
import freemarker.template.TemplateException;
import org.apache.commons.collections.ArrayStack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;


public class Compulsory {
    public static void main(String[] args) throws SQLException, IOException, TemplateException {
        String diver="com.sql.jdbc.Driver";
        SingletonB s= SingletonB.getInstance();
        Connection conn= s.conn;
        HashMap<String, String> search =new HashMap<>();

        Statement stm= conn.createStatement();

        String sql="CREATE TABLE IF NOT EXISTS movies (id INTEGER, title VARCHAR(200), release_date DATE, duration INTEGER, score INTEGER)";

        //creare tabele

        stm.executeUpdate(sql);
        sql="CREATE TABLE IF NOT EXISTS genres (id INTEGER, name VARCHAR(200))";
        stm.executeUpdate(sql);
        sql="CREATE TABLE IF NOT EXISTS assoc (id_movie INTEGER, id_gen INTEGER)";
        stm.executeUpdate(sql);
        sql="CREATE TABLE IF NOT EXISTS actors (name VARCHAR(200), id INTEGER)";
        stm.executeUpdate(sql);
        sql="CREATE TABLE IF NOT EXISTS directors (name VARCHAR(200), id INTEGER)";
        stm.executeUpdate(sql);

        /// import data from csv
        Tool t=new Tool();
      //  t.addDifferentGenres();
      //  t.putMovies();
     //   t.putDuration();
     //   t.putScore();
     //   t.addDifferentDirectors();
     //   t.addDifferentActors();

        //generare date initiale
        MovieDao movieDao=new MovieDao(stm, t.movies, t.duration, t.score);
        GenresDao genresDao=new GenresDao(stm, t.genres);
        ActorsDao actorsDao= new ActorsDao(stm, t.actors);
        DirectorsDao directorsDao= new DirectorsDao(stm, t.directors);
        System.out.println("actors+ directors : " + t.actors.size() + " " + t.directors.size());

        //meniu
        int ok=0, option=0;
        Scanner scan= new Scanner(System.in);
        while(ok==0){
            System.out.println("Alege optiunea potrivita: \n\t 1) Adauga un film \n\t 2)Adauga un gen");
            System.out.println("\t3)Cauta un film \n\t4)Cauta un gen\n\t5)Iesire");
            option=scan.nextInt();

            if(option==5)
                ok=1;
            else
                if(option==1){
                    System.out.println("Introduceti nume, durata si scor");
                    Scanner scan2= new Scanner(System.in);
                    String nume=scan2.nextLine();
                    int durata= scan2.nextInt();
                    int scor=scan2.nextInt();
                    movieDao.insert(conn,t.movies.size()+1, nume);
                    search.put("Inserare film", nume);
                }
                else
                    if(option==2){
                        System.out.println("Introduceti numele genului");
                        Scanner scan2= new Scanner(System.in);
                        String nume=scan2.nextLine();
                        genresDao.insert(conn, t.genres.size(), nume);
                        search.put("Inserare gen" , nume);
                    }
                    else
                        if(option==3){
                            System.out.println("Introduceti id-ul filmului");
                            Scanner scan2= new Scanner(System.in);
                            int id=scan2.nextInt();
                            Movie result=movieDao.findById(id, conn);
                            System.out.println(result);
                            search.put("Cautare film", result.title );
                        }
                        else
                            if(option==4){
                                System.out.println("Introduceti id-ul genului");
                                Scanner scan2= new Scanner(System.in);
                                int id=scan2.nextInt();
                                Genre result=genresDao.findById(id, conn);
                                System.out.println(result);
                                search.put("Cautare gen", result.name);
                            }
        }

    }
}

