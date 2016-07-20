package com.mymaid.util;

import java.util.ArrayList;
import java.util.List;

import com.company.pojo.Address;
import com.company.pojo.MaidDto;
import com.company.pojo.PhoneNumber;
import com.company.pojo.Speciality;

public class MaidUtility {
   

   public static List<MaidDto> getBaiNames() {
	  List<MaidDto> maidList = new ArrayList<MaidDto>();
      
	  maidList.add(createBai("Jessica Alba", "30", "Kharadi, near Reliance mart", "1234567890", "Cooking"));
	  maidList.add(createBai("Elisha Cuthbert", "40", "Vimannagar, near Adidas showroom", "1234567891", "Washing"));
	  maidList.add(createBai("Kate Winslet", "45", "Vadgaon Sheri, Opposite Hyatt regency", "1234567892", "Baby care"));
	  maidList.add(createBai("Anne Hathaway", "35", "Kharadi, near Red chillies", "1234567893", "Cooking"));
	  maidList.add(createBai("Scarlet Johnson", "32", "Hadapsar, SasaneNagar", "1234567894", "All rounder"));
	  maidList.add(createBai("Koi to faltu", "99", "Magarpatta, Opposite seasons mall", "1234567895", "Cleaning"));
	  
	  return maidList;
   }
   
   private static MaidDto createBai(String name, String age, String address, String phoneNumber, String speciality){
	   MaidDto dto = new MaidDto();
	   dto.setName(name);
	   dto.setAge(age);
	   
	   List<Address> addressList = new ArrayList<Address>();
	   Address maidAddress = new Address();
	   maidAddress.setLocality(address);
	   addressList.add(maidAddress);
	   dto.setAddress(addressList);
	   
	   List<PhoneNumber> phoneNumberList = new ArrayList<PhoneNumber>();
	   PhoneNumber maidPhoneNumber = new PhoneNumber();
	   maidPhoneNumber.setCountryCode("+91");maidPhoneNumber.setPhoneNumber(phoneNumber);
	   phoneNumberList.add(maidPhoneNumber);
	   dto.setPhoneNumberList(phoneNumberList);
	   
	   List<Speciality> specialityList = new ArrayList<Speciality>();
	   Speciality maidSpeciality = new Speciality();
	   maidSpeciality.setWorkKnown(speciality);
	   specialityList.add(maidSpeciality);
	   dto.setSpeciality(specialityList);
	   
	   return dto;
   }
}
