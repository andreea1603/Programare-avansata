import java.time.LocalTime;

import java.time.*;

public interface Visitable {

    public LocalTime getOpeningTime();

    public LocalTime getClosingTime();

    default LocalTime SetOpeningTime() {
        return LocalTime.parse("09:30");
    }

    default LocalTime SetClosingTime() {
        return LocalTime.parse("20:00");
    }

    static Duration getVisitingDuration(Locations l2) {
        if( l2 instanceof Visitable) {
            LocalTime start = ((Visitable) (l2)).getOpeningTime();
            LocalTime end = ((Visitable) (l2)).getClosingTime();
            Duration timeLong = Duration.between(start, end);
            return timeLong;
        }
        Duration timeLong=Duration.parse("0");
        return timeLong;
    }
}
