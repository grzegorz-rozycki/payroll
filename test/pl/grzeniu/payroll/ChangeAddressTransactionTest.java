package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.transaction.AddHourlyEmployeeTransaction;
import pl.grzeniu.payroll.transaction.ChangeAddressTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by grzechu on 12.06.16.
 */
public class ChangeAddressTransactionTest {

    @Test
    public void executeTest() {
        final int empId = 100;
        final String newAddress = "Home Town";
        (new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25)).execute();
        (new ChangeAddressTransaction(empId, newAddress)).execute();

        final Employee emp = PayrollDatabase.getEmployee(empId);
        assertNotNull("Employee should exist", emp);
        assertEquals("Address should match", newAddress, emp.address);
    }
}
