package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Employee;

/**
 * Created by Grzegorz Różycki on 05.06.16
 */
public class ChangeNameTransaction extends ChangeEmployeeTransaction {
    final String name;

    public ChangeNameTransaction(int empId, String name) {
        super(empId);
        this.name = name;
    }

    @Override
    protected void change(Employee employee) {
        employee.name = name;
    }
}
