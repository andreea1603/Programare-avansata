public class Messages {
    String user;
    String message;
    public Messages(String user, String message) {
        this.user = user;
        this.message = message;
    }
    public Messages(){

    }

    @Override
    public String toString() {
        return "Messages{" +
                "user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
