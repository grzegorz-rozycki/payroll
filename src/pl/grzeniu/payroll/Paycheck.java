package pl.grzeniu.payroll;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grzegorz Różycki on 26.06.16.
 */
public class Paycheck {
    public final Date payPeriodEnd;
    public final Date payPeriodStart;
    double grossPay = 0.0;
    double netPay = 0.0;
    double deductions = 0.0;
    private Map<String, String> fields = new HashMap<>();


    public Paycheck(final Date payPeriodStart, final Date payPeriodEnd) {
        this.payPeriodStart = payPeriodStart;
        this.payPeriodEnd = payPeriodEnd;
    }

    public String getField(String fieldName) {
        return fields.get(fieldName);
    }

    public void setField(String field, String value) {
        fields.put(field, value);
    }
}
