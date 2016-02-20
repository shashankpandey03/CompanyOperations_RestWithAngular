package com.company.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.pojo.Company;
import com.company.repository.CompanyOperationsRepository;

@Service
public class CompanyOperationsService {

	public boolean addNewCompany(Company company) {
		List<Company> companyList = CompanyOperationsRepository.getInstance().getCompaniesList();
		if(companyList != null && companyList.contains(company)) {
			return false;
		} else {
			companyList.add(company);
			return true;
		}
	}

	public List<Company> getAllCompanies() {
		System.out.println("Inside getAllCompanies method");
		return CompanyOperationsRepository.getInstance().getCompaniesList();
	}

	public Company getCompanyDetails(String companyId) {
		for (Company comp : CompanyOperationsRepository.getInstance().getCompaniesList()) {
			if(companyId.equals(comp.getCompanyId())) {
				return comp;
			}
		}
		return null;
	}

	public boolean updateCompany(String companyId, Company company) {
		List<Company> companyList = CompanyOperationsRepository.getInstance().getCompaniesList();
		if(companyList.contains(company)) {
			int index = companyList.indexOf(company);
			companyList.remove(index);
			companyList.add(company);
			return true;
		} else {
			return false;
		}
	}
}
