package pl.grzeniu.payroll.schedule;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class MonthlySchedule extends PaymentSchedule {

    @Override
    public boolean isPayDate(Date date) {
        final Calendar calendar = Calendar.getInstance();
        int month1, month2;

        calendar.setTime(date);
        month1 = calendar.get(Calendar.MONTH);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        month2 = calendar.get(Calendar.MONTH);

        return (month1 != month2);
    }
}
