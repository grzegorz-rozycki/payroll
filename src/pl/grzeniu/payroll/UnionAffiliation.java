package pl.grzeniu.payroll;

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
        super();
    }

    public void addServiceCharge(Date date, double charge) {
        assert date != null;
        chargeList.put(date, new ServiceCharge(charge, date));
    }

    public ServiceCharge getServiceCharge(Date date) {
        assert date != null;

        return chargeList.get(date);
    }
}
