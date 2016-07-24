package pl.grzeniu.payroll.classification;

import pl.grzeniu.payroll.Paycheck;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class SalariedClassification extends PaymentClassification {
    public double salary = 0.0;


    public SalariedClassification(double salary) {
        super();
        this.salary = salary;
    }

    @Override
    public double calculatePay(Paycheck paycheck) {
        return salary;
    }
}
