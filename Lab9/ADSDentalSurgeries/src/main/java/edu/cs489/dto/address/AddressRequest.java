package edu.cs489.dto.address;

import org.springframework.lang.NonNull;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressRequest {
		@NonNull
		private String street;
		private String city;
		private String state;
		@NotBlank(message = "Zip code can't be empty or blank space")
		private String zip;
}
