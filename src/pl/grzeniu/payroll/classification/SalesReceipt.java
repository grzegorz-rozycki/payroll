package pl.grzeniu.payroll.classification;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 12.05.16
 */
public class SalesReceipt {
    protected Date date = null;
    protected int amount = 0;


    public SalesReceipt(Date date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
}
