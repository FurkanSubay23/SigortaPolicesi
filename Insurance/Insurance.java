package Insurance;

import java.util.Date;

import AccountManager.Account;

public abstract class Insurance {
	private String insuranceName;
	private double price;
	private Date startdDate;
	private Date endOfDate;
	private Account account;

	public Insurance(Account account) {
		super();
		this.account = account;

	}

	public abstract double calculate();

	public String getInsuranceName() {
		return this.getClass().getSimpleName();
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getStartdDate() {
		return startdDate;
	}

	public void setStartdDate(Date startdDate) {
		this.startdDate = startdDate;
	}

	public Date getEndOfDate() {
		return endOfDate;
	}

	public void setEndOfDate(Date endOfDate) {
		this.endOfDate = endOfDate;
	}

	public Account getAccount() {
		return account;
	}
	

	public void setAccount(Account account) {
		this.account = account;
	}

}
