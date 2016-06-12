package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Employee;
import pl.grzeniu.payroll.classification.PaymentClassification;
import pl.grzeniu.payroll.schedule.PaymentSchedule;

/**
 * Created by grzechu on 12.06.16.
 */
public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

    public ChangeClassificationTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee employee) {
        employee.classification = getClassification();
        employee.schedule = getSchedule();
    }

    public abstract PaymentClassification getClassification();

    public abstract PaymentSchedule getSchedule();
}
