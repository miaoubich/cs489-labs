package edu.cs489.dto.patient;

import java.time.LocalDate;

import org.springframework.lang.NonNull;

import edu.cs489.model.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PatientRequest {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	LocalDate dateOfBirth;
	private double outstandingBill;
	private Address address;
}
