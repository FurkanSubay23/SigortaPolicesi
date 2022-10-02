package LoginOperations;

import java.util.Scanner;
import java.util.TreeSet;
import AccountManager.Account;
import AccountManager.ManagerAccount;
import exception.InvalidException;

public class LoginSystem {

	public void login() {
		ManagerAccount managerAccount = new ManagerAccount();
		Account account1 = null;
		while (account1 == null) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Email adresini giriniz: ");
			String email = scanner.nextLine();
			System.out.println("Sifrenizi giriniz: ");
			String password = scanner.nextLine();
			/*
			 * try { for (Account account : managerAccount.getAccounts()) {
			 * account.login(email, password); termAccount = account;
			 * 
			 * } } catch (InvalidException e) { System.out.println(e.getMessage()); }
			 */
			account1 = managerAccount.acc(email, password);
			System.out.println();
		}
		account1.showUserInfo();
		System.out.println();
		account1.getInsurance();
	}
}
