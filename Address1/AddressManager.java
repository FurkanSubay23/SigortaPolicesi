package Address1;
import UserInfo.User;


public class AddressManager {
	
	
	public static void addList(User user, Address bussines1, Address home1) {
		user.getAddress().add(bussines1);
		user.getAddress().add(home1);
		
		
	}

	public static void removeList(User user, int index) {
		user.getAddress().remove(index);
	}
}
