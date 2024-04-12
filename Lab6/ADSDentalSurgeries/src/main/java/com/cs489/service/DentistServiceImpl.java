package com.cs489.service;

import org.springframework.stereotype.Service;

import com.cs489.model.Dentist;
import com.cs489.repository.DentistRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DentistServiceImpl implements DentistService{

	private final DentistRepository dentistRepository;
	
	//CRUD
	public Integer createNewDentist(Dentist dentist) {
		log.info("A new Dentist with id=" + dentist.getId() + " will be created!");
		
		dentistRepository.save(dentist);
		
		log.info("The Dentist with id=" + dentist.getId() + " is created!");
		
		return dentist.getId();
	}
	
	public Dentist findDentistById(Integer dentistId) {
		Dentist dentist = dentistRepository.findById(dentistId).
				orElseThrow(() -> new NullPointerException(
						"Dentist with id=" + dentistId + " doesn't exist in the database!"));
		return dentist;
	}
	
	public Dentist updateExistingDentist(Dentist dentist) {
		Dentist exisDentist = findDentistById(dentist.getId());
		
		if(exisDentist != null) {
			log.info("Dentists with id=" + exisDentist.getId() + "is exist in the DB!");
			
			exisDentist.setAppointments(dentist.getAppointments());
			exisDentist.setEmail(dentist.getEmail());
			exisDentist.setFirstName(dentist.getFirstName());
			exisDentist.setLastName(dentist.getLastName());
			exisDentist.setPhoneNumber(dentist.getPhoneNumber());
			exisDentist.setSpecialization(dentist.getSpecialization());
			
			dentistRepository.save(exisDentist);
			
			log.info("Dentist with id=" + exisDentist.getId() + "successfully updated!");
		}
		return exisDentist;
	}
	
	public Integer deleteDentist(Integer dentistId) {
		Dentist dentist = findDentistById(dentistId);
		
		if(dentist != null) {
			log.info("Role with id=" + dentist.getId() + "is exist in the DB!");
			dentistRepository.delete(dentist);
			log.info("Dentist with id=" + dentist.getId() + "is exist in the DB!");
		}
		return dentist.getId();
	}
}
