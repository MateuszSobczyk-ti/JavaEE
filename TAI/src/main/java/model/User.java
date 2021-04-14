package model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@Pattern(regexp="^[0-9A-Za-z¹ê³ñœæŸ¿ó_-]{2,25}",message="must contain 2...25 chars: letters, numbers or '_', '-'")
	private String user_name;
	@Pattern(regexp="^[0-9A-Za-z¹ê³ñœæŸ¿ó_-]{8,70}",  message="must contain minimum eight characters: letters, numbers or special characters")
	private String password;
	private String user_role;
	@NotEmpty
    @Email(message = "${validatedValue} is not a valid email")
	private String email;
	 @NotNull
	 @Size(min = 9, max = 11)
	private String phone;
	private int agr_on_not;
	private int country;
	private String cc;
	private int status;
	
	public User() {
	}
	
	public User(User user) {
		this.user_name = user.user_name;
		this.password = user.password;
		this.user_role = user.user_role;
		this.email = user.email;
		this.phone = user.phone;
		this.agr_on_not = user.agr_on_not;
		this.country = user.country;
		this.status = user.status;
	}
	
	public User(String user_name, String password, String email, String phone, String agr_on_not, String country){
		this.user_name = user_name;
		this.setPassword(password);
		this.user_role = "user_role";
		this.email = email;
		this.phone = phone;
		this.setAgr_on_not(agr_on_not);
		this.setCountry(country);
		this.status = 1;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAgr_on_not() {
		return agr_on_not;
	}

	public void setAgr_on_not(String agr_on_not) {
		if(agr_on_not == null)
			this.agr_on_not = 0;
		else 
			this.agr_on_not = 1;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(String country) {
		switch(country) {
		case("Poland"):this.country = 7; break;
		case("Germany"):this.country = 1; break;
		case("Czech Republic"):this.country = 2; break;
		case("Slovakia"):this.country = 3; break;
		case("Ukraine"):this.country = 4; break;
		case("Belarus"):this.country = 5; break;
		case("Russia"):this.country = 6; break;
		case("Lithuania"):this.country = 8; break;
		}
	}
	
	public void setCc(String cc) {
		this.cc=cc;
	}
	
	public String getCc(){
		return cc;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	public String getUser_name() {
		return user_name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUser_role() {
		return user_role;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public void setPassword(String password) {
		this.password = DigestUtils.sha256Hex(password);
	}
	
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
}
