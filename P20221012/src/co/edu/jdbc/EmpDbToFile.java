package co.edu.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmpDbToFile {
	public static void main(String[] args) {
		
		try {
			FileWriter fw = new FileWriter("C:/Temp/empFilelist.txt");
			EmployeeDAO dao = new EmployeeDAO();
			List<Employee> list = dao.search();
			
			for(Employee emp : list) {
				emp.getEmployeeId();
				fw.write(emp.getEmployeeId() +emp.getLastName()+ emp.getEmail() + emp.getHireDate() + emp.getJobId()  ); //쓰고싶은 문자 쓰면 파일에 기록될것.
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("completed.");
		
		
	}
}
