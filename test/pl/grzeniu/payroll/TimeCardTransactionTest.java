package pl.grzeniu.payroll;


import org.junit.Test;
import pl.grzeniu.payroll.classification.HourlyClassification;
import pl.grzeniu.payroll.classification.PaymentClassification;
import pl.grzeniu.payroll.transaction.AddHourlyEmployee;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Grzegorz Różycki on 11.05.16
 */
public class TimeCardTransactionTest {
    @Test
    public void testTransaction() {
        final int empId = 5;

        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        TimeCardTransaction tct = new TimeCardTransaction(new Date(2005, 7, 31), 8.0, empId);
        tct.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        PaymentClassification pc = e.classification;
        assertTrue(pc instanceof HourlyClassification);

        HourlyClassification hc = (HourlyClassification) pc;
        TimeCard tc = hc.getTimeCard(new Date(2005, 7, 31));

        assertNotNull(tc);
        assertEquals(8.0, tc.hours);
    }
}
