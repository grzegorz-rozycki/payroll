package pl.grzeniu.payroll;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Grzegorz Różycki on 09.05.16
 */
public class PayrollDatabase {
    protected static Map<Integer, Employee> employees = new HashMap<>();
    protected static Map<Integer, Integer> unionMembers = new HashMap<>();


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
        unionMembers.put(unionId, employee.id);
    }

    public static Employee getUnionMember(int unionId) {
        final Integer empId = unionMembers.get(unionId);

        return (empId != null ? employees.get(empId) : null);
    }
}
