import java.util.*;
public class Employee implements Comparable<Employee>{

	
	private String name;
	private int yrLeavesEntitled;
	
	public String getName() {
		return name;
	}
	
	
	
	public static Employee searchEmployee(ArrayList<Employee> list, String nameToSearch) {
		for(Employee e:list) {
			if(e.getName().equals(nameToSearch)) {
				return e;
			}
		}
		
		return null;
	}
	public Employee(String n, int yle) {
		name = n;
		yrLeavesEntitled = yle;
	}
	
	@Override
	public int compareTo(Employee another) {
		if(this.name.equals(another.name)) return 0;
		else if (this.name.compareTo(another.name)>0) return 1;
		else return -1;
	}
	
	
}
