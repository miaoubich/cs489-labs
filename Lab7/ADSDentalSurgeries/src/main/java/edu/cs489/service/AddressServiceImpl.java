package edu.cs489.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import edu.cs489.dto.address.AddressRequest;
import edu.cs489.exception.address.AddressServiceCustomException;
import edu.cs489.model.Address;
import edu.cs489.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService{
	
	private final AddressRepository addressRepository;
	
	@Override
	public String createNewAddress(AddressRequest addressRequest) {
		log.info("A new Address with zip=" + addressRequest.getZip() + " will be created!");
	
		Address address = new Address();
		BeanUtils.copyProperties(addressRequest, address);
		addressRepository.save(address);
		
		log.info("The Address with id=" + address.getId() + " is created!");
		String responseMessage = "The Address successfully registered in the database!";
		
		return responseMessage;
	}

	@Override
	public List<Address> getAllAddresses() {
		List<Address> addresses = addressRepository.findAll();
		
		if(addresses != null)
			return addresses;
		else
			throw new AddressServiceCustomException("No Address yet registered in our Database", 
					"ADDRESS_LIST", HttpStatus.NO_CONTENT);
	}


}
