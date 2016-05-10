package pl.grzeniu.payroll;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class SalariedClassification extends PaymentClassification {
    protected double salary = 0.0;


    public SalariedClassification(double salary) {
        super();
        this.salary = salary;
    }
}
