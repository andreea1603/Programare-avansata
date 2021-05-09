import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class ClientThread extends Thread {
    private Socket socket = null ;
    ServerSocket serverSocket;
    Buffer buffer;
    String username;


    public ClientThread (Socket socket, ServerSocket serverSocket, Buffer buffer)
    { this.socket = socket ;  this.serverSocket=serverSocket;
    this.buffer=buffer;}
    public void run () {

        try {
            int ok=0;
            while(ok==0) {

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String raspuns=null;

                ////aici incep comenzile
                ////////////////////////////////////////////////////////////

                List<String> commands=parseRequest(request);


                if(commands.get(0).compareTo("login")==0){
                    username=commands.get(1);
                }

                if(commands.get(0).compareTo("exit")==0){
                    raspuns="Server stopped";
                    out.println(raspuns);
                    out.flush();

                    ok=1;
                }
                //System.out.println(buffer.users);
                //System.out.println(buffer.messages);
                raspuns=buffer.put(request, username);

                if(request.compareTo("stop")==0)
                {
                    raspuns="Server stopped";
                    out.println(raspuns);
                    out.flush();
                    serverSocket.close();
                    ok=1;
                }
                else {
                    out.println(raspuns);
                    out.flush();
                }

            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
    public List<String> parseRequest(String request){
        List<String> commands=new ArrayList<>();

        String s="";

        for(int i=0; i< request.length(); i++){
            if(request.charAt(i)!=' '){

                s= s + request.charAt(i);

            }
            else{
                commands.add(s);
                s="";
            }
        }
        commands.add(s);

        return commands;
    }
}