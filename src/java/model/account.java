/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TM080522
 */
public class account {
	private String email;
	private String username;
	private String password;
	private boolean role;
	private String phone;
	private String city;
	private String district;
	private String address;
	private String securityquiz;
	private String securityanswer;

	public account() {
	}

	public account(String email, String username, String password, boolean role, String phone, String city, String district, String address, String securityquiz, String securityanswer) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.phone = phone;
		this.city = city;
		this.district = district;
		this.address = address;
		this.securityquiz = securityquiz;
		this.securityanswer = securityanswer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSecurityquiz() {
		return securityquiz;
	}

	public void setSecurityquiz(String securityquiz) {
		this.securityquiz = securityquiz;
	}

	public String getSecurityanswer() {
		return securityanswer;
	}

	public void setSecurityanswer(String securityanswer) {
		this.securityanswer = securityanswer;
	}

	@Override
	public String toString() {
		return "account{" + "email=" + email + ", username=" + username + ", password=" + password + ", role=" + role + '}';
	}
	
	
}
