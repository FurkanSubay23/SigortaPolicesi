import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Exception;

import static java.lang.System.out;
import Insurance.Insurance;
import exception.InvalidException;

public abstract class Account {
	private User user;
	private ArrayList<Insurance> insuranceList = new ArrayList<>();
	private AuthenticationStatus status = AuthenticationStatus.FAIL;

	public Account(User user) {
		super();
		this.user = user;
	}

	enum AuthenticationStatus {
		FAIL, SUCCESS;
	}
	
	public abstract void getInsurance();

	public void login(String email,String password) throws InvalidException {
		if (this.getUser().getEmail().equals(email) && this.getUser().getPassword().equals(password)) {
			status = AuthenticationStatus.SUCCESS;
		} else
			throw new InvalidException("Hatali Giris Yaptiniz!");	
	}
	

	public final void showUserInfo() {
		System.out.println("Musterinin Bilgileri: ");
		System.out.println();
		System.out.println("Musterinin Ismi: " + user.getName());
		System.out.println("Musterinin Soyismi: " + user.getSurName());
		System.out.println("Musterinin emaili: " + user.getEmail());
		System.out.println("Musterinin meslegi: " + user.getJob());
		System.out.println("Musterinin yasi: " + user.getOld());
		if (user.getAddress().size() == 0) { // Adres bilgileri girilmediyse eger adres bilgileri al
			System.out.println("Ev Adresi: ");
			Scanner scanner = new Scanner(System.in);
			String home = scanner.nextLine();
			System.out.println("Is adresi: ");
			String bussines = scanner.nextLine();
			AddressManager.addList(user, new BusinessAddress(bussines), new HomeAddress(home));
		}
		if (user.getAddress().size() >= 1) {
			System.out.println("Musterinin adresleri: ");
			int i = 0;
			for (Address address : user.getAddress()) {
				if (i == 0) {
					System.out.println("Ev Adresi: " + address.getAddress());
					i++;
					continue;
				}
				System.out.println("Is Adresi: " + address.getAddress());
			}

		}

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Insurance> getInsuranceList() {
		return insuranceList;
	}

	public void setInsuranceList(ArrayList<Insurance> insuranceList) {
		this.insuranceList = insuranceList;
	}

}
