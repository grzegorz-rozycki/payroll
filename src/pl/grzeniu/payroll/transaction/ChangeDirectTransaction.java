package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.method.DirectMethod;
import pl.grzeniu.payroll.method.PaymentMethod;

/**
 * Created by Grzegorz Różycki on 22.06.16
 */
public class ChangeDirectTransaction extends ChangeMethodTransaction {

    public ChangeDirectTransaction(int empId) {
        super(empId);
    }

    @Override
    protected PaymentMethod getMethod() {
        return new DirectMethod();
    }
}
