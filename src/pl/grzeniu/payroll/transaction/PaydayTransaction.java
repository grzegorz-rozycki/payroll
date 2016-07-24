package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Employee;
import pl.grzeniu.payroll.Paycheck;
import pl.grzeniu.payroll.PayrollDatabase;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grzegorz Różycki on 26.06.16.
 */
public class PaydayTransaction implements Transaction {

    protected final Date payDate;
    protected final Map<Integer, Paycheck> paychecks;

    public PaydayTransaction(Date payDate) {
        this.payDate = payDate;
        this.paychecks = new HashMap<>();
    }

    @Override
    public void execute() {

        for (final int empId : PayrollDatabase.getAllEmployeeIds()) {
            final Employee employee = PayrollDatabase.getEmployee(empId);

            if (employee.isPayDate(payDate)) {
                final Paycheck pc = new Paycheck(payDate);
                paychecks.put(empId, pc);
                employee.payday(pc);
            }
        }
    }

    public Paycheck getPaycheck(final int employeeId) {
        return paychecks.get(employeeId);
    }
}
