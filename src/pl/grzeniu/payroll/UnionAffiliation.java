package pl.grzeniu.payroll;

import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grzegorz Różycki on 17.05.16
 */
public class UnionAffiliation extends Affiliation {
    protected Map<Date, ServiceCharge> chargeList = new HashMap<>();
    protected double dues = 0.0;

    public UnionAffiliation(double dues) {
        super();
        this.dues = dues;
    }

    public UnionAffiliation() {
        this(0.0);
    }

    public void addServiceCharge(Date date, double charge) {
        assert date != null;
        chargeList.put(date, new ServiceCharge(charge, date));
    }

    public ServiceCharge getServiceCharge(Date date) {
        assert date != null;

        return chargeList.get(date);
    }

    @Override
    public double calculateDeductions(Paycheck paycheck) {
        return (dues * numberOfFridaysInPayPeriod(paycheck.payPeriodStart, paycheck.payPeriodEnd));
    }

    private int numberOfFridaysInPayPeriod(Date payPeriodStart, Date payPeriodEnd) {
        final Calendar cal = Calendar.getInstance();
        final int days = (int)(payPeriodEnd.getTime() - payPeriodStart.getTime()) / 86400000;
        int fridays = 0;

        cal.setTime(payPeriodEnd);

        for (int i = 0; i < days; i += 1, cal.add(Calendar.DATE, -1)) {
            if (Calendar.FRIDAY == cal.get(Calendar.DAY_OF_WEEK)) {
                fridays += 1;
            }
        }

        return fridays;
    }
}
