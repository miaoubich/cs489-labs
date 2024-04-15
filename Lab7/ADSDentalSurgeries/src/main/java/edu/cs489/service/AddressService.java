package edu.cs489.service;

import java.util.List;

import edu.cs489.dto.address.AddressRequest;
import edu.cs489.model.Address;

public interface AddressService {

	String createNewAddress(AddressRequest addressRequest);

	List<Address> getAllAddresses();
}
