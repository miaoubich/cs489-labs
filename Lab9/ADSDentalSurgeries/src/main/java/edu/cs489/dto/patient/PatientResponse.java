package edu.cs489.dto.patient;

import java.time.LocalDate;

import edu.cs489.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {
		
	private Integer id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private LocalDate dateOfBirth;
	private double outstandingBill;
	private Address address;
}
