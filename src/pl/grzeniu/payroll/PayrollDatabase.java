package pl.grzeniu.payroll;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grzegorz Różycki on 09.05.16
 */
public class PayrollDatabase {
    protected static List<Employee> employees = new ArrayList<>();


    public static void addEmployee(int id, Employee emp) {
        employees.add(id, emp);
    }

    public static Employee getEmployee(int id) {
        return employees.get(id);
    }
}
