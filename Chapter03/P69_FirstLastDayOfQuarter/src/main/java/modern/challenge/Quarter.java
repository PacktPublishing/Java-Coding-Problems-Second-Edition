package modern.challenge;

import java.util.Date;

public final class Quarter {

    private final Date firstDay;
    private final Date lastDay;

    public Quarter(Date firstDay, Date lastDay) {
        this.firstDay = firstDay;
        this.lastDay = lastDay;
    }

    public Date getFirstDay() {
        return firstDay;
    }

    public Date getLastDay() {
        return lastDay;
    }

    @Override
    public String toString() {
        return "Quarter{" + "firstDay=" + firstDay + ", lastDay=" + lastDay + '}';
    }        
}