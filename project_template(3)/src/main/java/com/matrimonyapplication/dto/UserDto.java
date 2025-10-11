package com.matrimonyapplication.dto;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDto {

    private Long id;

    @NotBlank(message = "Name should not be blank.")
    private String name;

    @NotBlank(message = "Email should not be blank.")
    @Email(message = "Email must be of type email.")
    private String email;

    @NotBlank(message = "Password should not be blank.")
    private String password;

    private String roles;
    private Date dob;

    @NotBlank(message = "Gender should not be blank.")
    private String gender;

    // Constructors
    public UserDto() {}

    public UserDto(Long id, String name, String email, String password, String roles, Date dob, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.dob = dob;
        this.gender = gender;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRoles() { return roles; }
    public void setRoles(String roles) { this.roles = roles; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", roles="
				+ roles + ", dob=" + dob + ", gender=" + gender + "]";
	}
    
    
}