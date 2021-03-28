import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TransferQueue;

public class Play {
    List<Player> players=new ArrayList<>();
    Problem problem;

    public Play(List<Player> players, Problem p){
        super();
        this.players= players;
        this.problem=p;
        try{
            Thread.sleep(600);
        }
        catch (Exception e){System.out.println(e);}
    }
    public void addPlayers(Player p){
        players.add(p);
    }

}
