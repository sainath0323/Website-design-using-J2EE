package com.sai.advanceapplication.viewusers;

public class User {

private String	username,email,country,qualification,gender,address;

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getQualification() {
	return qualification;
}

public void setQualification(String qualification) {
	this.qualification = qualification;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public User(String username, String email, String country, String qualification, String gender, String address) {
	super();
	this.username = username;
	this.email = email;
	this.country = country;
	this.qualification = qualification;
	this.gender = gender;
	this.address = address;
}

@Override
public String toString() {
	return "View [username=" + username + ", email=" + email + ", country=" + country + ", qualification="
			+ qualification + ", gender=" + gender + ", address=" + address + "]";
}


	
}