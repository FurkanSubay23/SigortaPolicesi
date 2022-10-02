
public class HomeAddress implements Address {
private String adress;

	public HomeAddress(String adress) {
	super();
	this.adress = adress;
}
	@Override
	public String getAddress() {		
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	
}
