import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    @org.junit.jupiter.api.Test
    public void getSetOpen(){
        Restaurant restaurant=new Restaurant();
        restaurant.setRank(10);
        int rankExpected=restaurant.getRank();
        assertEquals(rankExpected, 10);
    }

}