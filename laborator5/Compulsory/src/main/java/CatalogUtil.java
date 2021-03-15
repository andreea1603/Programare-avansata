import java.awt.*;
import java.io.*;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        try( var oos= new ObjectOutputStream(
                new FileOutputStream(catalog.getPath())))
        {
            oos.writeObject(catalog);
        }
        catch (Exception e){
            System.out.println("eroare"+ e);
        }
    }
    public static Catalog load(String path) throws InvalidCatalogException, IOException, ClassNotFoundException {
        FileInputStream fis= new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fis);
        Catalog catalog=(Catalog)in.readObject();
        return catalog;

    }
    public static void view(Item item){
        try {
            Desktop desktop = Desktop.getDesktop();
            File myFile = new File("C:\\Users\\andre\\OneDrive\\Desktop\\Compulsory\\salu");
            desktop.open(myFile);
        }catch(IOException ex){
            System.out.println(ex);
        }

    }
}
