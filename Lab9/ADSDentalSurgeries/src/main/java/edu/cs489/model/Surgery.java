package edu.cs489.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Surgery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "Surgery_Name")
	private String surgeryName;
	@Column(name = "Phone_Number")
	private String phoneNumber;
	
	@OneToOne
	private Address address;
	
	@OneToMany(mappedBy = "surgery", cascade = CascadeType.ALL)
	private List<Appointment> appointments;
}
