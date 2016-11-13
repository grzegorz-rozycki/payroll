package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.transaction.*;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class UnionAffiliationPaymentsTest {
    @Test
    public void hourlyUnionMemberServiceCharge() {
        final int empId = 1;
        final int memberId = 7734;
        final Date payDate = DateHelper.makeDate(2001, 10, 9);

        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.24)).execute();
        (new ChangeMemberTransaction(empId, memberId, 9.42)).execute();
        (new ServiceChargeTransaction(memberId, payDate, 19.42)).execute();
        (new TimeCardTransaction(empId, payDate, 8.0)).execute();

        final PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        final Paycheck pc = pt.getPaycheck(empId);

        assertNotNull(pc);
        assertEquals(payDate, pc.payPeriodEnd);
        assertEquals(8 * 15.24, pc.grossPay, 0.001);
        assertEquals("Hold", pc.getField("Disposition"));
        assertEquals(9.42 + 19.42, pc.deductions, 0.001);
        assertEquals((8 * 15.24) - (9.42 + 19.42), pc.netPay, 0.001);
    }

    @Test
    public void serviceChargesSpanningMultiplePayPeriods() {
        final int empId = 1;
        final int memberId = 7734;
        final Date payDate = DateHelper.makeDate(2001, 10, 9);
        final Date earlyDate = DateHelper.makeDate(2001, 10, 2); // previous Friday
        final Date lateDate = DateHelper.makeDate(2001, 10, 16); // next Friday

        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.24)).execute();
        (new ChangeMemberTransaction(empId, memberId, 9.42)).execute();
        (new ServiceChargeTransaction(memberId, payDate, 19.42)).execute();
        (new ServiceChargeTransaction(memberId,earlyDate,100.00)).execute();
        (new ServiceChargeTransaction(memberId,lateDate,200.00)).execute();
        (new TimeCardTransaction(empId, payDate, 8.0)).execute();

        final PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        final Paycheck pc = pt.getPaycheck(empId);

        assertNotNull(pc);
        assertEquals(payDate, pc.payPeriodEnd);
        assertEquals(8 * 15.24, pc.grossPay, 0.001);
        assertEquals("Hold", pc.getField("Disposition"));
        assertEquals(9.42 + 19.42, pc.deductions, 0.001);
        assertEquals((8 * 15.24) - (9.42 + 19.42), pc.netPay, 0.001);
    }
}
