import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EmployeeDA {
	private final Employee employee;
	
	public EmployeeDA(String empNo) throws FileNotFoundException {
		Scanner employeeFile = new Scanner(new FileReader("emp.csv"));
		
		employee = new Employee();
		while (employeeFile.hasNext()) {
			String[] employeeFileLineArray = employeeFile.nextLine().split(",", 4);
			
			if (!employeeFileLineArray[0].trim().equals(empNo)) continue;
			
			employee.setEmpNo(employeeFileLineArray[0].trim());
			employee.setLastName(employeeFileLineArray[1].trim());
			employee.setFirstName(employeeFileLineArray[2].trim());
		}
		
		employeeFile.close();
	}
	
	public Employee getEmployee() {
		return employee;
	}
}