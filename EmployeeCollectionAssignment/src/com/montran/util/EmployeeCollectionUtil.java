package com.montran.util;

import java.util.ArrayList;
import java.util.List;

import com.montran.pojo.Employee;

public class EmployeeCollectionUtil {
	private List<Employee> employeeList = new ArrayList<Employee>();
	
	public boolean addNewEmployee(Employee employee) {
		employeeList.add(employee);
		return true;
	}

	public boolean addAllEmployees(Employee[] employee) {
		for(Employee emp2 : employee) {
			employeeList.add(emp2);
			}
		return true;
	}

	public boolean updateEmployeeSalary(int employeeId, double newSalary) {
		for(Employee emp3 : employeeList) {
			if(emp3.getEmployeeId()== employeeId) {
				emp3.setSalary(newSalary);
				return true;
			}
		}
		return false;
	}

	public boolean deleteEmployee(int employeeId) {
		for(Employee emp : employeeList) {
			
				if(emp.getEmployeeId()== employeeId)
					employeeList.remove(emp);
					return true;
			}
		return false;
	}

	public Employee getEmployeeByEmployeeId(int employeeId) {
		for(Employee emp : employeeList) {
			if(emp!=null) {
				if(emp.getEmployeeId()== employeeId)
					return emp;
			}
		}
		return null;
	}

	public List<Employee> getAllEmployees() {
		return employeeList;
	}

}