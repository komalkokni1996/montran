package com.montran.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.montran.pojo.Employee;

public class EmployeeDatabaseUtil {
	
	private List<Employee> employeeList = new ArrayList<Employee>();
	Employee employee; // reference
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "montran";
	String password = "montran";
	Connection con;
	String sql = "";
	PreparedStatement preparedStmtS, preparedStmtI, preparedStmtD, preparedStmtU, preparedStmtGetAll;
	ResultSet resultSet;
	int i;
	boolean result;
	
	String insertQuery = "INSERT INTO employee_master VALUES(?,?,?)";
	String selectQuery = "SELECT * FROM employee_master WHERE employee_Id = ?";
	String updateQuery = "UPDATE employee_master SET salary=? WHERE employee_Id=?";
	String deleteQuery = "DELETE FROM employee_master WHERE employee_Id = ?";
	String getAllQuery = "SELECT * FROM employee_master";
	
	public EmployeeDatabaseUtil() {
	
	try {
		// 1. Load jdbc driver
		Class.forName(driver);
		System.out.println("Driver loaded successfully.");

		// 2. Connect to database
		con = DriverManager.getConnection(url, user, password);
		if (con != null) {
			System.out.println("Connection Success !! ");
		} else
			System.out.println("Connection failed !!");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
	public boolean addNewEmployee(Employee employee){
		try {
			preparedStmtI = con.prepareStatement(insertQuery);
			preparedStmtI.setInt(1, employee.getEmployeeId());
			preparedStmtI.setString(2, employee.getName());
			preparedStmtI.setDouble(3, employee.getSalary());
			
			i = preparedStmtI.executeUpdate();
			result = i > 0 ? true : false;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;
	}
	
	public boolean addAllEmployees(Employee[] employee) {
		try {
			for(Employee emp2 : employee) {
			preparedStmtI = con.prepareStatement(insertQuery);
			preparedStmtI.setInt(1, emp2.getEmployeeId());
			preparedStmtI.setString(2, emp2.getName());
			preparedStmtI.setDouble(3, emp2.getSalary());
			
			i = preparedStmtI.executeUpdate();
			}
			result = i > 0 ? true : false;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateEmployeeSalary(int employeeId, double newSalary) {
		
		try {
			preparedStmtU = con.prepareStatement(updateQuery);
			preparedStmtU.setDouble(1, newSalary);
			preparedStmtU.setInt(2, employeeId);
			i= preparedStmtU.executeUpdate();
			result = i >0 ? true : false;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteEmployee(int employeeId) {
		
		try {
			preparedStmtD = con.prepareStatement(deleteQuery);
			preparedStmtD.setInt(1, employeeId);
			i = preparedStmtD.executeUpdate();
			result = i > 0 ? true: false;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Employee getEmployeeByEmployeeId(int employeeId) {
		
		try {
			preparedStmtS = con.prepareStatement(selectQuery);
			preparedStmtS.setInt(1, employeeId);
			resultSet = preparedStmtS.executeQuery();
			if(resultSet.next()) {
				employee = new Employee(resultSet.getInt("employee_Id"), resultSet.getString("name"), resultSet.getDouble("salary"));
				return employee;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> getAllEmployees() {
		
		try {
			preparedStmtGetAll = con.prepareStatement(getAllQuery);
			resultSet = preparedStmtGetAll.executeQuery();
			employeeList.clear();
			while(resultSet.next()) {
				employee = new Employee(resultSet.getInt("employee_Id"), resultSet.getString("name"), resultSet.getDouble("salary"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
	}
	
	public void connectionClose() {
		try {
			con.close();
			preparedStmtS.close();
			preparedStmtI.close();
			preparedStmtU.close();
			preparedStmtD.close();
			preparedStmtGetAll.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}	
