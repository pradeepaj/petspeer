package com.petpeers.usecase.dto;



public class PetDto {
	private long petId;
	private String petName;
	private String place;
	private int age;
	private String action;

	public long getPetId() {
		return petId;
	}

	public void setPetId(long petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public PetDto() {

	}

	public PetDto(long petId, String petName, String place, int age, String action) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.place = place;
		this.age = age;
		this.action = action;
	}

}
