package pl.grzeniu.payroll.classification;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class CommissionedClassification extends PaymentClassification {
    public double salary = 0.0;
    public double commissionRate = 0.0;

    public CommissionedClassification(double salary, double commissionRate) {
        super();
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {

    }

    public SalesReceipt getSalesReceipt(Date date) {
        return null;
    }
}
