import java.util.HashMap;

public class Department {
	private String depCode;
	private String depName;
	private Double depTotalSalary;
	private HashMap<String, Employee> employees;
	
	public Department() {
		this.depTotalSalary = 0.00;
	}
	
	public String getDepCode() {
		return depCode;
	}
	
	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}
	
	public String getDepName() {
		return depName;
	}
	
	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	public Double getDepTotalSalary() {
		return depTotalSalary;
	}
	
	public void setDepTotalSalary(Double depTotalSalary) {
		this.depTotalSalary = depTotalSalary;
	}
	
	
	public HashMap<String, Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(HashMap<String, Employee> employees) {
		this.employees = employees;
	}
}