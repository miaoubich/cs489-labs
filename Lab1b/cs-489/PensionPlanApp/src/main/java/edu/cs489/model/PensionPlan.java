package edu.cs489.model;

import java.time.LocalDate;

import com.google.gson.annotations.Expose;
import com.fasterxml.jackson.annotation.JsonInclude;  

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PensionPlan {

	@Expose
	private long planReferenceNumber;
	@Expose
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private LocalDate enrollmentDate;
	@Expose
	private double monthlyContribution;
	
	
}
