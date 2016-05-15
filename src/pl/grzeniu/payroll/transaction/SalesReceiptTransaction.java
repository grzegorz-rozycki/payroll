package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Employee;
import pl.grzeniu.payroll.PayrollDatabase;
import pl.grzeniu.payroll.classification.CommissionedClassification;
import pl.grzeniu.payroll.classification.SalesReceipt;

import java.util.Date;

/**
 * Created by Grzegorz Różycki on 12.05.16
 */
public class SalesReceiptTransaction implements Transaction {
    protected Date date = null;
    protected int amount = 0;
    protected int empId = 0;


    public SalesReceiptTransaction(Date date, int amount, int empId) {
        this.date = date;
        this.amount = amount;
        this.empId = empId;
    }

    @Override
    public void execute() {
        final Employee employee = PayrollDatabase.getEmployee(empId);

        if (employee == null) {
            throw new InvalidOperationException("No such employee");
        }

        if (!(employee.classification instanceof CommissionedClassification)) {
            throw new InvalidOperationException("Employee isn't commissioned");
        }

        final SalesReceipt receipt = new SalesReceipt(date, amount);
        ((CommissionedClassification) employee.classification).addSalesReceipt(receipt);
    }
}
