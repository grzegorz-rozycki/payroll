package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.transaction.AddSalariedEmployeeTransaction;
import pl.grzeniu.payroll.transaction.PaydayTransaction;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Grzegorz Różycki on 26.06.16.
 */
public class PaySingleSalariedEmployeeTest {

    @Test
    public void payTest() {
        final int empId = 1;
        final Date payDate = new Date(2001, 11, 30);

        (new AddSalariedEmployeeTransaction(empId, "Bob", "Home", 1000.00)).execute();

        final PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();

        final Paycheck pc = pt.getPaycheck(empId);

        assertNotNull("A paycheck for the given employee should be created", pc);
        assertEquals("Pay dates should be equal", payDate, pc.payDate);
        assertEquals("Gross pay should equal", 1000.00, pc.grossPay, .001);
        assertEquals("Disposition should be Hold", "Hold", pc.getField("Disposition"));
        assertEquals("Deductions should equal", 0.0, pc.deductions, .001);
        assertEquals("Net pay should equal", 1000.00, pc.netPay, .001);
    }

    @Test
    public void payOnWrongDayTest() {
        final int empId = 1;
        final Date payDate = new Date(2001, 11, 29);
        (new AddSalariedEmployeeTransaction(empId, "Bob", "Home", 1000.00)).execute();

        final PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        final Paycheck pc = pt.getPaycheck(empId);
        assertNull("A paycheck for the given employee should not be created", pc);
    }
}
