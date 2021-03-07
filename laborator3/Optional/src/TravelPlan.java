import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

public class TravelPlan {
    City oras;
    List<String> preferences;
    int[][] costs;

    public TravelPlan(City oras, List<String> Preferences) {
        this.oras = oras;
        this.preferences = Preferences;
    }

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
       /* for(int i=0; i< oras.locations.size(); i++) {
            for (int j = 0; j < oras.locations.size(); j++) {
                System.out.print(costs[i][j] + " ");
            }
            System.out.println();
        }
        */
        System.out.println("Costul este de : " + findCost());
    }

    int getIndex(String l1) {
        for (int i = 0; i < oras.locations.size(); i++) {
            if (oras.locations.get(i).name.equals(l1)) {
                //System.out.println(i + l1);
                return i;
            }
        }
        return -1;
    }

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

    int findCost() {
        int start = getIndex("Museum B");
        int end = getIndex("Hotel1");
        if (start == -1 && end == -1) {
            System.out.println("Nu exista aceste locatii!");
            return 0;
        }
        return dijkstra(start, end);
    }
}
