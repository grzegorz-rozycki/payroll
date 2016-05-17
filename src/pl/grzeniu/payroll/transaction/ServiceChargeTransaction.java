package pl.grzeniu.payroll.transaction;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 17.05.16
 */
public class ServiceChargeTransaction implements Transaction {
    protected final int memberId;
    protected final Date chargeDate;
    protected final double chargeAmount;


    public ServiceChargeTransaction(int memberId, Date chargeDate, double chargeAmount) {
        this.memberId = memberId;
        this.chargeDate = chargeDate;
        this.chargeAmount = chargeAmount;
    }

    @Override
    public void execute() {

    }
}
