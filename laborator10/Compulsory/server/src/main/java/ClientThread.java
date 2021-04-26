import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null ;
    ServerSocket serverSocket;

    public ClientThread (Socket socket, ServerSocket serverSocket) { this.socket = socket ;  this.serverSocket=serverSocket;}
    public void run () {

        try {
            int ok=0;
            while(ok==0) {

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String raspuns=null;

                if(request.compareTo("stop")==0)
                {
                    raspuns="Server stopped";
                    out.println(raspuns);
                    out.flush();
                    serverSocket.close();
                    System.exit(0);
                }
                else
                    raspuns="Server received the request...";
                out.println(raspuns);
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}