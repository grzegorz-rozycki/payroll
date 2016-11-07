package pl.grzeniu.payroll.classification;

import pl.grzeniu.payroll.Paycheck;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class PaymentClassification {

    public double calculatePay(Paycheck paycheck) {
        return 0.0;
    }

    public boolean isInPayPeriod(final Date theDate, final Paycheck paycheck) {
        return (theDate.getTime() >= paycheck.payPeriodStart.getTime()
                && theDate.getTime() <= paycheck.payPeriodEnd.getTime());
    }
}
