package pl.grzeniu.payroll.schedule;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class WeeklySchedule extends PaymentSchedule {
    @Override
    public boolean isPayDate(Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return (Calendar.FRIDAY == calendar.get(Calendar.DAY_OF_WEEK));
    }

    @Override
    public Date getPayPeriodStart(final Date payDate) {
        // asserts that payDate is valid pay date
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(payDate);
        calendar.add(Calendar.DATE, -5);

        return calendar.getTime();
    }
}
