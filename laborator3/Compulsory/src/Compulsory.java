import java.time.LocalTime;
import java.util.ArrayList;
import java.util.*;

public class Compulsory {
    public static void main(String[] args) {
    Hotel v1=new Hotel();

    Museum v2= new Museum();
    v2.setOpeningTime(LocalTime.of(7, 0));
    v2.setClosingTime(LocalTime.of(17,50));
    v2.setTicketPrice(10);

    Museum v3=new Museum();
    v3.setOpeningTime(LocalTime.parse("20:00"));
    v3.setClosingTime(LocalTime.MIDNIGHT);
    Church v4=new Church();
    Church v5= new Church();
    Restaurant v6= new Restaurant();
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

    List<Locations> loc=new ArrayList<Locations>();
    loc.add(v1); loc.add(v2);
    loc.add(v4); loc.add(v6);
    City ci=new City(loc, "Roman");
    ci.addLocation(v3);
    ci.addLocation(v5);
    System.out.println(ci.toString());
    }
}

