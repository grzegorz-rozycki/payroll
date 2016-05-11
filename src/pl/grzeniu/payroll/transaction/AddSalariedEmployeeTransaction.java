package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.classification.PaymentClassification;
import pl.grzeniu.payroll.classification.SalariedClassification;
import pl.grzeniu.payroll.schedule.MonthlySchedule;
import pl.grzeniu.payroll.schedule.PaymentSchedule;

/**
 * Created by Grzegorz Różycki on 08.05.16
 */
public class AddSalariedEmployeeTransaction extends AddEmployeeTransaction {
    protected double salary = 0.0;


    public AddSalariedEmployeeTransaction(int empId, String empName, String empAddress, double salary) {
        super(empId, empName, empAddress);
        this.salary = salary;
    }


    @Override
    protected PaymentClassification makeClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new MonthlySchedule();
    }
}
