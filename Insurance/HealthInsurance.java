package Insurance;

import AccountManager.Account;
import AccountManager.*;

public class HealthInsurance extends Insurance {

	public HealthInsurance(Account insuranceName) {
		super(insuranceName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate() {
		double price = 250.0;
		if (this.getAccount().getClass().getName().equals("Individual")) {
			this.setPrice(price);
			return this.getPrice();
		}
		this.setPrice(200);
		return this.getPrice();
	}

}
