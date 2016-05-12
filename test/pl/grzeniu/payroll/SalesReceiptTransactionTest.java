package pl.grzeniu.payroll;

import org.junit.Test;
import pl.grzeniu.payroll.classification.CommissionedClassification;
import pl.grzeniu.payroll.classification.SalesReceipt;
import pl.grzeniu.payroll.transaction.AddCommissionedEmployeeTransaction;
import pl.grzeniu.payroll.transaction.SalesReceiptTransaction;
import pl.grzeniu.payroll.transaction.Transaction;

import java.util.Date;

import static junit.framework.Assert.*;

/**
 * Created by Grzegorz Różycki on 12.05.16
 */
public class SalesReceiptTransactionTest {
    private final int empId = 10;

    @Test
    public void executeTest() {
        Transaction t = new AddCommissionedEmployeeTransaction(empId, "Bob", "Home", 1500.00, 50.00);
        Employee emp = PayrollDatabase.getEmployee(empId);

        assertNull("Employee shouldn't exist", emp);

        t.execute();

        emp = PayrollDatabase.getEmployee(empId);
        assertNotNull("Employee should exist", emp);
        assertTrue("Employee should be commissioned", (emp.classification instanceof CommissionedClassification));

        final Date date = new Date(2014, 4, 11);
        final int amount = 10;
        t = new SalesReceiptTransaction(date, amount, empId);
        t.execute();

        SalesReceipt sr = ((CommissionedClassification) emp.classification).getSalesReceipt(date);
        assertNotNull("Should find a receipt", sr);
        assertEquals("Should have right amount", sr.getAmount(), amount);
    }
}
