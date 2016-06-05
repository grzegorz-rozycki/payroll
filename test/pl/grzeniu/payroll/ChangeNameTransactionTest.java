package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.transaction.AddHourlyEmployeeTransaction;
import pl.grzeniu.payroll.transaction.ChangeNameTransaction;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Grzegorz Różycki on 05.06.16
 */
public class ChangeNameTransactionTest {

    @Test
    public void executeTest() {
        final int empId = 2;
        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25)).execute();
        (new ChangeNameTransaction(empId, "Bob")).execute();
        final Employee emp = PayrollDatabase.getEmployee(empId);

        assertNotNull("Employee with given id should exist", emp);
        assertEquals("Employee's name should be Bob", "Bob", emp.name);
    }
}
