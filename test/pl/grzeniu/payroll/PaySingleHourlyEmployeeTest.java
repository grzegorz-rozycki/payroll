package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.transaction.AddHourlyEmployeeTransaction;
import pl.grzeniu.payroll.transaction.PaydayTransaction;
import pl.grzeniu.payroll.transaction.TimeCardTransaction;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by grzechu on 03.07.16.
 */
public class PaySingleHourlyEmployeeTest {

    @Test
    public void testNoTimeCards()
    {
        final int empId = 2;
        final Date payDate = DateHelper.makeDate(2011, 10, 11); // Friday → 2011-11-11
        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25)).execute();
        final PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        validateHourlyPaycheck(pt, empId, payDate, 0.0);
    }

    @Test
    public void testOneTimeCard()
    {
        final int empId = 2;
        final Date payDate = DateHelper.makeDate(2011, 10, 11); // Friday → 2011-11-11
        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25)).execute();
        (new TimeCardTransaction(empId, payDate, 2.0)).execute();
        final PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        validateHourlyPaycheck(pt, empId, payDate, 30.5);
    }

    @Test
    public void testPayOvertimeOneTimeCard()
    {
        final int empId = 2;
        final Date payDate = DateHelper.makeDate(2011, 10, 11); // Friday → 2011-11-11
        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25)).execute();
        (new TimeCardTransaction(empId, payDate, 9.0)).execute();

        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        validateHourlyPaycheck(pt, empId, payDate, (8 + 1.5) * 15.25);
    }

    @Test
    public void testPayOnWrongDate() {
        final int empId = 2;
        final Date payDate = DateHelper.makeDate(2011, 10, 10); // Thursday → 2011-11-10

        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25)).execute();
        (new TimeCardTransaction(empId, payDate, 9.0)).execute();

        final PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        Paycheck pc = pt.getPaycheck(empId);
        assertNull(pc);
    }

    @Test
    public void testPayTwoTimeCards() {
        final int empId = 2;

        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25)).execute();
        final Date payDate1 = DateHelper.makeDate(2011, 10, 11); // Friday → 2011-11-11
        final Date payDate2 = DateHelper.makeDate(2011, 10, 10); // Thursday → 2011-11-10

        (new TimeCardTransaction(empId, payDate1, 2.0)).execute();
        (new TimeCardTransaction(empId, payDate2, 5.0)).execute();

        final PaydayTransaction pt = new PaydayTransaction(payDate1);
        pt.execute();

        validateHourlyPaycheck(pt, empId, payDate1, 7 * 15.25);
    }

    @Test
    public void testPayWithTimeCardsSpanningTwoPayPeriods() {
        final int empId = 2;
        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25)).execute();
        final Date payDate = DateHelper.makeDate(2011, 10, 11); // Friday → 2011-11-11
        final Date dateInPreviousPayPeriod = DateHelper.makeDate(2011, 10, 4); // Friday → 2011-11-04
        (new TimeCardTransaction(empId, payDate, 2.0)).execute();
        (new TimeCardTransaction(empId, dateInPreviousPayPeriod, 5.0)).execute();

        final PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        validateHourlyPaycheck(pt, empId, payDate, 2 * 15.25);
    }

    private void validateHourlyPaycheck(PaydayTransaction pt, int empId, Date payDate, double pay)
    {
        Paycheck pc = pt.getPaycheck(empId);
        assertNotNull("Paycheck should be assigned", pc);
        assertEquals("Pay dates are equal", payDate, pc.payDate);
        assertEquals("Gross pay is equal", pay, pc.grossPay, .001);
        assertEquals("Pay disposition is set to Hold", "Hold", pc.getField("Disposition"));
        assertEquals("Deductions are zero", 0.0, pc.deductions, .001);
        assertEquals("Net pay is equal", pay, pc.netPay, .001);
    }
}
