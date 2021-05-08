public class Friendship {
    String user1;
    String user2;

    public Friendship(String user1, String user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "user1='" + user1 + '\'' +
                ", user2='" + user2 + '\'' +
                '}';
    }
}
