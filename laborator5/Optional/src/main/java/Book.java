public class Book extends Item{
    int releaseYear;
    String author;

    public Book(int releaseYear, String author) {
        try {
            this.author = author;
            if (releaseYear > 2021 || releaseYear < 0) {
                throw new ExceptionYear("wrong year");
            } else
                this.releaseYear = releaseYear;

        } catch (ExceptionYear ex) {
            System.out.println(ex);
        }
    }
    public Book(String name, String id) {
        this.setId(id);
        this.setName(name);
    }
}
