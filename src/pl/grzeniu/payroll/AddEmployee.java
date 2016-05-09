package pl.grzeniu.payroll;

/**
 * Created by Grzegorz Różycki on 09.05.16
 */
public abstract class AddEmployee implements Transaction {
    protected int empId;
    protected String empName;
    protected String empAddress;


    public AddEmployee(int empId, String empName, String empAddress) {
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
