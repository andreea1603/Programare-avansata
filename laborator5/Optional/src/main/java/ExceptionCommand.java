public class ExceptionCommand extends Exception{
    String message;
    ExceptionCommand(String message){
        this.message=message;
    }

    @Override
    public String toString() {
        return "Exception Command: {" +
                "Error messsage='" + message + '\'' +
                '}';
    }
}
