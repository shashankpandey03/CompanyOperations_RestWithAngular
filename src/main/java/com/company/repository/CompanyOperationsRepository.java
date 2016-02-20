package com.company.repository;

import java.util.ArrayList;
import java.util.List;

import com.company.pojo.Company;

/**
 * @author Shashank
 * Repository class for storing all 
 * company details.
 * Class is singleton to avoid unnecessary object creation
 * for every operation
 */
public class CompanyOperationsRepository {

	private List<Company> companiesList =  new ArrayList<Company>();
	private static CompanyOperationsRepository instance;
	private static Object mutex = new Object();
	
	public List<Company> getCompaniesList() {
		return companiesList;
	}

	public void setCompaniesList(List<Company> companiesList) {
		this.companiesList = companiesList;
	}
	
	private CompanyOperationsRepository() {}
	
	public static CompanyOperationsRepository getInstance() {
		if(instance == null) {
			synchronized(mutex) {
				if(instance == null) {
					instance = new CompanyOperationsRepository();
				}
			}
		}
		return instance;
	}
}
