package pl.grzeniu.payroll.classification;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class CommissionedClassification extends PaymentClassification {
    public double salary = 0.0;
    public double commissionRate = 0.0;

    protected Map<Long, SalesReceipt> receipts = new HashMap<>();


    public CommissionedClassification(double salary, double commissionRate) {
        super();
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        receipts.put(salesReceipt.date.getTime(), salesReceipt);
    }

    public SalesReceipt getSalesReceipt(Date date) {
        return receipts.get(date.getTime());
    }
}
