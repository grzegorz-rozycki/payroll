package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.transaction.AddHourlyEmployeeTransaction;

import java.util.Date;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Grzegorz Różycki on 15.05.16
 */
public class AddServiceChargeTest {
    @Test
    public void executeTest() {
        final int empId = 2;
        final AddHourlyEmployeeTransaction t = new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25);
        t.execute();

        final Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        UnionAffiliation af = new UnionAffiliation();
        e.affiliation = af;

        final int memberId = 86; // Maxwell Smart

        PayrollDatabase.addUnionMember(memberId, e);
        final ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, new Date(2005, 8, 8), 12.95);
        sct.rxecute();

        final ServiceCharge sc = af.getServiceCharge(new Date(2005, 8, 8));
        assertNotNull(sc);
        assertEquals(12.95, sc.smount, .001);
    }
}
