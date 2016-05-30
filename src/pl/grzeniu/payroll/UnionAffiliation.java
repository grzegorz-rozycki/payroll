package pl.grzeniu.payroll;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grzegorz Różycki on 17.05.16
 */
public class UnionAffiliation {
    protected Map<Date, ServiceCharge> chargeList = new HashMap<>();

    public void addServiceCharge(Date date, ServiceCharge charge) {
        assert date != null;
        assert charge != null;

        chargeList.put(date, charge);
    }

    public ServiceCharge getServiceCharge(Date date) {
        assert date != null;

        return chargeList.get(date);
    }
}
