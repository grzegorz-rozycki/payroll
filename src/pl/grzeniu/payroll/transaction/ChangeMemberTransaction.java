package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Affiliation;
import pl.grzeniu.payroll.Employee;
import pl.grzeniu.payroll.PayrollDatabase;
import pl.grzeniu.payroll.UnionAffiliation;

/**
 * Created by Grzegorz Różycki on 23.06.16
 */
public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

    protected final double dues;

    public ChangeMemberTransaction(int empId, int memberId, double dues) {
        super(empId, memberId);
        this.dues = dues;
    }

    @Override
    protected Affiliation getAffiliation() {
        return new UnionAffiliation(dues);
    }

    @Override
    protected void recordMembership(Employee employee) {
        PayrollDatabase.addUnionMember(memberId, employee);
    }
}
