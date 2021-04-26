import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketCreation {
    ServerSocket serverSocket = null ;
    public static final int PORT = 8100;

    SocketCreation() throws IOException {
        serverSocket = new ServerSocket(PORT);

    }
    void request() throws IOException {
        try {
            while (true) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket, serverSocket).start();
            }
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        } finally {
            if(!serverSocket.isClosed())
                serverSocket.close();
        }
    }
}
