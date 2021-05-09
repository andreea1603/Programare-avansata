import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TravelPlanTest {

    @Test
    void toMatrix() {
    }

    @Test
    void getIndex() {
        Church v5 = new Church();
        v5.setName("loc");
        List<Locations> loc=new ArrayList<>();
        loc.add(v5);
        City ci = new City(loc, "Roman");
        TravelPlan t1=new TravelPlan(ci, null);
        int k=t1.getIndex("loc");
        assertEquals(k, 0 );
    }
    @Test
    void getIndex2() {
        Church v5 = new Church();
        v5.setName("loc");
        List<Locations> loc=new ArrayList<>();
        loc.add(v5);
        City ci = new City(loc, "Roman");
        TravelPlan t1=new TravelPlan(ci, null);
        int k=t1.getIndex("local");
        assertEquals(k, -1 );
    }

    @Test
    void minimumDistanceVertex() {
        int visited[]=new int[10];
        int distance[]=new int[10];

        for(int i=0; i<10; i++) {
            visited[i] = 0;
            distance[i]=4;
        }
        visited[4]=1;   distance[4]=10;
        visited[8]=1;   distance[8]=11;
        distance[0]=1;  distance[2]=3;

        TravelPlan travelPlan=new TravelPlan(null, null);
        int index=travelPlan.minimumDistanceVertex(visited, distance);
        assertEquals(index, 0);
    }

    @Test
    void visitedNodes() {
        int visited[]=new int[10];
        for(int i=0; i<10; i++)
            visited[i] = 0;
        TravelPlan travelPlan=new TravelPlan(null, null);
        int index = travelPlan.visitedNodes(visited);
        assertEquals(0, index);
    }
    @Test
    void visitedNodes2() {
        int visited[]=new int[10];
        for(int i=0; i<10; i++)
            visited[i] = 1;
        TravelPlan travelPlan=new TravelPlan(null, null);
        int index = travelPlan.visitedNodes(visited);
        assertEquals(1, index);
    }


}