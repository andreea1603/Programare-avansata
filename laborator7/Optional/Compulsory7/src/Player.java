import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends Thread {
    String name;
    int turn;
    Buffer buffer;
    List<Pair> tokenForEachPlayer= new ArrayList<>();
    int strategy; //0 pentru automated, 1 pentru random

    public Player(int turn, String name, Buffer buffer, int strategy){
        this.name= name;
        this.turn= turn;
        this.buffer= buffer;
        this.strategy= strategy;
    }

    synchronized public void run(){
        while(buffer.tokens.size()>0){
            buffer.put(this.turn, this.strategy);
            if(this.buffer.tokens.size()>0)
            {
                try{
                    sleep((int)(Math.random()*100));
                }
                catch (InterruptedException e){}
                }
            }
    }
    void setTokenForEachPlayer(){
        int size=0;
        for(Map.Entry i: buffer.asignedTokens.entrySet()){
            if((int)i.getValue()==this.turn){
                tokenForEachPlayer.add(size,(Pair)i.getKey());
                size++;
            }
        }
    }
    void afis(){
        System.out.println("Tokenii pentru utilizatorul : " + turn);
        for(int i=0; i < tokenForEachPlayer.size(); i++)
        {
            System.out.println("\t"+tokenForEachPlayer.get(i));
        }
    }


}
