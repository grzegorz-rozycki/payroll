package pl.grzeniu.payroll.classification;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class HourlyClassification extends PaymentClassification {
    protected Map<Long, TimeCard> timeCards = new TreeMap<>();
    public double hourlyRate = 0.0;


    public HourlyClassification(double hourlyRate) {
        super();
        this.hourlyRate = hourlyRate;
    }

    public void addTimeCard(TimeCard timeCard) {
        timeCards.put(timeCard.date.getTime(), timeCard);
    }

    public TimeCard getTimeCard(Date date) {
        return timeCards.get(date.getTime());
    }
}
