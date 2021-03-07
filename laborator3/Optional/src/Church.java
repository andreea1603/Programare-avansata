import java.time.LocalTime;

public class Church extends  Locations implements Visitable{
    private LocalTime openingTime, closingTime;

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

    public void setOpeningTime(LocalTime openingTime)
    {
        this.openingTime= openingTime;
    }

    @Override
    public String toString() {
        return '\n'+ "Church{" +
                "openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
