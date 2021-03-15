public class Song extends Item{
    String album;
    int year;

    public Song(String album, int year) {
        this.album = album;
        try {
            this.album = album;
            if (year > 2021 || year < 0) {
                throw new ExceptionYear("wrong year");
            } else
                this.year = year;

        } catch (ExceptionYear ex) {
            System.out.println(ex);
        }
    }
}
