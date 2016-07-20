package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.pojo.MaidDto;
import com.mymaid.interfaces.MaidDataDao;

@Service
public class MaidDataServiceImpl implements MaidDataService {

	@Autowired
	MaidDataDao maidDataDao;
	
	
	public List<MaidDto> getAllMaids() {
		
		return maidDataDao.getAllMaids();
	}

}
