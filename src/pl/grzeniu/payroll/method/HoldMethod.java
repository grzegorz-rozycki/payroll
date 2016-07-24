package pl.grzeniu.payroll.method;

import pl.grzeniu.payroll.Paycheck;

/**
 * Created by Grzegorz Różycki on 10.05.16
 */
public class HoldMethod extends PaymentMethod {

    @Override
    public void pay(Paycheck paycheck) {
        paycheck.setField("Disposition", "Hold");
    }
}
