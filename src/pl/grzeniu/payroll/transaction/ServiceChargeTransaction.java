package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Employee;
import pl.grzeniu.payroll.PayrollDatabase;
import pl.grzeniu.payroll.UnionAffiliation;

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
        final Employee emp = PayrollDatabase.getUnionMember(memberId);

        if (emp == null) {
            throw new InvalidOperationException("No such union member");
        }

        if (!(emp.affiliation instanceof UnionAffiliation)) {
            throw new InvalidOperationException("Employee has no union affiliation");
        }

        final UnionAffiliation ua = (UnionAffiliation) emp.affiliation;
        ua.addServiceCharge(chargeDate, chargeAmount);
    }
}
