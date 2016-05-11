package pl.grzeniu.payroll.classification;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class HourlyClassification extends PaymentClassification {
    public double hourlyRate = 0.0;

    public HourlyClassification(double hourlyRate) {
        super();
        this.hourlyRate = hourlyRate;
    }
}
