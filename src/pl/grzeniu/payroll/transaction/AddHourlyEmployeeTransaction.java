package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.classification.HourlyClassification;
import pl.grzeniu.payroll.classification.PaymentClassification;
import pl.grzeniu.payroll.schedule.PaymentSchedule;
import pl.grzeniu.payroll.schedule.WeeklySchedule;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction {
    protected double hourlyRate = 0.0;

    public AddHourlyEmployeeTransaction(int empId, String empName, String empAddress, double hourlyRate) {
        super(empId, empName, empAddress);
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected PaymentClassification makeClassification() {
        return new HourlyClassification(hourlyRate);
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new WeeklySchedule();
    }
}
