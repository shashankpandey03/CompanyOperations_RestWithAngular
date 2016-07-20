package com.company.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.constants.CompanyConstants;
import com.company.pojo.Company;
import com.company.pojo.CompanyResponse;
import com.company.service.CompanyOperationsService;

@Controller
public class CompanyOperationsRest {

	@Autowired
	CompanyOperationsService service;
	
	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	public @ResponseBody CompanyResponse addNewCompany(@RequestBody Company company) {
		CompanyResponse response = new CompanyResponse();
		if(service.addNewCompany(company)) {
			response.setStatusCode(CompanyConstants.SUCCCESS_CODE);
			response.setStatusMessage(CompanyConstants.REGISTRATION_SUCCESS_MESSAGE);
		} else {
			response.setStatusCode(CompanyConstants.FAILURE_CODE);
			response.setStatusMessage(CompanyConstants.REGISTRATION_ALREADY_EXISTS_MESSAGE);
		}
		return response;
	}

	@RequestMapping(value = "/getAllCompanies", method = RequestMethod.GET)
	public @ResponseBody CompanyResponse getAllCompanies() {
		System.out.println("Inside getAllCompanies method");
		CompanyResponse response = new CompanyResponse();
		List<Company> data = service.getAllCompanies();
		if(data != null) {
			response.setData(data);
			response.setStatusCode(CompanyConstants.SUCCCESS_CODE);
		} else {
			response.setStatusCode(CompanyConstants.FAILURE_CODE);
			response.setStatusMessage(CompanyConstants.RECORDS_NOT_PRESENT);
		}
		return response;
	}

	@RequestMapping(value = "/getCompanyDetails/{companyId}", method = RequestMethod.GET)
	public @ResponseBody CompanyResponse getCompanyDetails(@PathVariable String companyId) {
		System.out.println("Inside getCompanyDetails method");
		CompanyResponse response = new CompanyResponse();
		Company data = service.getCompanyDetails(companyId);
		if(data != null) {
			response.setData(data);
			response.setStatusCode(CompanyConstants.SUCCCESS_CODE);
			response.setStatusMessage(CompanyConstants.RECORD_FOUND);
		} else {
			response.setStatusCode(CompanyConstants.FAILURE_CODE);
			response.setStatusMessage(CompanyConstants.RECORD_NOT_FOUND);
		}
		return response;
	}

	@RequestMapping(value = "/updateCompany/{companyId}", method = RequestMethod.POST)
	public @ResponseBody CompanyResponse updateCompany(@PathVariable String companyId, @RequestBody Company company) {
		CompanyResponse response = new CompanyResponse();
		if(service.updateCompany(companyId, company)) {
			response.setStatusCode(CompanyConstants.SUCCCESS_CODE);
			response.setStatusMessage(CompanyConstants.UPDATE_SUCCESS_MESSAGE);
		} else {
			response.setStatusCode(CompanyConstants.FAILURE_CODE);
			response.setStatusMessage(CompanyConstants.UPDATE_FAILURE_MESSAGE);
		}
		return response;
	}
}
