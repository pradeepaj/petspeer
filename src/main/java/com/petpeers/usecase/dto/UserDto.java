package com.petpeers.usecase.dto;

public class UserDto {
	private long userId;
	private String name;
	private String password;
	private String confirmPassword;
	
	public UserDto() {
		
	}

	public UserDto(long userId, String name, String password, String confirmPassword) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", name=" + name + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}

	


}
