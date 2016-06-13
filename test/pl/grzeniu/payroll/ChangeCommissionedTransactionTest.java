package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.classification.CommissionedClassification;
import pl.grzeniu.payroll.classification.PaymentClassification;
import pl.grzeniu.payroll.schedule.BiweeklySchedule;
import pl.grzeniu.payroll.transaction.AddHourlyEmployeeTransaction;
import pl.grzeniu.payroll.transaction.ChangeCommissionedTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Grzegorz Różycki on 13.06.16
 */
public class ChangeCommissionedTransactionTest {

    @Test
    public void executeTest() {
        final int empId = 8;
        final double salary = 1500.00;
        final double commissionRate = 50.00;

        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 12.75)).execute();
        (new ChangeCommissionedTransaction(empId, salary, commissionRate)).execute();

        final Employee e = PayrollDatabase.getEmployee(empId);

        assertNotNull("Employee should exist", e);
        final PaymentClassification pc = e.classification;

        assertNotNull(pc);
        assertTrue("Employee is commissioned", (pc instanceof CommissionedClassification));

        final CommissionedClassification hc = (CommissionedClassification) pc;
        assertEquals("Salary should match", salary, hc.salary, .001);
        assertEquals("Commission rate should match", commissionRate, hc.commissionRate, .001);
        assertTrue("Payment schedule should be biweekly", (e.schedule instanceof BiweeklySchedule));
    }
}
