import java.time.LocalTime;
import java.util.ArrayList;
import java.util.*;

public class Optional {
    public static void main(String[] args) {
        Hotel v1 = new Hotel();

        Museum v2 = new Museum();
        v2.setOpeningTime(LocalTime.of(7, 0));
        v2.setClosingTime(LocalTime.of(17, 50));
        v2.setTicketPrice(10);

        Museum v3 = new Museum();
        v3.setOpeningTime(LocalTime.parse("20:00"));
        v3.setClosingTime(LocalTime.MIDNIGHT);
        v3.setTicketPrice(13);

        Church v4 = new Church();
        v4.setOpeningTime(LocalTime.parse("10:30"));
        v4.setClosingTime(LocalTime.MIDNIGHT);

        Church v5 = new Church();
        v5.setOpeningTime(LocalTime.parse("08:30"));
        // v5.setClosingTime(LocalTime.parse("20:00"));
        ///////////////////////////////
        // System.out.println(v5.getClosingTime());
        Restaurant v6 = new Restaurant();
        v6.setRank(3);

        v1.setName("Hotel1");
        v2.setName("Museum A");
        v3.setName("Museum B");
        v4.setName("Church A");
        v5.setName("Church B");
        v6.setName("Restaurant1");

        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);
        v3.setCost(v4, 20);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v6, 20);

        List<Locations> loc = new ArrayList<Locations>();
        loc.add(v1);
        loc.add(v2);
        loc.add(v3);
        loc.add(v4);
        loc.add(v5);

        City ci = new City(loc, "Roman");

        ci.addLocation(v6);

        ci.Display();

        List<String> Preferences = new ArrayList<String>();
        Preferences.add("Museum A");
        Preferences.add("Museum B");
        Preferences.add("Restaurant1");
        Preferences.add("Church B");

        TravelPlan t1 = new TravelPlan(ci, Preferences);
        //System.out.println("Durata de vizita este: " + Visitable.getVisitingDuration(v2));//foloseste metoda statica
        t1.toMatrix(); //afiseaza distanta intre 2 locatii
        //if ( v2 instanceof Visitable)
        //   System.out.println(((Visitable) v2).getOpeningTime()); //foloseste metoda default
        //System.out.println(t1.costs.toString());
        //t1.dfs()
        /*
        for (int i = 0; i < t1.oras.locations.size(); i++)
        {
            for (int j = 0; j < t1.oras.locations.size(); j++) {
                System.out.print(t1.costs[i][j] + " ");
            }
            System.out.println();
        }

         */
        System.out.println("Punctul de start este Hotel1");
        int visited[]=new int[t1.oras.locations.size()];
        for(int i=0; i<visited.length; i++)
        {
            visited[i]=0;
        }
        List<Integer> order=new ArrayList<>();

        int timePerDay=70;
        order.add(0);
        t1.dfs(0, visited, 0,order, 0, timePerDay);

        System.out.println("Afisez planul: ");
        System.out.println(t1.plans);
        System.out.println(t1.getMaximulLocationIndex());
        t1.getPlan(6);
    }
}

