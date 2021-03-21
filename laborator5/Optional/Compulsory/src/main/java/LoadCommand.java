import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand implements Command{
    Catalog catalog;
    @Override
    public void execute(String ... params) throws IOException, ClassNotFoundException {
        for(String param: params ){
            FileInputStream fis= new FileInputStream(param);
            ObjectInputStream in = new ObjectInputStream(fis);
            Catalog catalog=(Catalog)in.readObject();
            this.catalog= catalog;
        }
    }

    public Catalog getCatalog() {
        return catalog;
    }
}
