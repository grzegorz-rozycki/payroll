package pl.grzeniu.payroll;

/**
 * Created by Grzegorz Różycki on 09.05.16
 */
public class Employee {
    public int id;
    public String name;
    public String address;
    public PaymentSchedule schedule;
    public PaymentClassification classification;
    public PaymentMethod method;


    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
