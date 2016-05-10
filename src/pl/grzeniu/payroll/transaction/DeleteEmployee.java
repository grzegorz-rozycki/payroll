package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.PayrollDatabase;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class DeleteEmployee implements Transaction {
    protected int empId = 0;


    public DeleteEmployee(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        PayrollDatabase.deleteEmployee(empId);
    }
}
