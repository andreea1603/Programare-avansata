package com.MainApp;

import com.jcg.jpa.Compulsory9;
import com.jdbc.Compulsory;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, TemplateException {

        File config= new File("Config.txt");
        Scanner choose= new Scanner(config);
        String option=choose.nextLine();
        if(option.compareTo("JPA")==0){
            Compulsory9.main(null);
        }
        else{
            Compulsory.main(null);

        }

    }
}
