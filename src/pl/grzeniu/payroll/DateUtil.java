package pl.grzeniu.payroll;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final Calendar calendar = Calendar.getInstance();

    public static Date makeDate(final int year, final int month, final int day)
    {
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    public static int numberOfFridaysInPayPeriod(Date payPeriodStart, Date payPeriodEnd) {
        final int days = daysBetween(payPeriodStart, payPeriodEnd);
        int fridays = 0;

        calendar.setTime(payPeriodEnd);

        for (int i = 0; i < days; i += 1, calendar.add(Calendar.DATE, -1)) {
            if (Calendar.FRIDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
                fridays += 1;
            }
        }

        return fridays;
    }

    public static int daysBetween(Date payPeriodStart, Date payPeriodEnd) {
        return (int)(payPeriodEnd.getTime() - payPeriodStart.getTime()) / 86400000;
    }

    public static boolean isInPayPeriod(final Date theDate, final Paycheck paycheck) {
        return (theDate.getTime() >= paycheck.payPeriodStart.getTime()
                && theDate.getTime() <= paycheck.payPeriodEnd.getTime());
    }
}
