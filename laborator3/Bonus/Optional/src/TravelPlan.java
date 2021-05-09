import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

public class TravelPlan {
    City oras;
    List<String> preferences;
    int[][] costs;
    int numberOfDays;
    Map<Integer, List<String>> planByDays = new HashMap<>();
    Map<Integer, List<Integer>> plans= new HashMap<>();
    int day=0;

    public TravelPlan(City oras, List<String> Preferences) {
        this.oras = oras;
        this.preferences = Preferences;
    }

    //transpune harta intr-o matrice, costul fiind timpul de a ajunge de la un punct la altul
    void toMatrix() {

        costs = new int[oras.locations.size()][oras.locations.size()];
        for (int i = 0; i < oras.locations.size(); i++)
            for (int j = 0; j < oras.locations.size(); j++)
                costs[i][j] = Integer.MAX_VALUE;

        for (int i = 0; i < oras.locations.size(); i++)
            for (int j = 0; j < oras.locations.size(); j++) {
                if ((oras.locations.get(i).time1).containsKey(oras.locations.get(j))) {
                    costs[i][j] = oras.locations.get(i).time1.get(oras.locations.get(j));
                    costs[j][i] = oras.locations.get(i).time1.get(oras.locations.get(j));
                }
            }
    //    System.out.println("Costul este de : " + findCost());
    }

    //returneaza pozitia unei locatii in lista
    int getIndex(String l1) {
        for (int i = 0; i < oras.locations.size(); i++) {
            if (oras.locations.get(i).name.equals(l1)) {
                //System.out.println(i + l1);
                return i;
            }
        }
        return -1;
    }
    //cea mai mica distanta
    int minimumDistanceVertex(int[] visited, int[] distance) {
        int position = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < visited.length; i++) {
            if (distance[i] <= min && visited[i] == 0) {
                position = i;
                min = distance[i];
            }
        }
        return position;
    }

    //daca toate nodurile sunt vizitate
    int visitedNodes(int[] visited) {
        for (int i = 0; i < visited.length; i++)
            if (visited[i] == 0)
                return 0;
        return 1;
    }

    int dijkstra(int start, int end) {
        int distance[] = new int[this.oras.locations.size()];
        int visited[] = new int[this.oras.locations.size()];

        for (int i = 0; i < this.oras.locations.size(); i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = 0;
        }
        distance[start] = 0;

        while (visitedNodes(visited) == 0) {

            int node = minimumDistanceVertex(visited, distance);

            for (int i = 0; i < visited.length; i++) {
                if (this.costs[i][node] != Integer.MAX_VALUE) {
                    int value;
                    value = distance[node] + costs[i][node];
                    if (value < distance[i]) {
                        distance[i] = value;
                    }
                }
            }
            visited[node] = 1;
        }
        return distance[end];
    }
/*
    int findCost() {
        int start = getIndex("Museum B");
        int end = getIndex("Hotel1");
        if (start == -1 && end == -1) {
            System.out.println("Nu exista aceste locatii!");
            return 0;
        }
        return dijkstra(start, end);
    }

 */
    int dfs(int x, int visited[], int start,List<Integer> order, int k, int timePerDay)
    {
        if(visited[x]==1){

            int totalTime=0;

            if(x==start)
            {
                 for(int i=0; i < order.size()-2; i++)
                        totalTime=totalTime+costs[i][i+1];

                 if(totalTime<timePerDay) {
                     //System.out.println(totalTime);
                     List<Integer> days=new ArrayList<>();

                     //System.out.println("Circuitul format: ");
                     for (int i = 0; i < order.size(); i++) {
                       //  System.out.print(order.get(i) + " ");
                         days.add(order.get(i));
                     }
                     this.plans.put(k, days);
                     //System.out.println();
                     return 0;
                 }
            }
            return 0;
        }
        visited[x]=1;
        for(int i=0; i< this.oras.locations.size(); i++){
            if(this.costs[i][x]!=0 || this.costs[x][i]!=0){
                order.add(i);
                dfs(i, visited, start, order, k, timePerDay);
                k++;
                order.remove(order.size()-1);
            }
        }
        visited[x]=0;
        return 0;
    }
    void getPlan(int days){
        this.numberOfDays=days;
        int visited[]= new int[this.oras.locations.size()];
        for(int i=0; i<days; i++) {
            int index = getMaximulLocationIndex();
            System.out.println("\t Traseu pe zile: ");
            int ok=0;
            List<String> namesOfLocation = new ArrayList<>();
            for (int j = 0; j < this.plans.get(index).size(); j++) {
                if(visited[plans.get(index).get(j)]==0)
                    ok=1;
                visited[plans.get(index).get(j)] = 1;
                namesOfLocation.add(this.oras.locations.get(plans.get(index).get(j)).name);
                System.out.println(this.oras.locations.get(plans.get(index).get(j)).name);
            }
                for (int j = 0; j < this.plans.get(index).size(); j++)
                    plans.get(index).remove(j);

            if(ok==1 || (plans.size()-1)<= i) {
                if((plans.size()-1)<= i)
                    System.out.println("a");
                planByDays.put(planByDays.size(), namesOfLocation);
            }
        }
    }
    int getMaximulLocationIndex(){
        for(int i=0; i<this.plans.size(); i++)
        {
            //System.out.println(this.plans.get(i).size() + " " + this.plans.get(i));
        }
        int maximum=0, index=0;
        for(int i=0; i<this.plans.size(); i++){
            if(this.plans.get(i).size()>maximum)
            {
                maximum=this.plans.get(i).size();
                index=i;
            }
        }
        return index;
    }


}
