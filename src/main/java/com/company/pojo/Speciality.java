package com.company.pojo;

import java.io.Serializable;

public class Speciality implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String workKnown;
	private int rating;
	
	public String getWorkKnown() {
		return workKnown;
	}
	public void setWorkKnown(String workKnown) {
		this.workKnown = workKnown;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
