package pl.grzeniu.payroll.transaction;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 12.05.16
 */
public class SalesReceiptTransaction implements Transaction {
    protected Date date = null;
    protected int amount = 0;
    protected int empId = 0;


    public SalesReceiptTransaction(Date date, int amount, int empId) {
        this.date = date;
        this.amount = amount;
        this.empId = empId;
    }

    @Override
    public void execute() {

    }
}
