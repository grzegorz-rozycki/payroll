package pl.grzeniu.payroll.classification;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class CommissionedClassification extends PaymentClassification {
    public double salary = 0.0;
    public double commisionRate = 0.0;

    public CommissionedClassification(double salary, double commisionRate) {
        super();
        this.salary = salary;
        this.commisionRate = commisionRate;
    }
}
