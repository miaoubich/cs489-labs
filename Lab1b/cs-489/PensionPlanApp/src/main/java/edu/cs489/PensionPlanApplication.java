package edu.cs489;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.cs489.model.Employee;
import edu.cs489.model.PensionPlan;

public class PensionPlanApplication {

	public static void main(String[] args) {
		LocalDate enrollementDate1 = LocalDate.of(2023, 01, 17);
		LocalDate enrollementDate2 = LocalDate.of(2019, 11, 04);
		PensionPlan pensionPlan1 = new PensionPlan(1089L, enrollementDate1, 100);
		PensionPlan pensionPlan2 = new PensionPlan(2307L, enrollementDate2, 1555.50);
		
		LocalDate date1 = LocalDate.of(2018, 01, 17);
		LocalDate date2 = LocalDate.of(2019, 04, 03);
		LocalDate date3 = LocalDate.of(2014, 05, 16);
		LocalDate date4 = LocalDate.of(2019, 05, 02);
		List<Employee> employees = new ArrayList<>(Arrays.asList(
				new Employee(123456789L, "Daniel", "Agar", date1, 105945.50,pensionPlan1),
				new Employee(236547896L, "Benard", "Shaw", date2, 197750.00,null),
				new Employee(123456789L, "Carly", "Agar", date3, 842000.75,pensionPlan2),
				new Employee(123456789L, "Wesley", "Schneider", date4, 74500.00,null)
				));
		
		Employee employee = new Employee();
		
		employee.printEmployees(employees);
		
		System.out.println("-----------------------------------------------");
		employee.printEmployeesNotEnrolledForPension(employees);
	}

}
