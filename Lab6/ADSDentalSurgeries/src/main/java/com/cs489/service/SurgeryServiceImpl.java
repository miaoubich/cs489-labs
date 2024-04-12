package com.cs489.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cs489.model.Surgery;
import com.cs489.repository.SurgeryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SurgeryServiceImpl implements SurgeryService{
	
	private final SurgeryRepository surgeryRepository;
	
	@Override
	public Integer createNewSurgery(Surgery surgery) {
	log.info("A new Surgery with id=" + surgery.getId() + " will be created!");
	
	surgeryRepository.save(surgery);
	
	log.info("The Surgery with id=" + surgery.getId() + " is created!");
	
	return surgery.getId();
	}

	@Override
	public List<Surgery> findAppointment() {
		return surgeryRepository.findAll();
	}

}
