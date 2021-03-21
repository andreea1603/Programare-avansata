import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand implements Command{
    Catalog catalog;
    @Override
    public void execute(String ... params) throws IOException {
            try( var oos= new ObjectOutputStream(
                    new FileOutputStream(catalog.getPath())))
            {
                oos.writeObject(catalog);
            }
            catch (Exception e){
                System.out.println("eroare"+ e);
            }
    }

    public SaveCommand(Catalog catalog) {
        this.catalog = catalog;
    }
    public SaveCommand() {
    }

}
