package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Employee;
import pl.grzeniu.payroll.PayrollDatabase;

/**
 * Created by Grzegorz Różycki on 05.06.16
 */
public abstract class ChangeEmployeeTransaction implements Transaction {
    final int empId;


    public ChangeEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        final Employee emp = PayrollDatabase.getEmployee(empId);

        if (emp == null) {
            throw new InvalidOperationException("No such employee");
        }

        change(emp);
    }

    protected abstract void change(Employee employee);
}
