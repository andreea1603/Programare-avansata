import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test extends Thread{
    public static void main(String[] args) throws InterruptedException {
        Scanner scan= new Scanner(System.in);
        //NewThread daemonThread = new NewThread();

        Thread timeKeeper = new Thread();
        timeKeeper.setDaemon(true);
        timeKeeper.start();

        int n= scan.nextInt();
        Buffer buffer= new Buffer();
        Board pb = new Board(n);
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "player1", buffer, 1));
        players.add(new Player(2, "player2", buffer, 0));
        //players.add(new Player(4, "player4", buffer, 1));
        buffer.setMaximum_Player(players.size());
        Play play= new Play(players, pb);
        buffer.setTokens(pb.pair);
            for (int i = 0; i < players.size(); i++) {
                play.players.get(i).start();
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        sleep(1000);
        //buffer.getPairs();  //afiseaza perechile de tip token- player
        for (int i = 0; i < players.size(); i++)
            play.players.get(i).join();
        //System.out.println(buffer.getPairs());

        for(int i=0; i<players.size(); i++)
            players.get(i).setTokenForEachPlayer();

        for(int i=0; i<players.size(); i++)
            players.get(i).afis();
        play.checkCycle();
        System.out.println("Jucatorul castigator este: " + play.getWinner() + "Cu punctele: " + play.getPoints());
    }
}
