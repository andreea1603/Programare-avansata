import java.io.IOException;
import java.util.Scanner;

public class AddCommand implements Command {
    Catalog catalog;
    @Override
    public void execute(String ... params) throws IOException{

        System.out.println("Introduceti tipul itemului(book/song)");
        Scanner readCommand1 = new Scanner(System.in);
        String type = readCommand1.nextLine();
        System.out.println("Introduceti id-ul itemului");
        String id = readCommand1.nextLine();
        System.out.println("Introduceti numele itemului");
        String name = readCommand1.nextLine();
        System.out.println("Introduceti path-ul itemului");
        String path = readCommand1.nextLine();
        if (type.contains("book")) {
            Book b1 = new Book(name, id);
            b1.setLocation(path);
            catalog.add(b1);
        }
        if (type.contains("song")) {
            Song s1 = new Song(name, id);
            s1.setLocation(path);
            catalog.add(s1);
        }
    }

    public AddCommand(Catalog catalog) {
        this.catalog = catalog;
    }
}
