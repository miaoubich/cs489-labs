package com.cs489.service;

import java.util.List;

import com.cs489.model.Address;

public interface AddressService {

	Integer createNewAddress(Address address);
	
	List<Address> findAddresses();
}
