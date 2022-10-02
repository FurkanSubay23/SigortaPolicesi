package Insurance;

import AccountManager.Account;
import AccountManager.*;

public class ResidenceInsurance extends Insurance {

	public ResidenceInsurance(Account insuranceName) {
		super(insuranceName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate() {
		double price = 750.0;
		if (this.getAccount().getClass().getName().equals("Individual")) {
			this.setPrice(price);
			return this.getPrice();
		}
		this.setPrice(600);
		return this.getPrice();
	}

}
