package pl.grzeniu.payroll;

import pl.grzeniu.payroll.classification.PaymentClassification;
import pl.grzeniu.payroll.method.PaymentMethod;
import pl.grzeniu.payroll.schedule.PaymentSchedule;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 09.05.16
 */
public class Employee {
    public int id;
    public String name;
    public String address;
    public PaymentSchedule schedule;
    public PaymentClassification classification;
    public PaymentMethod method;
    public Affiliation affiliation;


    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.affiliation = new NoAffiliation();
    }

    public boolean isPayDate(Date date) {
        return this.schedule.isPayDate(date);
    }

    public Date getPayPeriodStartDate(Date payDate) {
        return schedule.getPayPeriodStart(payDate);
    }

    public void payday(Paycheck paycheck) {
        final double grossPay = classification.calculatePay(paycheck);
        final double deductions = affiliation.calculateDeductions(paycheck);
        final double netPay = grossPay - deductions;
        paycheck.grossPay = grossPay;
        paycheck.deductions = deductions;
        paycheck.netPay = netPay;
        method.pay(paycheck);
    }
}
