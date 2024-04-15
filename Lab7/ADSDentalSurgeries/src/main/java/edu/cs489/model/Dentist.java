package edu.cs489.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@DiscriminatorValue("dentist")
public class Dentist extends User{

	@Column(nullable = true)
	private String specialization;
	
	@OneToMany(mappedBy = "dentist")
	private List<Appointment>appointments;
}
