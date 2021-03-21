import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ListCommand implements Command{
    Catalog catalog;

    @Override
    public void execute(String ... params) throws IOException{
        System.out.println(catalog.toString());
    }

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }
}
