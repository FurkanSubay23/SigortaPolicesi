package Address1;

public class BusinessAddress implements Address {
	private String addressString;

	public BusinessAddress(String addressString) {
		super();
		this.addressString = addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return this.addressString;
	}

}
