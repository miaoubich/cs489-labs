package edu.cs489.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
	 
		private Integer id;
		private String street;
		private String city;
		private String state;
		private String zip;
}
