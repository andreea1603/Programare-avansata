import java.util.ArrayList;
import java.util.List;

public class Play {
    List<Player> players=new ArrayList<>();
    Board board;

    public Play(List<Player> players, Board p){
        super();
        this.players= players;
        this.board =p;
        try{
            Thread.sleep(600);
        }
        catch (Exception e){System.out.println(e);}
    }
    public void addPlayers(Player p){
        players.add(p);
    }

}
