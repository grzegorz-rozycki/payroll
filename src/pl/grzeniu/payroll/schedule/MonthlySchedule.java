package pl.grzeniu.payroll.schedule;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class MonthlySchedule extends PaymentSchedule {

    @Override
    public boolean isPayDate(Date date) {
        final Date date2 = new Date(date.getTime());
        date2.setDate(date.getDate() + 1);
        final int month1 = date.getMonth();
        final int month2 = date2.getMonth();

        return (month1 != month2);
    }
}
