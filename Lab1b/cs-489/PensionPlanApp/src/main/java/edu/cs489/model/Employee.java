package edu.cs489.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.OneToOne;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Expose
	private long employeeId;
	@Expose
	private String firstName;
	@Expose
	private String lastName;
	@Expose
	private LocalDate employmentDate;
	@Expose
	private double yearlySalary;
	
	@Expose
	@OneToOne
	private PensionPlan pensionPlan;

	
	public void printEmployees(List<Employee> employees) {
		employees.sort(
                Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getYearlySalary, Comparator.reverseOrder())
        );
		printJson(employees);
	}
	
	public void printEmployeesNotEnrolledForPension(List<Employee> employees) {
        LocalDate firstDayOfNextMonth = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        LocalDate lastDayOfNextMonth = firstDayOfNextMonth.plusMonths(1).minusDays(1);
        
        List<Employee> upcomingEnrollees = employees.stream()
                .filter(employee -> employee.getPensionPlan() == null)
                .filter(employee -> employee.getEmploymentDate().plusYears(5).isBefore(lastDayOfNextMonth.plusDays(1)))
                .filter(employee -> employee.getEmploymentDate().plusYears(5).isAfter(firstDayOfNextMonth.minusDays(1)))
                .sorted((e1, e2) -> e1.getEmploymentDate().compareTo(e2.getEmploymentDate()))
                .collect(Collectors.toList());

        System.out.println("Monthly Upcoming Enrollees Report (Filtered and Sorted):");
        printJson(upcomingEnrollees);
	}
	
	public void printJson(List<Employee> employees) {
		Gson gson = new GsonBuilder().setPrettyPrinting()
	            .excludeFieldsWithoutExposeAnnotation()
	            .create();
        String jsonEmployees = gson.toJson(employees);
        
        System.out.println("List of all the Employees in JSON format:");
        System.out.println(jsonEmployees);
	}
}
