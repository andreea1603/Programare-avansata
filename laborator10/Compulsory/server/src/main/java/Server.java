import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws IOException {
        SocketCreation socketCreation=new SocketCreation();
        ServerSocket serverSocket=socketCreation.serverSocket;
        socketCreation.request();
    }
    public static void main ( String [] args ) throws IOException {
        Server server = new Server ();
    }

}
