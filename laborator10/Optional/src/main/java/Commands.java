import java.util.ArrayList;
import java.util.List;

public class Commands {

    boolean login(String username, Users users){
        for(int i=0; i<users.names.size(); i++)
            if(users.names.get(i).compareTo(username)==0)
                return true;
        return false;
    }
    void register(String username, Users users){
        users.names.add(username);
    }
    void friend(List<String> friends, Users users, String username){
        for(int i=0; i<friends.size(); i++){
            users.friendships.add(new Friendship(friends.get(i), username));
        }
    }
    void send(List<Messages> messages, String username, String message, Users users){
        Messages m1= new Messages(username, message);
        messages.add(m1);
    }
    List<String> read(List<Messages> messages, String username, Users users){
        System.out.println();
        List<String> myMessages=new ArrayList<>();
        List<String> myfriends= getFriends(username, users.friendships);
        for(int i=0; i<messages.size(); i++){
            for(int j=0; j<myfriends.size(); j++)
            if(messages.get(i).user.compareTo(myfriends.get(j))==0){
                    myMessages.add(messages.get(i).message);
            }
        }
        //System.out.println(myfriends);
        if(myMessages.size()==0)
            myMessages.add("no messages");
        return myMessages;
    }
    List<String> getFriends(String username, List<Friendship> friends){
        List<String> myFriends=new ArrayList<>();
        for(int i=0; i<friends.size();i++) {
            if (friends.get(i).user1.compareTo(username)==0) {
                myFriends.add(friends.get(i).user2);
            }
            if(friends.get(i).user2.compareTo(username)==0){
                myFriends.add(friends.get(i).user1);
            }
        }
        return myFriends;
    }

}
