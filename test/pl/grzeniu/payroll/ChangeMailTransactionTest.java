package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.method.MailMethod;
import pl.grzeniu.payroll.transaction.AddSalariedEmployeeTransaction;
import pl.grzeniu.payroll.transaction.ChangeMailTransaction;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Grzegorz Różycki on 22.06.16
 */
public class ChangeMailTransactionTest {

    @Test
    public void executeTest() {
        final int empId = 13;
        // create new employee
        (new AddSalariedEmployeeTransaction(empId, "Bill", "Home", 1500.00)).execute();
        final Employee emp = PayrollDatabase.getEmployee(empId);

        assertNotNull("Employee should exist", emp);
        emp.method = null;  // base add employee transaction sets this by default to HoldMethod

        (new ChangeMailTransaction(empId)).execute();
        assertNotNull("Employee should have his payment method set", emp.method);
        assertTrue("Employee should have his payment method set to mail", (emp.method instanceof MailMethod));
    }
}
