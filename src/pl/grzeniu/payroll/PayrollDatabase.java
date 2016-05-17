package pl.grzeniu.payroll;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grzegorz Różycki on 09.05.16
 */
public class PayrollDatabase {
    protected static Map<Integer, Employee> employees = new HashMap<>();


    public static void addEmployee(int id, Employee emp) {
        employees.put(id, emp);
    }

    public static Employee getEmployee(int id) {
        return employees.get(id);
    }

    public static void deleteEmployee(int id) {
        employees.remove(id);
    }

    public static void addUnionMember(int unionId, Employee employee) {

    }
}
