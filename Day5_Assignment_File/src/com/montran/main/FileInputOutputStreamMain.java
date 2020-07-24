package com.montran.main;

import java.io.File;
import java.util.Scanner;

import com.montran.util.FileInputStreamUtil;
import com.montran.util.FileOutputStreamUtil;

public class FileInputOutputStreamMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FileOutputStreamUtil outil = new FileOutputStreamUtil();
		FileInputStreamUtil iutil = new FileInputStreamUtil();
		
		int employeeId;
		String name;
		double salary;
		
		String filePath;
		String data;
		File file;
		byte[] fileData;
		//section 1
		System.out.println("Enter Employee ID:: ");
		employeeId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Name:: ");
		name = scanner.nextLine();
		
		System.out.println("Enter Salary:: ");
		salary = scanner.nextDouble();
		
		scanner.nextLine();
		System.out.println("Enter Path where to store with FileName: ");
		filePath = scanner.next();
		file = new File(filePath);
		data = "Employee ID=>" +employeeId + "\t"+ "Employee Name=>"+ name+ "\t" + "Salary=> Rs."+ salary ;
		
		outil.writeDataIntoFile(file, data.getBytes()); //writing data

		System.out.println("File Created and Data Written Successfully !!");
		
		//Section 2
		fileData = iutil.getFileData(file);
		System.out.println("\n\n---------------File Reading----------------");
		for(byte b: fileData) {
			System.out.print((char)b);
		}
		scanner.close();
		
	}

}
