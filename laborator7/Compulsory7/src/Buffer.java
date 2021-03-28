import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buffer {
    private int number=-1;
    private  boolean available= false;
    private int turn =1;
    private int maximum_Player=4;
    List<Pair> tokens= new ArrayList<>();

    Map<Pair, Integer> asignedTokens= new HashMap<>();


    public void setTokens(List<Pair> tokens)
    {
        this.tokens= tokens;
    }
    public synchronized int get () {

        while(!available){
            try
            {
                wait();
            }
            catch (InterruptedException e) {}
        }
        available=false;
        notifyAll () ;
        return number ;
    }
    public void setMaximumPlayer(int x)
    {
        this.maximum_Player= x;
    }
    public synchronized void put (int number ) {


        while(number != this.turn ){
            try {
                wait () ;
            } catch ( InterruptedException e ) {
                e . printStackTrace () ;
            }
        }
        if(tokens.size()>0)
        {
            this.asignedTokens.put(tokens.get(0),turn);
            tokens.remove(0);
        }
        if(maximum_Player==number)
            this.turn= 1;
        else
            this.turn=number+1;
        available= true;
        notifyAll();
    }
    void getPairs(){
        System.out.println(asignedTokens);
    }

}
