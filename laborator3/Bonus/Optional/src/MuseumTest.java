import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class MuseumTest {

    @org.junit.jupiter.api.Test

    public void getSetOpen(){
        Museum c=new Museum();
        LocalTime t=LocalTime.of(10, 10);
        c.setOpeningTime(t);
        LocalTime t2=c.getOpeningTime();
        assertEquals(t2, t);
    }

    @org.junit.jupiter.api.Test
    public void getSetClose(){
        Museum c=new Museum();
        LocalTime t=LocalTime.of(10, 10);
        c.setClosingTime(t);
        LocalTime t2=c.getClosingTime();
        assertEquals(t2, t);
    }
    @org.junit.jupiter.api.Test
    public void getSetPrice(){
        double price= 10.3;
        Museum m=new Museum();
        m.setTicketPrice(price);
        double priceExpected=m.getTicketPrice();
        assertEquals(priceExpected, price);
    }
}