import org.junit.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ChurchTest {

    @org.junit.jupiter.api.Test

    public void getSetOpen(){
        Church c=new Church();
        LocalTime t=LocalTime.of(10, 10);
        c.setOpeningTime(t);
        LocalTime t2=c.getOpeningTime();
        assertEquals(t2, t);
    }

    @org.junit.jupiter.api.Test
    public void getSetClose(){
        Church c=new Church();
        LocalTime t=LocalTime.of(10, 10);
        c.setClosingTime(t);
        LocalTime t2=c.getClosingTime();
        assertEquals(t2, t);
    }

}