package com.montran.main;

import java.util.List;
import java.util.Scanner;

import com.montran.pojo.Employee;
import com.montran.util.EmployeeCollectionUtil;

public class EmployeeCollectionMainV2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeCollectionUtil util = new EmployeeCollectionUtil();

		List<Employee> employeeList;
		Employee[] employees; // empArray
		Employee employee; // reference
		int employeeId;
		String name;
		double salary;
		String continueChoice = "";
		int employeeChoice = 0;
		boolean result;
		int numberOfEmpolyees = 0;

		do {
			employeeList = util.getAllEmployees();
			for (Employee empTemp : employeeList) {
				if (empTemp != null) {
					System.out.println(
							"\n"+ empTemp.getEmployeeId() + "\t" + empTemp.getName() + "\t" + empTemp.getSalary() + "\t");
				}else {
					System.out.println("No Employee Present");
				}
			}
			System.out.println("\n----Menu-----");
			System.out.println("1. Add Single Employee");
			System.out.println("2. Add Multiple Employees");
			System.out.println("3. Update Existing Employees");
			System.out.println("4. Delete Existing Employee");
			System.out.println("5. Print Single Employee Details");
			System.out.println("6. Exit");
			System.out.println("-----------------------------------------");

			System.out.println("Enter your choice: ");
			employeeChoice = scanner.nextInt();
			switch (employeeChoice) {
			case 1:
				//
				System.out.println("Enter Employee Id: ");
				employeeId = scanner.nextInt();
				scanner.nextLine(); // accepting space + String

				System.out.println("Enter Employee Name:");
				name = scanner.nextLine();

				System.out.println("Enter Salary:");
				salary = scanner.nextDouble();

				employee = new Employee(employeeId, name, salary); // obj creation

				result = util.addNewEmployee(employee);
				if (result)
					System.out.println("Employee Added Successfully..!!");
				else
					System.out.println("Fail to Add Employee..!!");
				break;

			case 2:
				System.out.println("How many Employees do you want to add ?");
				numberOfEmpolyees = scanner.nextInt();

				employees = new Employee[numberOfEmpolyees];
				for (int i = 0; i < numberOfEmpolyees; i++) {
					System.out.println("\n--Add New Employee----");
					System.out.println("Enter Employee Id: ");
					employeeId = scanner.nextInt();
					scanner.nextLine(); // accepting space + String

					System.out.println("Enter Employee Name:");
					name = scanner.nextLine();

					System.out.println("Enter Salary:");
					salary = scanner.nextDouble();
					
					employee = new Employee(employeeId, name, salary);
					employees[i] = employee;
				}
				result = util.addAllEmployees(employees);
				if (result) {
					System.out.println("Employees are Addedd !!");

				} else {
					System.out.println("Insufficient Space");
				}
				break;

			case 3:
				System.out.println("Enter Employee Id to Update: ");
				employeeId = scanner.nextInt();
				scanner.nextLine();
				employee = util.getEmployeeByEmployeeId(employeeId);

				if (employee != null) {
					System.out.println("Enter New Salary:");
					salary = scanner.nextDouble();

					result = util.updateEmployeeSalary(employeeId, salary);
					if (result) {
						System.out.println("Employee Details are Updated Successfully..!!");
					} else
						System.out.println("Failed to update Employee details");
				} else
					System.out.println("No Employee found !!");
				break;

			case 4:
				System.out.println("Enter Employee Id to Delete: ");
				employeeId = scanner.nextInt();
				employee = util.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					result = util.deleteEmployee(employeeId);
					if (result) {
						System.out.println("Employee Deleted Successfully");
					} else
						System.out.println("Failed to Delete Employee");
				} else
					System.out.println("Employee Not Found");

				break;

			case 5:
				System.out.println("Enter Employee Id: ");
				employeeId = scanner.nextInt();
				employee = util.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					System.out.println(employee);
				} else
					System.out.println("Employee Not Found");
				break;
			case 6:
				System.out.println("Thank You");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("-----------------------------------");
			System.out.println("Do you want to continue ? [yes/no]");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));
		System.out.println("----Thank You------");
		scanner.close();
	}

}
