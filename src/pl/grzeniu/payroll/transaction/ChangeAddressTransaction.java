package pl.grzeniu.payroll.transaction;

import pl.grzeniu.payroll.Employee;

/**
 * Created by grzechu on 12.06.16.
 */
public class ChangeAddressTransaction extends ChangeEmployeeTransaction {
    protected final String newAddress;

    public ChangeAddressTransaction(int empId, String newAddress) {
        super(empId);
        this.newAddress = newAddress;
    }

    @Override
    protected void change(Employee employee) {
        employee.address = newAddress;
    }
}
