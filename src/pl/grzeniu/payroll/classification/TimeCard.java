package pl.grzeniu.payroll.classification;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 11.05.16
 */
public class TimeCard {
    public final Date date;
    public final double hours;

    public TimeCard(Date date, double hours) {
        this.date = date;
        this.hours = hours;
    }
}
