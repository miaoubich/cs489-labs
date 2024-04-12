package com.cs489;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cs489.model.Address;
import com.cs489.model.Appointment;
import com.cs489.model.Dentist;
import com.cs489.model.Patient;
import com.cs489.model.Role;
import com.cs489.model.RoleType;
import com.cs489.model.Surgery;
import com.cs489.service.AddressService;
import com.cs489.service.DentistService;
import com.cs489.service.PatientService;
import com.cs489.service.RoleService;
import com.cs489.service.SurgeryService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class AdsDentalSurgeriesApplication implements CommandLineRunner{

	private final RoleService roleService;
	private final DentistService dentistService;
	private final PatientService patientService;
	private final AddressService addressService;
	private final SurgeryService surgeryService;
	
	public static void main(String[] args) {
		SpringApplication.run(AdsDentalSurgeriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LocalDate startDate1 = LocalDate.parse("2023-04-12");
		LocalDate stopDate1 = LocalDate.parse("2025-04-12");
		
		//Role
		Role dentistRole = new Role(null, RoleType.DENTIST, startDate1, stopDate1, null);
		roleService.createNewRole(dentistRole);
		
		LocalDate startDate2 = LocalDate.parse("2023-04-12");
		LocalDate stopDate2 = LocalDate.parse("2025-04-12");
		
		Role patientRole = new Role(null, RoleType.PATIENT, startDate2, stopDate2, null);
		roleService.createNewRole(patientRole);
		
		List<Appointment>appointments = new ArrayList<>(Arrays.asList(
				new Appointment(null, "100 N 4th st", "fairfield", "52556", null, null, null),
				new Appointment(null, "street number 2", "Iowa", "65556", null, null, null)));
		
		//Dentist
		Dentist dentist = new Dentist();
		dentist.setAppointments(appointments);
		dentist.setEmail("dentist.net");
		dentist.setFirstName("ALI");
		dentist.setLastName("Bouzar");
		dentist.setPhoneNumber("654-258-9874");
		dentist.setSpecialization("special1");
		
		dentistService.createNewDentist(dentist);
		
		Address address = new Address(null, "street one", "Jackson Ville", "Florida", "23654");
		addressService.createNewAddress(address);
		
		LocalDate dateOfBirth = LocalDate.parse("1990-02-12");
		Patient patient = new Patient();
		
		//Patient
		patient.setEmail("patient@email.net");
		patient.setFirstName("Ben");
		patient.setLastName("Duck");
		patient.setPhoneNumber("852-987-9856");
		patient.setDateOfBirth(dateOfBirth);
		patient.setOutstandingBill(200.53);
		patient.setAddress(address);
		
		patientService.createNewPatient(patient);
		
		//Surgery
		Surgery surgery = new Surgery();
		surgery.setAddress(address);
		surgery.setAppointments(appointments);
		surgery.setPhoneNumber("321-456-8745");
		surgery.setSurgeryName("ADS Specialization");
		
		surgeryService.createNewSurgery(surgery);
	}

}
