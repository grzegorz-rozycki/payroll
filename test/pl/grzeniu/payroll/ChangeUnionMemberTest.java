package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.transaction.AddHourlyEmployeeTransaction;
import pl.grzeniu.payroll.transaction.ChangeMemberTransaction;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by Grzegorz Różycki on 23.06.16
 */
public class ChangeUnionMemberTest {
    @Test
    public void executeTest() {
        final int memberId = 7743;
        final int empId = 8;

        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25)).execute();
        (new ChangeMemberTransaction(empId, memberId, 99.42)).execute();

        Employee emp = PayrollDatabase.getEmployee(empId);
        assertNotNull(emp);

        Affiliation affiliation = emp.affiliation;
        assertNotNull(affiliation);
        assertTrue(affiliation instanceof UnionAffiliation);

        UnionAffiliation uf = (UnionAffiliation) affiliation;
        assertEquals(99.42, uf.dues, .001);

        Employee member = PayrollDatabase.getUnionMember(memberId);
        assertNotNull(member);
        assertEquals(emp, member);
    }
}
