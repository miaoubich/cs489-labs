package edu.cs489.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cs489.model.Address;
import edu.cs489.service.AddressService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adsweb/api/v1/address")
public class AddressController {

	private final AddressService addressService;
	
	@GetMapping("/list")
	public ResponseEntity<?> DisplayAllAddresses(){
		List<Address> addresses = addressService.getAllAddresses();
		
		return new ResponseEntity<>(addresses, HttpStatus.FOUND);
	}
}
