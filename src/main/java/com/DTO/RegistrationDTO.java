package com.DTO;

public class RegistrationDTO {

	private String email;
	private String name;
	private String password;
	private String contact;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public RegistrationDTO(String email, String name, String password, String contact) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.contact = contact;
	}
	
	//no arg constructor
	public RegistrationDTO() {

	}
	
	@Override
	public String toString() {
		return "RegistrationDTO [email=" + email + ", name=" + name + ", password=" + password + ", contact=" + contact
				+ "]";
	}
	
	
	
	
}
