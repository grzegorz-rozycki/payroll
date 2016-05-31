package pl.grzeniu.payroll;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 17.05.16
 */
public class ServiceCharge {
    public double amount = 0.0;
    public Date date = null;

    public ServiceCharge(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

}
