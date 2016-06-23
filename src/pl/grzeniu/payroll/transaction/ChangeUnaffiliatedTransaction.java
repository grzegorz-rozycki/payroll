package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Affiliation;
import pl.grzeniu.payroll.NoAffiliation;

/**
 * Created by Grzegorz Różycki on 23.06.16
 */
public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {

    public ChangeUnaffiliatedTransaction(int empId) {
        super(empId);
    }

    @Override
    protected Affiliation getAffiliation() {
        return new NoAffiliation();
    }
}
