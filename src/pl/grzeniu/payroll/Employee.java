package pl.grzeniu.payroll;

import pl.grzeniu.payroll.classification.PaymentClassification;
import pl.grzeniu.payroll.method.PaymentMethod;
import pl.grzeniu.payroll.schedule.PaymentSchedule;

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
    public Affiliation affiliation;


    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
