public class ExceptionYear extends Exception{
    String messsage;
    ExceptionYear(String message){
        this.messsage=message;
    }

    @Override
    public String toString() {
        return "ExceptionYear{" +
                "Error messsage='" + messsage + '\'' +
                '}';
    }
}
