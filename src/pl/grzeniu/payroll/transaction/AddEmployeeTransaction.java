package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Employee;
import pl.grzeniu.payroll.PayrollDatabase;
import pl.grzeniu.payroll.classification.PaymentClassification;
import pl.grzeniu.payroll.method.HoldMethod;
import pl.grzeniu.payroll.method.PaymentMethod;
import pl.grzeniu.payroll.schedule.PaymentSchedule;

/**
 * Created by Grzegorz Różycki on 09.05.16
 */
public abstract class AddEmployeeTransaction implements Transaction {
    protected int empId;
    protected String empName;
    protected String empAddress;


    public AddEmployeeTransaction(int empId, String empName, String empAddress) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
    }

    @Override
    public void execute() {
        PaymentClassification pc = makeClassification();
        PaymentSchedule ps = makeSchedule();
        PaymentMethod pm = new HoldMethod();

        Employee emp = new Employee(empId, empName, empAddress);
        emp.classification = pc;
        emp.schedule = ps;
        emp.method = pm;

        PayrollDatabase.addEmployee(empId, emp);
    }


    protected abstract PaymentClassification makeClassification();

    protected abstract PaymentSchedule makeSchedule();

}
