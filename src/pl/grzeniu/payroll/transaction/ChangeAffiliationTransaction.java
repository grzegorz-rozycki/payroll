package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Affiliation;
import pl.grzeniu.payroll.Employee;

/**
 * Created by Grzegorz Różycki on 23.06.16
 */
public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {

    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee employee) {

    }

    protected abstract Affiliation getAffiliation();
}
