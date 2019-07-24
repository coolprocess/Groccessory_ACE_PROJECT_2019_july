package com.niit.groccessory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {
	
	
	private static final String DEFAULT_ROLE = "ROLE_USER";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custId;
	
	@NotNull(message = "Please fill this field")
	@Pattern(regexp = "[a-zA-Z]{4,12}", message = "Only Alphabets in the range 4-12 are accepted")
	private String firstName;

	@NotNull(message = "Please fill this field")
	@Pattern(regexp = "[a-zA-Z]{4,12}", message = "Only Alphabets in the range 4-12 are accepted")
	private String lastName;

	@NotNull(message = "Please fill this field")
	@Pattern(regexp = "[0-9]{10,10}", message = "Only 10 numbers are accepted")
	private String mobile;

	@NotNull(message = "Please fill this field")
	private String address;

	@NotNull(message = "Please fill this field")
	/*@Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$", message = "you can use @symbol , hiphen- and digits")
	*/private String email;

	@NotNull(message = "Please fill this field")
	/*@Pattern(regexp = "((?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*\\W).{8,12})", message = "One UpperCase, One lowercase, one number and one special character are must in 8-12 character range")*/
	private String password;
	@Transient
	private String confirmPassword;

	private boolean is_Active;

	private String role = DEFAULT_ROLE;

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isIs_Active() {
		return is_Active;
	}

	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static String getDefaultRole() {
		return DEFAULT_ROLE;
	}
	
	
	

}
