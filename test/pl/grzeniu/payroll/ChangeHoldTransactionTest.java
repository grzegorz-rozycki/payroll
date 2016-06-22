package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.method.HoldMethod;
import pl.grzeniu.payroll.transaction.AddSalariedEmployeeTransaction;
import pl.grzeniu.payroll.transaction.ChangeHoldTransaction;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Grzegorz Różycki on 22.06.16
 */
public class ChangeHoldTransactionTest {

    @Test
    public void executeTest() {
        final int empId = 12;
        // create new employee
        (new AddSalariedEmployeeTransaction(empId, "Bill", "Home", 1500.00)).execute();
        final Employee emp = PayrollDatabase.getEmployee(empId);

        assertNotNull("Employee should exist", emp);
        emp.method = null;  // base add employee transaction sets this by default to HoldMethod

        (new ChangeHoldTransaction(empId)).execute();
        assertNotNull("Employee should have his payment method set", emp.method);
        assertTrue("Employee should have his payment method set to hold", (emp.method instanceof HoldMethod));
    }
}
