package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Employee;
import pl.grzeniu.payroll.method.PaymentMethod;

/**
 * Created by Grzegorz Różycki on 22.06.16
 */
public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {

    public ChangeMethodTransaction(int empId) {
        super(empId);
    }


    @Override
    protected void change(Employee employee) {
        employee.method = getMethod();
    }

    protected abstract PaymentMethod getMethod();
}
