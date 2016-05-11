package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Employee;
import pl.grzeniu.payroll.PayrollDatabase;
import pl.grzeniu.payroll.classification.HourlyClassification;
import pl.grzeniu.payroll.classification.TimeCard;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 11.05.16
 */
public class TimeCardTransaction implements Transaction {
    protected Date date;
    protected double hours;
    protected int empId;


    public TimeCardTransaction(int empId, Date date, double hours) {
        this.empId = empId;
        this.date = date;
        this.hours = hours;
    }

    @Override
    public void execute() {
        final Employee emp = PayrollDatabase.getEmployee(empId);

        if (emp == null) {
            throw new InvalidOperationException("No such employee");
        }

        if (!(emp.classification instanceof HourlyClassification)) {
            throw new InvalidOperationException("Tried to add timecard to non-hourly employee");
        }

        ((HourlyClassification) emp.classification).addTimeCard(new TimeCard(date, hours));
    }
}
