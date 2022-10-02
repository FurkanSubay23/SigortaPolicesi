package AccountManager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import Address1.*;
import Address1.BusinessAddress;
import Address1.HomeAddress;
import java.lang.Exception;
import UserInfo.User;
import static java.lang.System.out;

import Insurance.CarInsurance;
import Insurance.HealthInsurance;
import Insurance.Insurance;
import Insurance.ResidenceInsurance;
import Insurance.TravelInsurance;
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

	/*
	 * @Override public int compareTo(Account o) { if (!(o instanceof Account)) {
	 * return -1; } return this.hashCode() - o.hashCode(); }
	 */
	public void login(String email, String password) throws InvalidException {
		if (this.getUser().getEmail().equals(email) && this.getUser().getPassword().equals(password)) {
			status = AuthenticationStatus.SUCCESS;
		} else
			throw new InvalidException("Hatali Giris Yaptiniz!");
	}

	public void printInsurance() {
		Scanner scanner = new Scanner(System.in);
		for (Insurance insurance : getInsuranceList()) {
			System.out.println(insurance.getClass().getSimpleName().toString());
			System.out.println("Policenizin Fiyati: " + insurance.calculate());
			System.out.println();
		}
		System.out.println("Police silmek istiyor musunuz");
		System.out.println("1 - Evet");
		System.out.println("2 - Hayir");
		int number = scanner.nextInt();
		if (number == 1) {
			for (int i = 0; i < getInsuranceList().size(); i++) {
				System.out.println(i + 1 + " " + getInsuranceList().get(i).getClass().getSimpleName());
			}
			System.out.println("Silmek istediginiz policenin no sunu giriniz");
			int remove = scanner.nextInt();
			System.out.println("Sildiginiz policenin ismi" + getInsuranceList().get(remove - 1).getClass().getSimpleName());
			getInsuranceList().remove(remove - 1);
		}
		
	}

	public Boolean checkInsurance(String string) {// Sigortaları dönuyoruz ve duzgun getclass.getsimlplenameden aynı
													// olup olmadıgını yakalıyoruz
		for (Insurance insurance1 : getInsuranceList()) {
			if (insurance1.getClass().getSimpleName().equals(string)) {
				return true;
			}
		}
		return false;
	}

	public void getInsurance() {
		Scanner scanner = new Scanner(System.in);
		boolean isInsurance = true;
		while (isInsurance) {
			System.out.println("Sigorta Policesine Hosgeldiniz: ");
			System.out.println("Yapmak istediginiz policeyi asagidan seciniz: ");
			System.out.println("1 - Araba Sigortasi");
			System.out.println("2 - Saglik Sigortasi");
			System.out.println("3 - Konut Sigortasi");
			System.out.println("4 - Seyahat Sigortasi");
			System.out.println("5 - Sigortalarimi yazdir veya sil");
			System.out.println("6 - Cikis");
			int insurance = scanner.nextInt();
			switch (insurance) {
			case 1:
				if (checkInsurance("CarInsurance")) {

					System.out.println(CarInsurance.class.getSimpleName()
							+ " sigortasindan yaptirdiginiz icin bir daha yapamassiniz.");
					break;
				}
				Insurance carInsurance = new CarInsurance(this);
				System.out.println(carInsurance.getInsuranceName());
				this.getInsuranceList().add(carInsurance);
				break;
			case 2:
				if (checkInsurance("HealthInsurance")) {
					System.out.println(HealthInsurance.class.getName()
							+ " sigortasindan yaptirdiginiz icin bir daha yapamassiniz.");
					break;
				}
				Insurance healthInsurance = new HealthInsurance(this);
				this.getInsuranceList().add(healthInsurance);
				break;
			case 3:
				if (checkInsurance("ResidenceInsurance")) {
					System.out.println(ResidenceInsurance.class.getName()
							+ " sigortasindan yaptirdiginiz icin bir daha yapamassiniz.");
					break;
				}
				Insurance residenceInsurance = new ResidenceInsurance(this);
				this.getInsuranceList().add(residenceInsurance);
				break;
			case 4:
				if (checkInsurance("TravelInsurance")) {
					System.out.println(TravelInsurance.class.getName()
							+ " sigortasindan yaptirdiginiz icin bir daha yapamassiniz.");
					break;
				}
				Insurance travelInsurance = new TravelInsurance(this);
				this.getInsuranceList().add(travelInsurance);
				break;
			case 5:
				printInsurance();
				break;
			case 6:
				System.out.println("Gule Gule");
				isInsurance = false;
				break;
			default:
				break;
			}
			System.out.println();
		}

	}

	public final void showUserInfo() {
		System.out.println("Musterinin Bilgileri: ");
		System.out.println();
		System.out.println("Musterinin Ismi: " + user.getName());
		System.out.println("Musterinin Soyismi: " + user.getSurName());
		System.out.println("Musterinin emaili: " + user.getEmail());
		System.out.println("Musterinin meslegi: " + user.getJob());
		System.out.println("Musterinin yasi: " + user.getOld());
		if (getUser().getAddress().size() >= 1) {
			System.out.println("Musterinin adresleri: ");
			int i = 0;
			for (Address address : getUser().getAddress()) {
				if (i == 0) {
					System.out.println("Ev Adresi: " + address.getAddress());
					i++;
					continue;
				}
				System.out.println("Is Adresi: " + address.getAddress());
			}

		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(insuranceList);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Account)) { // Diyerek obje insurance classından mı diye kontrol ediyor.
			return false;
		}
		Account other = (Account) obj; // Örnek bir insurance classından nesne oluşturduk ve cast ettik.
		return getClass().getSimpleName() == other.getClass().getSimpleName(); // Class isimlerini sorguladık.
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Insurance> getInsuranceList() {
		return this.insuranceList;
	}

	public void setInsuranceList(ArrayList<Insurance> insuranceList) {
		this.insuranceList = insuranceList;
	}

}
