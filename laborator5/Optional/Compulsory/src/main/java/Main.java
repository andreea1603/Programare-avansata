import freemarker.template.TemplateException;

import java.awt.*;
import java.io.*;
import java.util.Scanner;
////load ul
public class Main {

    public static void main(String[] args) throws IOException, InvalidCatalogException, ClassNotFoundException, TemplateException {
        Main app= new Main();
        int check=0;
        //app.testCreateSave();
        //app.testLoadView();
        System.out.println("Introduceti comanda:");
        Catalog c1= new Catalog("PrimulCatalog", "C:\\Users\\andre\\OneDrive\\Desktop\\Compulsory\\salu");
        try{
        while(true) {
            check = 0;
            Scanner readCommand = new Scanner(System.in);
            String command = readCommand.nextLine();
            System.out.println("Am citit: " + command);
            switch (command) {
                case "report":{
                    ReportCommand report1 = new ReportCommand();
                    report1.execute();
                    Desktop desktop = Desktop.getDesktop();
                    File myFile = new File("C:\\Users\\andre\\OneDrive\\Desktop\\Compulsory\\output.html");
                    desktop.open(myFile);
                    break;
                }
                case "list" : {
                    ListCommand list = new ListCommand(c1);
                    list.execute();
                    break;
                }
                case "save" :{
                    SaveCommand save = new SaveCommand(c1);
                    save.execute("");
                    break;
                }
                case "load": {
                    System.out.println("Introduceti path-ul catalogului");
                    Scanner read1 = new Scanner(System.in);
                    String path = read1.nextLine();
                    LoadCommand load = new LoadCommand();
                    load.execute(path);
                    c1 = load.getCatalog();
                    break;
                }
                case "play" : {
                    System.out.println("Introduceti id-ul itemului dorit:");
                    Scanner read1 = new Scanner(System.in);
                    String itemId = read1.nextLine();
                    PlayCommand play = new PlayCommand(c1);
                    play.execute(itemId);
                    break;
                }
                case "add" : {
                    AddCommand add= new AddCommand(c1);
                    add.execute();
                    break;
                }
                default: {
                    throw new ExceptionCommand("Command not found");
                }
            }
                System.out.println("Introduceti comanda:");
            }

        }catch(ExceptionCommand ex){
            System.out.println(ex);
        }
    }
    private void testCreateSave() throws IOException, InvalidCatalogException, ClassNotFoundException {
        Catalog catalog= new Catalog("MyBooks","C:\\Users\\andre\\OneDrive\\Desktop\\Compulsory\\salu");
        var song= new Song("Album nr 1", 1998);
        var book= new Book(1870, "Mihai Eminescu");
        catalog.add(song); song.setId("123");
        catalog.add(book);  book.setId("232");  song.setLocation("C:\\Users\\andre\\OneDrive\\Desktop\\Compulsory\\Alarm.mp3");
        CatalogUtil.save(catalog);
        System.out.println(CatalogUtil.load("C:\\Users\\andre\\OneDrive\\Desktop\\Compulsory\\salu"));
    }
    private void testLoadView() throws InvalidCatalogException, IOException, ClassNotFoundException {
        Catalog catalog= CatalogUtil.load("C:\\Users\\andre\\OneDrive\\Desktop\\Compulsory\\salu");
        System.out.println("Afisez catalogul: " + catalog.toString());
        System.out.println(catalog.findById("123"));
        CatalogUtil.view(catalog.findById("123"));
    }
}
