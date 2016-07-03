package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.transaction.AddHourlyEmployeeTransaction;
import pl.grzeniu.payroll.transaction.PaydayTransaction;
import pl.grzeniu.payroll.transaction.TimeCardTransaction;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by grzechu on 03.07.16.
 */
public class PaySingleHourlyEmployeeTest {

    @Test
    public void testNoTimeCards()
    {
        final int empId = 2;
        final Date payDate = new Date(2001, 11, 9);
        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25)).execute();
        final PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        ValidateHourlyPaycheck(pt, empId, payDate, 0.0);
    }

    @Test
    public void testOneTimeCard()
    {
        final int empId = 2;
        final Date payDate = new Date(2001, 11, 9); // Friday
        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25)).execute();
        (new TimeCardTransaction(empId, payDate, 2.0)).execute();
        final PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        ValidateHourlyPaycheck(pt, empId, payDate, 30.5);
    }

    @Test
    public void testPayOvertimeOneTimeCard()
    {
        final int empId = 2;
        final Date payDate = new Date(2001, 11, 9); // Friday
        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25)).execute();
        (new TimeCardTransaction(empId, payDate, 9.0)).execute();

        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        ValidateHourlyPaycheck(pt, empId, payDate, (8 + 1.5) * 15.25);
    }

    private void ValidateHourlyPaycheck(PaydayTransaction pt, int empId, Date payDate, double pay)
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
