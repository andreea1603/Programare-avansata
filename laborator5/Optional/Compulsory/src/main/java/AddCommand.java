import java.io.IOException;

public class AddCommand implements Command {
    Catalog catalog;
    @Override
    public void execute(String ... params) throws IOException{

        for(String param: params){
            catalog.add(new Song(param));
        }
        ///////DACA E SONG SAU NU
    }
}
