package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.classification.HourlyClassification;
import pl.grzeniu.payroll.classification.PaymentClassification;
import pl.grzeniu.payroll.schedule.PaymentSchedule;
import pl.grzeniu.payroll.schedule.WeeklySchedule;

/**
 * Created by grzechu on 12.06.16.
 */
public class ChangeHourlyTransaction extends ChangeClassificationTransaction {
    protected final double hourlyRate;


    public ChangeHourlyTransaction(int empId, double hourlyRate) {
        super(empId);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(hourlyRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}
