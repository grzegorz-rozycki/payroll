package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Affiliation;
import pl.grzeniu.payroll.UnionAffiliation;

/**
 * Created by Grzegorz Różycki on 23.06.16
 */
public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

    public ChangeMemberTransaction(int empId, int memberId, double dues) {
        super(empId);
    }

    @Override
    protected Affiliation getAffiliation() {
        return new UnionAffiliation();
    }
}
