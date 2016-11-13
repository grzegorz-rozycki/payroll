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
    protected Map<String, ServiceCharge> chargeList = new HashMap<>();
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
        chargeList.put(dateToKey(date), new ServiceCharge(charge, date));
    }

    public ServiceCharge getServiceCharge(Date date) {
        assert date != null;

        return chargeList.get(dateToKey(date));
    }

    @Override
    public double calculateDeductions(Paycheck paycheck) {
        // dues
        final double d = dues * DateUtil.numberOfFridaysInPayPeriod(paycheck.payPeriodStart, paycheck.payPeriodEnd);
        // charges
        final double c = calculateCharges(paycheck.payPeriodStart, paycheck.payPeriodEnd);

        return (d + c);
    }

    private double calculateCharges(Date payPeriodStart, Date payPeriodEnd) {
        final Calendar cal = Calendar.getInstance();
        double charges = 0.0;
        ServiceCharge sc = null;
        cal.setTime(payPeriodEnd);

        for (int i = 0, n = DateUtil.daysBetween(payPeriodStart, payPeriodEnd); i < n; i += 1, cal.add(Calendar.DATE, -1)) {
            sc = getServiceCharge(cal.getTime());

            if (null != sc) {
                charges += sc.amount;
            }
        }

        return charges;
    }

    private String dateToKey(Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return ("" + cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH) + cal.get(Calendar.DAY_OF_MONTH));
    }
}
