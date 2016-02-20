package com.company;


/**
 * @author Shashank
 * Constant file for various messages
 * 
 */
public interface CompanyConstants {
	
	int SUCCCESS_CODE = 200;
	int FAILURE_CODE = 400;
	
	String REGISTRATION_SUCCESS_MESSAGE = "Company added successfully";
	String REGISTRATION_ALREADY_EXISTS_MESSAGE = "Company already exists in records";
	String RECORDS_NOT_PRESENT = "No records present in repository";
	String RECORD_NOT_FOUND = "Record not found for given company id";
	String RECORD_FOUND = "Record found";
	String UPDATE_SUCCESS_MESSAGE = "Company updated successfully";
	String UPDATE_FAILURE_MESSAGE = "Couldn't update company.";
}
