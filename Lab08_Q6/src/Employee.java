
public class Employee {

	private String name;
	private int salary;
	private int annualleaves;
	
	public Employee(String name, int salary, int annualleaves) {
		this.name = name;
		this.salary = salary;
		this.annualleaves = annualleaves;
	}
	
	public String getName() {
		return this.name;
	}
	public int getAnnualleaves() {
		return annualleaves;
	}
	
	public void addSalary(int increase) {
		salary += increase;
	}
	
	public String toString() {
		return name + " ($"+ salary +", "+ annualleaves+" days)";
	}
	
	public void changeLeave(int days) {
		annualleaves = days;
	}

	public void changeSalary(int value) {
		salary = value;
	}
	
	public int getSalary() {
		return salary;
	}
}
