import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException, ClassNotFoundException {
        Main app= new Main();
        app.testCreateSave();
        app.testLoadView();
    }
    private void testCreateSave() throws IOException, InvalidCatalogException, ClassNotFoundException {
        Catalog catalog= new Catalog("MyBooks","C:\\Users\\andre\\OneDrive\\Desktop\\Compulsory\\salu");
        var song= new Song("Album nr 1", 1998);
        var book= new Book(1870, "Mihai Eminescu");
        catalog.add(song); song.setId("123");
        catalog.add(book);  book.setId("232");
        CatalogUtil.save(catalog);
        System.out.println(CatalogUtil.load("C:\\Users\\andre\\OneDrive\\Desktop\\Compulsory\\salu"));
    }
    private void testLoadView() throws InvalidCatalogException, IOException, ClassNotFoundException {
        Catalog catalog= CatalogUtil.load("C:\\Users\\andre\\OneDrive\\Desktop\\Compulsory\\salu");
        Song song= new Song("album", 1823);
        song.setId("123");
        CatalogUtil.view(catalog.findById("123"));
    }
}
