import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan= new Scanner(System.in);
        int n= scan.nextInt();
        Buffer buffer= new Buffer();
        Problem pb = new Problem(n);
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "player1", buffer));
        players.add(new Player(2, "player2", buffer));
        players.add(new Player(3, "player3", buffer));
        players.add(new Player(4, "player4", buffer));

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
        buffer.getPairs();  //afiseaza perechile de tip token- player

    }
}
