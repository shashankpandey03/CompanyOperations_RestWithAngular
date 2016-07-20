package com.company.pojo;

import java.io.Serializable;
import java.util.List;

public class MaidDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int image;
	private String age;
	private String name;
	private List<PhoneNumber> phoneNumberList;
	private List<Address> address;
	private List<Speciality> speciality;
	
	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}
	
	public List<Speciality> getSpeciality() {
		return speciality;
	}

	public void setSpeciality(List<Speciality> speciality) {
		this.speciality = speciality;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<PhoneNumber> getPhoneNumberList() {
		return phoneNumberList;
	}

	public void setPhoneNumberList(List<PhoneNumber> phoneNumberList) {
		this.phoneNumberList = phoneNumberList;
	}

	public String getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(String var1) {
		this.age = var1;
	}

	public void setName(String var1) {
		this.name = var1;
	}
}
