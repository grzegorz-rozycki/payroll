package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Affiliation;
import pl.grzeniu.payroll.Employee;

/**
 * Created by Grzegorz Różycki on 23.06.16
 */
public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {

    protected final int memberId;

    public ChangeAffiliationTransaction(int empId, int memberId) {
        super(empId);
        this.memberId = memberId;
    }

    @Override
    protected void change(Employee employee) {
        employee.affiliation = getAffiliation();
        recordMembership(employee);
    }

    protected abstract Affiliation getAffiliation();

    protected abstract void recordMembership(Employee employee);
}
