import java.util.ArrayList;
import java.util.List;

public class Buffer {
    Users users= new Users();
    List<Messages> messages= new ArrayList<>();

    public String put(String request, String username){
        Commands commands= new Commands();

        List<String> parsedRequest=new ArrayList<>();
        parsedRequest=parseRequest(request);

        String option=parsedRequest.get(0);

        if(option.compareTo("login")==0 || option.compareTo("register")==0){
            username=parsedRequest.get(1);
        }
        System.out.println(parsedRequest);

        String message=null;
        List<String> friends=new ArrayList<>();

        if(option.compareTo("send")==0)
            message=parsedRequest.get(1);
        if(option.compareTo("friend")==0)
            for(int i=1; i<parsedRequest.size(); i++)
                friends.add(parsedRequest.get(i));
        System.out.println(friends);

        int ok=0;
        String response=null;
        System.out.println("Username: " + username);
            switch (option) {
                case "register":
                    commands.register(username, users);
                    response="Inregistrare cu succes";
                    break;
                case "login":
                    boolean check=commands.login(username, users);
                    if(check)
                        response="Login cu succes";
                    else
                        response="Nu exista username-ul";
                    break;
                case "friend":
                    commands.friend(friends, users, username);
                    response="Prietenie trimisa";
                    break;
                case "send":
                    commands.send(messages, username, message, users);
                    response="Mesaj transmis cu succes";
                    break;
                case "read":
                {
                    commands.read(messages, username, users);
                    System.out.println("aveti un mesaj nou: ");
                    System.out.println(commands.read(messages, username, users));
                    response=commands.read(messages, username, users).toString();
                    break;
                }
                case "exit":
                    ok=1;
                    response="Am iesit";
                    break;
        }
        return response;
    }

    String getResponse(){
        String response=null;
        return response;
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
