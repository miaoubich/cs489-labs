package edu.cs489.model;

import java.util.List;

import org.springframework.lang.NonNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_User")
@DiscriminatorColumn(name = "User_Type", discriminatorType = DiscriminatorType.STRING)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "First_Name")
	@NonNull
	private String firstName;
	@Column(name = "Last_Name")
	@NonNull
	private String lastName;
	@NonNull
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	@Column(nullable = false)
	@NonNull
	private String email;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Role>roles;
}
