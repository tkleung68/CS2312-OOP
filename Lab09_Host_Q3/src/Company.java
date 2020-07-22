import java.util.*;
import java.util.Collections; 

public class Company{
	
	private ArrayList<Employee> allEmployees;
	private ArrayList<Team> allTeams;

	private static Company instance = new Company();

	private Company() {
		allEmployees = new ArrayList<>();
		allTeams = new ArrayList<>();
	}

	public static Company getInstance() 
	{
		return instance;
	}

	public void listTeams() 
	{
		Team.list(allTeams);
	}

	public Employee createEmployee(String name, int year) // See how it is called in main()
	{
		Employee e = new Employee(name, year);
		allEmployees.add(e);
		Collections.sort(allEmployees); //allEmployees
		return e;
	}

	public Team createTeam(String teamn, String name) // See how it is called in main()
	{
		Employee e = Employee.searchEmployee(allEmployees,name);
		Team t = new Team(teamn, e);
		allTeams.add(t);
		Collections.sort(allTeams); //allTeams
		return t; //Why return?  Ans: Later you'll find it useful for undoable comments.
	}
	
	public void deleteEmployee(String name) {
		Employee e = Employee.searchEmployee(allEmployees,name);
		allEmployees.remove(e);
	}
	
	public void deleteTeam(String teamName, String head) {
		Team t = Team.searchEmployee(allTeams, teamName, head);
		allTeams.remove(t);
	}
	
	public void listEmployees() {
		for( Employee e:allEmployees) {
			System.out.printf("%s (Entitled Annual Leaves: %d days)\n", e.getName(), e.getDay());
		}
	}

}
