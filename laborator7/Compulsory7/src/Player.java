import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends Thread {
    String name;
    int turn;
    List<Pair> tokens= new ArrayList<>();
    Buffer buffer;
    Map<Pair, Integer> asignedTokens= new HashMap<>();

    public Player(int turn, String name, List<Pair> tokens, Buffer buffer){
        this.name= name;
        this.turn= turn;
        this.tokens= tokens;
        this.buffer= buffer;
    }
    synchronized public void run(){
        while(buffer.tokens.size()>0){

            buffer.put(this.turn);
            if(this.buffer.tokens.size()>0)
            {
                try{
                    sleep((int)(Math.random()*100));
                }
                catch (InterruptedException e){}
                }
            }
        if(buffer.tokens.size()==0){
            for(int i=0; i<tokens.size(); i++)
            {
                    asignedTokens.put(tokens.get(i), buffer.asignedTokens.get(tokens.get(i)));
            }
        }
    }

}
