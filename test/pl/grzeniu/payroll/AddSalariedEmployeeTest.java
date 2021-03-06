package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.classification.SalariedClassification;
import pl.grzeniu.payroll.method.HoldMethod;
import pl.grzeniu.payroll.schedule.MonthlySchedule;
import pl.grzeniu.payroll.transaction.AddSalariedEmployeeTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by grzechu on 08.05.16.
 */
public class AddSalariedEmployeeTest {

    @Test
    public void executeTest() {
        final int empId = 1;
        final AddSalariedEmployeeTransaction t = new AddSalariedEmployeeTransaction(empId, "Bob", "Home", 1000.00);

        t.execute();

        final Employee e = PayrollDatabase.getEmployee(empId);

        assertEquals("Name of employee is Bob", "Bob", e.name);
        assertTrue("Employee is a salaried employee", e.classification instanceof SalariedClassification);
        assertEquals("Salary is equal to 1000.00", 1000.00, ((SalariedClassification) e.classification).salary, 0.001);
        assertTrue("Payment schedule is monthly", e.schedule instanceof MonthlySchedule);
        assertTrue("Payment method is hold", e.method instanceof HoldMethod);
    }
}
