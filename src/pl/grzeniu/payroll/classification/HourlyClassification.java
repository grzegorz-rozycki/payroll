package pl.grzeniu.payroll.classification;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class HourlyClassification extends PaymentClassification {
    public double hourlyRate = 0.0;

    public HourlyClassification(double hourlyRate) {
        super();
        this.hourlyRate = hourlyRate;
    }

    public void addTimeCard(TimeCard timeCard) {

    }

    public TimeCard getTimeCard(Date date) {
        return null;
    }
}
