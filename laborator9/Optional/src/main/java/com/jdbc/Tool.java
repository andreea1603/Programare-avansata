package com.jdbc;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tool {

    List<String> genres=new ArrayList<>();
    List<String> movies= new ArrayList<>();
    List<Integer> duration= new ArrayList<>();
    List<Integer> score= new ArrayList<>();
    List<String> actors=new ArrayList<>();
    List<String> directors=new ArrayList<>();


    List<String> getComposedGenres(){
        List<String> allGenres=new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\andre\\OneDrive\\Desktop\\pa\\Programare-avansata\\laborator8\\Optional\\Compulsory8\\src\\main\\java\\IMDbMovies.csv"))) {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                allGenres.add(lineInArray[5]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allGenres;
    }
    void addDifferentGenres(){
        List<String> compuseGenres=new ArrayList<>();
        compuseGenres=getComposedGenres();

        for(int i=0; i<compuseGenres.size(); i++){
            String arr[]= compuseGenres.get(i).split(",");
            for(int j=0;j<arr.length; j++)
            {
               // System.out.println(arr[j]);
                if(this.genres.contains(arr[j])==false){
                    this.genres.add(arr[j]);
                }
            }
        }
    }
    void putMovies(){
        List<String> allMovies=new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\andre\\OneDrive\\Desktop\\pa\\Programare-avansata\\laborator8\\Optional\\Compulsory8\\src\\main\\java\\IMDbMovies.csv"))) {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                this.movies.add(lineInArray[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void putDuration(){
        int k=0;
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\andre\\OneDrive\\Desktop\\pa\\Programare-avansata\\laborator8\\Optional\\Compulsory8\\src\\main\\java\\IMDbMovies.csv"))) {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                if(k!=0)
                    this.duration.add(Integer.parseInt(lineInArray[6]));
                k++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void putScore(){
        int k=0;
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\andre\\OneDrive\\Desktop\\pa\\Programare-avansata\\laborator8\\Optional\\Compulsory8\\src\\main\\java\\IMDbMovies.csv"))) {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                if(k!=0)
                    this.score.add((int)(Float.parseFloat(lineInArray[14])));
                k++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<String> getComposedActors(){
        List<String> allActors=new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\andre\\OneDrive\\Desktop\\pa\\Programare-avansata\\laborator8\\Optional\\Compulsory8\\src\\main\\java\\IMDbMovies.csv"))) {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                allActors.add(lineInArray[12]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allActors;
    }
    void addDifferentActors(){

        List<String> compuseActors=new ArrayList<>();
        compuseActors=getComposedActors();

        for(int i=0; i<15000; i++){
            String arr[]= compuseActors.get(i).split(",");
            for(int j=0;j<arr.length; j++)
            {
                if(this.actors.contains(arr[j])==false)
                    this.actors.add(arr[j]);
            }
        }
    }

    void addDifferentDirectors(){
        List<String> compuseDirectors=new ArrayList<>();
        compuseDirectors=getCompusedDirectors();

        for(int i=0; i<15000; i++){
            String arr[]= compuseDirectors.get(i).split(",");
            for(int j=0;j<arr.length; j++)
            {
                if(this.directors.contains(arr[j])==false){
                    this.directors.add(arr[j]);
                }
            }
        }
    }
    List<String> getCompusedDirectors(){
        List<String> allDirectors=new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\andre\\OneDrive\\Desktop\\pa\\Programare-avansata\\laborator8\\Optional\\Compulsory8\\src\\main\\java\\IMDbMovies.csv"))) {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                allDirectors.add(lineInArray[9]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allDirectors;
    }
}
