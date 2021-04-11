import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Play {
    List<Player> players=new ArrayList<>();
    Board board;
    List<Integer> points=new ArrayList<>();
    int maximumCycleLength[];

    public Play(List<Player> players, Board p){
        super();
        maximumCycleLength= new int[players.size()];
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


    public void checkCycle(){
            int visited[]= new int[1000000];
            for(int i=0; i<board.numberofTokens; i++)
                visited[i]=0;
            for(int i=0; i< players.size(); i++){//pentru fiecare jucator
                for(int j=0; j<players.get(i).tokenForEachPlayer.size(); j++) { //pentru fiecare pereche de tokeni
                    int length= dfs(players.get(i).turn-1, visited, this.players.get(i).tokenForEachPlayer, j, j, 0);
                    //System.out.println("nr unui ciclu este : " + length);
                    points.add(length); //toate ciclurile posibile
                }
                System.out.println(maximumCycleLength[i]+ " nr unui circuit este");
            }
    }
    int dfs(int x, int visited[], List<Pair> sequence, int startNode, int currentNode, int length)
    {

        //System.out.println("Hello");
        if(visited[currentNode]==1) {
            if (currentNode == startNode)
            {
                if(this.maximumCycleLength[x]< length) {
                    this.maximumCycleLength[x]=length;
                }
                return length;
            }
            return length;
        }

        visited[currentNode]=1;
        for(int k=0; k<this.players.get(x).tokenForEachPlayer.size(); k++){ //pentru fiecare token din secventa mea
            if(currentNode <this.players.get(x).tokenForEachPlayer.size() ) {

                if (
                        ((Pair) this.players.get(x).tokenForEachPlayer.get(currentNode)).second
                                ==
                                ((Pair) this.players.get(x).tokenForEachPlayer.get(k)).first) {   //daca a doua valoare a tokenului curent == a doua valoare a tokenului parcurs
                    length++;
                    dfs(x, visited, sequence, startNode, k, length);
                    length--;

                }

            }


        }
        //sequence.remove(currentNode);
        //length--;
        visited[currentNode]=0;
       return 1;
    }
    public int getNumberofPoints(List<Pair> sequence){
        int sum=0;
        for(int i=0; i< sequence.size(); i++){
            sum=sum+sequence.get(i).value;
        }
        return sum;
    }
    public int getNumberOfTokens(List<Pair> sequence){
        return sequence.size();
    }

    public int getWinner(){
        int max=0, poz=0;
        for(int i=0; i<this.players.size(); i++)
        {
            if(max< this.maximumCycleLength[i]*getNumberofPoints(players.get(i).tokenForEachPlayer)){
                max= maximumCycleLength[i]*getNumberofPoints(players.get(i).tokenForEachPlayer);
                poz=i;
            }
        }
        return (poz+1);
    }
    public int getPoints(){
        int max=0, poz=0;
        for(int i=0; i<this.players.size(); i++)
        {
            if(max< maximumCycleLength[i]*getNumberofPoints(players.get(i).tokenForEachPlayer)){
                max= maximumCycleLength[i]*getNumberofPoints(players.get(i).tokenForEachPlayer);
                poz=i;
            }
        }
        return max;

    }


}
