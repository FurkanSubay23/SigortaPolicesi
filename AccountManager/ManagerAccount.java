package AccountManager;

import java.util.Scanner;
import java.util.Comparator;
import java.util.TreeSet;

import Address1.Address;
import Address1.AddressManager;
import Address1.BusinessAddress;
import Address1.HomeAddress;
import UserInfo.User;
import exception.InvalidException;

public class ManagerAccount {
	private TreeSet<Account> accounts = new TreeSet<>(new Comparator<Account>() {

		@Override
		public int compare(Account o1, Account o2) {		// Tree setin compare methodunu implements edıyoruz
			
			return o1.getUser().getOld()-o2.getUser().getOld();
		}
	});

	public void addUsers() {
		Address home1 = new HomeAddress("Sivrice");
		Address home2 = new HomeAddress("Kartal");
		Address home3 = new HomeAddress("Nilufer");
		Address home4 = new HomeAddress("Kizilay");
		Address bussines1 = new BusinessAddress("Elazig");
		Address bussines2 = new BusinessAddress("Istanbul");
		Address bussines3 = new BusinessAddress("Bursa");
		Address bussines4 = new BusinessAddress("Ankara");
		User user1 = new User("Furkan", "Subay", "furkanfs", "123", "Programmer", 23);
		User user2 = new User("Faruk", "Subay1", "farukfs", "1234", "Chemistry", 30);
		User user3 = new User("Omer", "Subay2", "omerfs", "1235", "Police", 4);
		User user4 = new User("Elasu", "Subay3", "elafs", "1236", "Artist", 8);
		Account individual1 = new Individual(user1);
		Account individual2 = new Individual(user2);
		Account enterprise1 = new Enterprise(user3);
		Account enterprise2 = new Enterprise(user4);
		accounts.add(individual1);
		accounts.add(individual2);
		accounts.add(enterprise1);
		accounts.add(enterprise2);
		AddressManager.addList(user1, bussines1, home1);
		AddressManager.addList(user2, bussines2, home2);
		AddressManager.addList(user3, bussines3, home3);
		AddressManager.addList(user4, bussines4, home4);

	}

	public Account acc(String email, String password) {
		addUsers();
		try {
			for (Account ac1 : getAccounts()) {
				
				if (ac1.getUser().getEmail().equals(email) && ac1.getUser().getPassword().equals(password)) {
					ac1.login(email, password);
					return ac1;
				}
			}
			throw new InvalidException("Email veya sifre yanlis");
		} catch (InvalidException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public TreeSet<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(TreeSet<Account> accounts) {
		this.accounts = accounts;
	}

}
