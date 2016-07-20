package com.company.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.constants.CompanyConstants;
import com.company.constants.MaidConstants;
import com.company.pojo.MaidDataResponse;
import com.company.pojo.MaidDto;
import com.company.service.MaidDataService;

@Controller
public class MaidDataRest {

	@Autowired
	MaidDataService maidDataService;
	
	@RequestMapping("/getAllMaids")
	public @ResponseBody MaidDataResponse getAllMaids() {
		MaidDataResponse response = new MaidDataResponse();
		
		List<MaidDto> data = maidDataService.getAllMaids();
		
		if(data != null) {
			response.setStatusCode(CompanyConstants.SUCCCESS_CODE);
			response.setData(data);
		} else {
			response.setStatusCode(CompanyConstants.FAILURE_CODE);
			response.setStatusMessage(MaidConstants.MAID_DATA_FETCH_FAILURE);
		}
		return response;
	}
}
