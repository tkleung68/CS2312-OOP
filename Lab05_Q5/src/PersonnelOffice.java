import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class PersonnelOffice
{
	private ArrayList<Employee> allEmployees; //Encapsulated array list of employee/manager objects: private ArrayList<Employee> allEmployees;
	
	private static PersonnelOffice thePO = new PersonnelOffice();
	
	public static PersonnelOffice getInstance() {
		return thePO;
	}
	
	private PersonnelOffice() {
		allEmployees = new ArrayList<Employee>();
	}
	
	
	
	
	//Return the total count of employees
	public int getTotal() 
	{
		return allEmployees.size(); //Total count of employees/managers: allEmployees.size();
	}
	
	//Display a report of all salaries
	public void report()
	{
		double sum = 0;
		for (int i=0;i<allEmployees.size();i++) { //Iterate through the array list based on allEmployees.size() 
			System.out.println(allEmployees.get(i).toStringSalaryDetails()); 
			sum = allEmployees.get(i).getSalary() + sum;
		}
		System.out.println("==============================");
		System.out.printf("Total salary expense: %.2f", sum);
	
	}
	
	public void raiseAllSalaries(double percentage) {
		for(int i=0;i<allEmployees.size();i++)
		allEmployees.get(i).raiseSalary(percentage);
		
	}
	


	//Read employee data from the given file, store in the allEmployees array
	public void loadEmployeeData(String filepathname) throws FileNotFoundException 
	{
		allEmployees.clear(); //remove any existing employees: allEmployees.clear();

		Scanner inFile = new Scanner(new File(filepathname));

		while (inFile.hasNext())
		{
			String id=inFile.next(); //Read the ID: inFile.next();
			
			if (id.charAt(0)=='9') //should be manager
			{
				String name=inFile.next(); //Read a name: inFile.next();
				double salary = inFile.nextDouble();
				double bonus = inFile.nextDouble();
				Manager m;  
				m = new Manager(id,name,salary,bonus);; //pass to the constructor: id, name, salary, bonus
				allEmployees.add(m); //Add the manager object: m
			}
			else
			{
				String name=inFile.next();
				double salary = inFile.nextDouble();
				Employee e; 
				e = new Employee(id, name, salary);
				allEmployees.add(e);
			}
		}

		inFile.close();
	}
}