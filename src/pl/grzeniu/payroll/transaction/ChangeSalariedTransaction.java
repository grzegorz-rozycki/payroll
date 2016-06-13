package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.classification.PaymentClassification;
import pl.grzeniu.payroll.classification.SalariedClassification;
import pl.grzeniu.payroll.schedule.MonthlySchedule;
import pl.grzeniu.payroll.schedule.PaymentSchedule;

/**
 * Created by Grzegorz Różycki on 13.06.16
 */
public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
    protected final double salary;


    public ChangeSalariedTransaction(int empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }
}
