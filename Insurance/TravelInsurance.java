package Insurance;

import AccountManager.Account;
import AccountManager.*;

public class TravelInsurance extends Insurance {

	public TravelInsurance(Account insuranceName) {
		super(insuranceName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate() {
		double price = 1000.0;
		if (this.getAccount().getClass().getName().equals("Individual")) {
			this.setPrice(price);
			return this.getPrice();
		}
		this.setPrice(850);
		return this.getPrice();
	}

}
