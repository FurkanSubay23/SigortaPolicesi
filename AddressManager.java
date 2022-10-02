
public class AddressManager {
	public static void addList(User user, BusinessAddress businessAddress, HomeAddress homeAddress) {
		user.getAddress().add(homeAddress);
		user.getAddress().add(businessAddress);
		
		
	}

	public static void removeList(User user, Address address) {
		user.getAddress().remove(address);
	}
}
