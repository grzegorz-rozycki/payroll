package pl.grzeniu.payroll;

/**
 * Created by Grzegorz Różycki on 08.05.16
 */
public class AddSalariedEmployee extends AddEmployee {
    protected double salary = 0.0;


    public AddSalariedEmployee(int empId, String empName, String empAddress, double salary) {
        super(empId, empName, empAddress);
        this.salary = salary;
    }


    @Override
    protected PaymentClassification makeClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new MonthlySchedule();
    }
}
