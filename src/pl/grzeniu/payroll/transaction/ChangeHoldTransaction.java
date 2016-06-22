package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.method.HoldMethod;
import pl.grzeniu.payroll.method.PaymentMethod;

/**
 * Created by Grzegorz Różycki on 22.06.16
 */
public class ChangeHoldTransaction extends ChangeMethodTransaction {

    public ChangeHoldTransaction(int empId) {
        super(empId);
    }

    @Override
    protected PaymentMethod getMethod() {
        return new HoldMethod();
    }
}
