package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Affiliation;
import pl.grzeniu.payroll.Employee;
import pl.grzeniu.payroll.NoAffiliation;
import pl.grzeniu.payroll.PayrollDatabase;

/**
 * Created by Grzegorz Różycki on 23.06.16
 */
public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {

    public ChangeUnaffiliatedTransaction(int empId, int memberId) {
        super(empId, memberId);
    }

    @Override
    protected Affiliation getAffiliation() {
        return new NoAffiliation();
    }

    @Override
    protected void recordMembership(Employee employee) {
        PayrollDatabase.deleteUnionMember(memberId);
    }
}
