import java.time.LocalTime;

public class Museum extends  Locations implements Visitable, Payable{
    private LocalTime openingTime, closingTime;
    private double ticketPrice;


    @Override
    public LocalTime getOpeningTime(){
        return openingTime;
    }
    @Override
    public LocalTime getClosingTime(){
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public double getTicketPrice(){
        return ticketPrice;
    }
    public void setOpeningTime(LocalTime time1){
        openingTime=time1;
    }

    @Override
    public String toString() {
        return '\n'+"Museum{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
