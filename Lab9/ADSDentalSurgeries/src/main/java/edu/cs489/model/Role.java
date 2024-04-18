package edu.cs489.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_role")
public class Role {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY  )
	    protected Long id;
	    protected String roleName;
	    @ManyToOne(cascade = CascadeType.ALL)
	    private User user;
	    @OneToOne
	    private Dentist dentist;
	    @OneToOne
	    private Patient patient;
}
