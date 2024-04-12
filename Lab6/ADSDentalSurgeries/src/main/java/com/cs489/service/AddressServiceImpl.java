package com.cs489.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cs489.model.Address;
import com.cs489.repository.AddressRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService{
	
	private final AddressRepository addressRepository;
	
	@Override
	public Integer createNewAddress(Address address) {
		log.info("A new Address with id=" + address.getId() + " will be created!");
		
		addressRepository.save(address);
		
		log.info("The Address with id=" + address.getId() + " is created!");
		
		return address.getId();
	}

	@Override
	public List<Address> findAddresses() {
		return addressRepository.findAll();
	}

}
