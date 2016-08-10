package pl.grzeniu.payroll.classification;

import pl.grzeniu.payroll.Paycheck;

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

    @Override
    public double calculatePay(Paycheck paycheck) {
        double totalPay = 0.0;

        for (TimeCard card : timeCards.values()) {
            if (isInPayPeriod(card, paycheck.payDate)) {
                totalPay += calculatePayForTimeCard(card);
            }
        }

        return totalPay;
    }

    public void addTimeCard(TimeCard timeCard) {
        timeCards.put(timeCard.date.getTime(), timeCard);
    }

    public TimeCard getTimeCard(Date date) {
        return timeCards.get(date.getTime());
    }

    protected boolean isInPayPeriod(TimeCard timeCard, Date payPeriod) {
        final Date payPeriodEndDate = payPeriod;
        final Date payPeriodStartDate = ((Date) payPeriodEndDate.clone());
        payPeriodStartDate.setDate(-5);

        return (timeCard.date.getTime() >= payPeriodStartDate.getTime()
                && timeCard.date.getTime() <= payPeriodEndDate.getTime());
    }

    protected double calculatePayForTimeCard(TimeCard timeCard) {
        double overtimeHours = Math.max(0.0, timeCard.hours - 8);
        double normalHours = timeCard.hours - overtimeHours;

        return ((normalHours * hourlyRate) + (overtimeHours * hourlyRate * 1.5));
    }
}
