package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.classification.CommissionedClassification;
import pl.grzeniu.payroll.classification.PaymentClassification;
import pl.grzeniu.payroll.schedule.BiweeklySchedule;
import pl.grzeniu.payroll.schedule.PaymentSchedule;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class AddCommissionedEmployee extends AddEmployee {
    protected double salary = 0.0;
    protected double commissionRate = 0.0;

    public AddCommissionedEmployee(int empId, String empName, String empAddress, double salary, double commissionRate) {
        super(empId, empName, empAddress);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }


    @Override
    protected PaymentClassification makeClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new BiweeklySchedule();
    }
}
