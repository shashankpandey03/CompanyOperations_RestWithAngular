package com.company.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.pojo.MaidDto;
import com.mymaid.interfaces.MaidDataDao;
import com.mymaid.util.MaidUtility;

@Repository
public class MaidDataDaoImpl implements MaidDataDao {

	public List<MaidDto> getAllMaids() {
		List<MaidDto> maidList = MaidUtility.getBaiNames();
		return maidList;
	}
}
