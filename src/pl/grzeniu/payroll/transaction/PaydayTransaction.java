package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Paycheck;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 26.06.16.
 */
public class PaydayTransaction implements Transaction {

    protected final Date payDate;


    public PaydayTransaction(Date payDate) {
        this.payDate = payDate;
    }

    @Override
    public void execute() {

    }

    public Paycheck getPaycheck(final int employeeId) {
        return null;
    }
}
