package com.virtusa.bean;

public class EmployeeBean {

	private String firstName;
	private String lastName;
	private String email;
	private String dob;
	private String address;
	private String userName;
	private String password;
	private String confirmPW;
	private String hiddenId;
	
	public String getHiddenId() {
		return hiddenId;
	}
	public void setHiddenId(String hiddenId) {
		this.hiddenId = hiddenId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPW() {
		return confirmPW;
	}
	public void setConfirmPW(String confirmPW) {
		this.confirmPW = confirmPW;
	}
	@Override
	public String toString() {
		return "EmployeeBean [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", dob=" + dob
				+ ", address=" + address + ", userName=" + userName + ", password=" + password + ", confirmPW="
				+ confirmPW + "]";
	}
	
	
	
}
