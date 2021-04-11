import java.util.*;

public class Buffer {
    private int number=-1;
    private  boolean available= false;
    private int turn =1;
    private int maximum_Player=4;
    List<Pair> tokens= new ArrayList<>(); //toti tokenii disponibili
    Map<Pair, Integer> asignedTokens= new HashMap<>();//tokenii asignati unui jucator


    public void setTokens(List<Pair> tokens)
    {
        this.tokens= tokens;
    }
    public void setMaximum_Player(int max){ this.maximum_Player= max; }
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
    public synchronized void put (int number, int strategy ) {


        while(number != this.turn ){
            try {
                wait () ;
            } catch ( InterruptedException e ) {
                e . printStackTrace () ;
            }
        }
        System.out.println("Alege jucatorul numarul: " + turn);
        if(tokens.size()>0)
        {
            int nrToken=0;
            if(strategy==0)
            {
                nrToken=(int)(Math.random()*10000)%tokens.size();
                System.out.println("\tA ales tokenul: " + tokens.get(nrToken));

            }
            else
            {
                Scanner in= new Scanner(System.in);
                int ok=0;

                while(ok==0) {
                    System.out.println("\t Perechile disponibile sunt: " + tokens);
                    System.out.println("Alegeti primul numar al perechii");
                    int nr = in.nextInt();
                    System.out.println("Alegeti al doilea numar al perechii");
                    int nr2 = in.nextInt();
                    if(getIndex(nr, nr2)!=-1){
                        int poz=getIndex(nr, nr2);
                        System.out.println( poz);
                        System.out.println("\tA ales tokenul: " + tokens.get(nrToken));
                        nrToken=poz;
                        ok=1;
                    }
                    else{
                        System.out.println("Pereche indisponibila");
                    }
                }
            }
            this.asignedTokens.put(tokens.get(nrToken),turn);
            tokens.remove(nrToken);
        }
        if(maximum_Player==number)
            this.turn= 1;
        else
            this.turn=number+1;

        available= true;
        notifyAll();
    }
    Map<Pair, Integer> getPairs(){
        for(Map.Entry i : asignedTokens.entrySet()){
            System.out.println("Player number: " + i.getValue() + " " + i.getKey() );
            System.out.println("\t"+((Pair) i.getKey()).first);
        }
        return asignedTokens;
    }
    int getIndex(int first, int second){
        for(int i=0; i< tokens.size(); i++){
            if(tokens.get(i).first== first && tokens.get(i).second==second)
                return i;
        }
        return -1;
    }

}
