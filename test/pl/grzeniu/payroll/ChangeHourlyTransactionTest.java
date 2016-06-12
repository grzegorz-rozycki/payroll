package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.classification.HourlyClassification;
import pl.grzeniu.payroll.classification.PaymentClassification;
import pl.grzeniu.payroll.schedule.WeeklySchedule;
import pl.grzeniu.payroll.transaction.AddCommissionedEmployeeTransaction;
import pl.grzeniu.payroll.transaction.ChangeHourlyTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by grzechu on 12.06.16.
 */
public class ChangeHourlyTransactionTest {
    @Test
    public void executeTest() {
        final int empId = 3;
        (new AddCommissionedEmployeeTransaction(empId, "Lance", "Home", 2500, 3.2)).execute();
        (new ChangeHourlyTransaction(empId, 27.52)).execute();
        final Employee e = PayrollDatabase.getEmployee(empId);

        assertNotNull("Employee should exist", e);
        final PaymentClassification pc = e.classification;

        assertNotNull(pc);
        assertTrue("Employee is hourly", (pc instanceof HourlyClassification));

        final HourlyClassification hc = (HourlyClassification) pc;
        assertEquals("Hourly rate should match", 27.52, hc.hourlyRate, .001);
        assertTrue("Payment schedule should be weekly", (e.schedule instanceof WeeklySchedule));
    }
}
