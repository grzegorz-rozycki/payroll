package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.transaction.AddCommissionedEmployee;
import pl.grzeniu.payroll.transaction.DeleteEmployee;
import pl.grzeniu.payroll.transaction.Transaction;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class DeleteEmployeeTest {

    @Test
    public void executeTest() {
        final int empId = 4;

        final Transaction t = new AddCommissionedEmployee(empId, "Bill", "Home", 2500, 3.2);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull("Employee should exists", e);

        final Transaction dt = new DeleteEmployee(empId);
        dt.execute();

        e = PayrollDatabase.getEmployee(empId);
        assertNull("Employee shouldn't exist now", e);
    }
}
