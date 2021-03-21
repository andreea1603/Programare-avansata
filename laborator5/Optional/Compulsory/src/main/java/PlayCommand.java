import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlayCommand implements Command{
    Catalog catalog;
    @Override
    public void execute(String ... params) throws IOException {
        for(String param: params){
            try {
                Desktop desktop = Desktop.getDesktop();
                File myFile = new File((catalog.findById(param).getLocation()));
                desktop.open(myFile);
            }catch(IOException ex){
                System.out.println(ex);
            }
        }
    }

    public PlayCommand(Catalog catalog) {
        this.catalog = catalog;
    }
}
