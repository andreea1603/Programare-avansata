import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends Thread {
    String name;
    int turn;
    Buffer buffer;

    public Player(int turn, String name, Buffer buffer){
        this.name= name;
        this.turn= turn;
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
    }

}
