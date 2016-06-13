package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.classification.PaymentClassification;
import pl.grzeniu.payroll.classification.SalariedClassification;
import pl.grzeniu.payroll.schedule.MonthlySchedule;
import pl.grzeniu.payroll.transaction.AddHourlyEmployeeTransaction;
import pl.grzeniu.payroll.transaction.ChangeSalariedTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Grzegorz Różycki on 13.06.16
 */
public class ChangeSalariedTransactionTest {

    @Test
    public void executeTest() {
        final int empId = 7;
        final double salary = 1500.00;
        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 12.75)).execute();
        (new ChangeSalariedTransaction(empId, salary)).execute();

        final Employee e = PayrollDatabase.getEmployee(empId);

        assertNotNull("Employee should exist", e);
        final PaymentClassification pc = e.classification;

        assertNotNull(pc);
        assertTrue("Employee is salaried", (pc instanceof SalariedClassification));

        final SalariedClassification hc = (SalariedClassification) pc;
        assertEquals("Salary should match", salary, hc.salary, .001);
        assertTrue("Payment schedule should be monthly", (e.schedule instanceof MonthlySchedule));
    }
}
