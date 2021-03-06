package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.method.MailMethod;
import pl.grzeniu.payroll.method.PaymentMethod;

/**
 * Created by Grzegorz Różycki on 22.06.16
 */
public class ChangeMailTransaction extends ChangeMethodTransaction {

    public ChangeMailTransaction(int empId) {
        super(empId);
    }

    @Override
    protected PaymentMethod getMethod() {
        return new MailMethod();
    }
}
