package pl.grzeniu.payroll;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Grzegorz Różycki on 06.11.16
 *
 * Uses a calendar implementation to return a Date object.
 */
public class DateHelper {
    public static final Calendar calendar = Calendar.getInstance();

    public static Date makeDate(final int year, final int month, final int day)
    {

        calendar.set(year, month, day);

        return calendar.getTime();
    }
}
