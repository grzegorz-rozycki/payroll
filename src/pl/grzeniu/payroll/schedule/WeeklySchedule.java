package pl.grzeniu.payroll.schedule;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class WeeklySchedule extends PaymentSchedule {
    @Override
    public boolean isPayDate(Date date) {
        return (date.getDay() == 5);
    }
}
