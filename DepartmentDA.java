import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DepartmentDA {
	private Department department;
	
	public DepartmentDA() throws FileNotFoundException {
		Scanner departmentFile = new Scanner(new FileReader("dep.csv"));
		
		while (departmentFile.hasNext()) {
			String[] departmentFileArray = departmentFile.nextLine().split(",", 3);
			
			department = new Department();
			department.setDepCode(departmentFileArray[0].trim());
			department.setDepName(departmentFileArray[1].trim());
			
			HashMap<String, Employee> employees = readDepEmp(department);
			
			department.setEmployees(employees);
			department.setDepTotalSalary(employees.values().stream().mapToDouble(Employee::getSalary).sum());
			
			printDepartment();
		}
		
		departmentFile.close();
	}
	
	private static HashMap<String, Employee> readDepEmp(Department department) throws FileNotFoundException {
		Scanner deptEmployeeFile = new Scanner(new FileReader("deptEmp.csv"));
		HashMap<String, Employee> employees = new HashMap<>();
		
		while (deptEmployeeFile.hasNext()) {
			String[] deptEmployeeFileArray = deptEmployeeFile.nextLine().split(",", 3);
			
			if (!deptEmployeeFileArray[0].trim().equals(department.getDepCode())) continue;
			
			Employee employee = new EmployeeDA(deptEmployeeFileArray[1].trim()).getEmployee();
			employee.setSalary(Double.valueOf(deptEmployeeFileArray[2].trim()));
			employees.put(employee.getEmpNo(), employee);
		}
		
		deptEmployeeFile.close();
		return employees;
	}
	
	private void printDepartment() {
		System.out.println("Department Code: " + department.getDepCode());
		System.out.println("Department Name: " + department.getDepName());
		System.out.println("Department Total Salary: " + formatCurrency(department.getDepTotalSalary()));
System.out.println("------------------ Details ----------------------");
System.out.println(String.format("%-15s%-25s%-15s", "EmpNo", "Employee Name", "Salary"));
for (Map.Entry<String, Employee> employee : department.getEmployees().entrySet()) {
    Employee employeeValue = employee.getValue();

    System.out.println(
        String.format(
            "%-15s%-25s%-15s",
            employeeValue.getEmpNo(),
            formatName(employeeValue.getLastName(), employeeValue.getFirstName()),
            formatCurrency(employeeValue.getSalary())
        )
    );
	}
	
	System.out.println();
}

public String formatCurrency(double amount) {
    return String.format("%,.2f", amount);
}

public String formatName(String lastName, String firstName) {
    return lastName + ", " + firstName;
	}
}