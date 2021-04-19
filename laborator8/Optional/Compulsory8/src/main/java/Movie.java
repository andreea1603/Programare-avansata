public class Movie {
    int id, duration, score;
    String title;

    public Movie(int id, int duration, int score, String title) {
        this.id = id;
        this.duration = duration;
        this.score = score;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", duration=" + duration +
                ", score=" + score +
                ", title='" + title + '\'' +
                '}';
    }
}
