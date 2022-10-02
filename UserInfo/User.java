package UserInfo;

import java.util.ArrayList;
import java.util.Date;
import Address1.*;

public class User {
	private String name, surName, email, password, job;
	private int old;
	private ArrayList<Address> addressList = new ArrayList<>();
	private Date date = null;

	public User() {
	}

	public User(String name, String surName, String email, String password, String job, int old) {
		super();
		this.name = name;
		this.surName = surName;
		this.email = email;
		this.password = password;
		this.job = job;
		this.old = old;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<Address> getAddress() {
		return addressList;
	}
}
