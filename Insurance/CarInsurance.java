package Insurance;

import AccountManager.Account;
import AccountManager.*;

public class CarInsurance extends Insurance {

	public CarInsurance(Account insuranceName) {
		super(insuranceName);
		// TODO Auto-generated constructor stub
		this.setInsuranceName(getInsuranceName());
	}

	@Override
	public double calculate() {
		double price = 499.0;
		if (this.getAccount().getClass().getSimpleName().equals("Individual")) {
			this.setPrice(price);
			return this.getPrice();
		}
		this.setPrice(400.0);
		return this.getPrice();

	}

}
