package pl.grzeniu.payroll;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grzegorz Różycki on 26.06.16.
 */
public class Paycheck {
    public Date payDate = null;
    public double grossPay = 0.0;
    public double netPay = 0.0;
    public double deductions = 0.0;
    public Map<String, String> fields = new HashMap<>();


    public Paycheck(Date payDate) {
        this.payDate = payDate;
    }

    public String getField(String fieldName) {
        return fields.get(fieldName);
    }

    public void setField(String field, String value) {
        fields.put(field, value);
    }
}
