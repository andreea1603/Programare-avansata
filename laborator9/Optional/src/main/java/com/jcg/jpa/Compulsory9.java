package com.jcg.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class Compulsory9 extends  ApplicationFrame {

    public Compulsory9(String title) {
        super(title);
    }

    public static void main(String[] args) {


        Singleton s = Singleton.getInstance();

        RepositoryGenres repo = new RepositoryGenres();

        EntityManagerFactory entityManagerFactory= s.emFactoryObj;
        EntityManager entityMgr=entityManagerFactory.createEntityManager();
        int ok=0, option, id=890000, idGen=100;
        Scanner scan= new Scanner(System.in);
        while(ok==0){
            System.out.println("Alege optiunea potrivita: \n\t 1) Adauga un film \n\t 2)Adauga un gen");
            System.out.println("\t3)Cauta un gen dupa id \n\t4)Cauta un gen dupa nume\n\t5)Iesire");
            option=scan.nextInt();
            if(option==5){
                ok=1;
            }
            if(option==1){
                entityMgr.getTransaction().begin();
                Movies m = new Movies();
                System.out.println("Introduceti nume, durata ");
                Scanner scan2= new Scanner(System.in);
                String nume=scan2.nextLine();
                int durata= scan2.nextInt();
                m.setId(id+1);
                m.setName(nume);
                m.setDuration(durata);
                entityMgr.persist(m);
                entityMgr.getTransaction().commit();id++;
            }
            else
                if(option==2){
                    System.out.println("Introduceti numele genului");

                    Scanner scan2= new Scanner(System.in);
                    String nume=scan2.nextLine();
                    repo.create(idGen, nume, entityMgr);
                    idGen++;
                }
                else
                    if(option==3){
                        System.out.println("Introduceti id-ul filmului");
                        Scanner scan2= new Scanner(System.in);
                        int idF=scan2.nextInt();
                        Genres g1 = repo.findById(entityMgr, idF);
                        System.out.println(g1.getName());
                    }
                    else
                    if(option==4){
                        System.out.println("Introduceti numele genului");
                        Scanner scan2= new Scanner(System.in);
                        String nume=scan2.nextLine();
                        List<Genres> g2 = repo.findByName(entityMgr, nume);
                        for (int i = 0; i < g2.size(); i++)
                            System.out.println(g2.get(i).getId() + g2.get(i).getName());
                    }
                    else
                        if(option==5){
                            BarChart chart = new BarChart("Movie Time",
                                    "Statistics", entityMgr);
                            chart.pack();
                            RefineryUtilities.centerFrameOnScreen(chart);
                            chart.setVisible(true);

                            entityMgr.close();
                            entityManagerFactory.close();

                        }
        }


    }

}
