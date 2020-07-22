import java.util.*; 

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

	public Employee createEmployee(String name, int year) throws ExEmployeeAlreadyExists
	{	
		if(Employee.searchEmployee(allEmployees, name)!=null)
			throw new ExEmployeeAlreadyExists();
		Employee e = new Employee(name, year);
		allEmployees.add(e);
		Collections.sort(allEmployees);
		return e;
	}

	public Employee createEmployee(Employee e) 
	{
		allEmployees.add(e);
		Collections.sort(allEmployees);
		return e;
	}
	
	public Team createTeam(String teamn, String name) throws ExEmployeeNotFound, ExTeamAlreadyExists
	{
		if(Employee.searchEmployee(allEmployees,name) == null)
			throw new ExEmployeeNotFound();
		
		if(Team.searchTeamByTeamName(allTeams, teamn) != null)
			throw new ExTeamAlreadyExists();
		
		Employee e = Employee.searchEmployee(allEmployees,name);
		Team t = new Team(teamn, e);
		allTeams.add(t);
		Collections.sort(allTeams);
		return t; 
	}
	

	public Team createTeam(Team t) throws ExEmployeeNotFound, ExTeamAlreadyExists
	{

		allTeams.add(t);
		Collections.sort(allTeams);
		return t; 
	}
	
	public void deleteEmployee(Employee e) {
		allEmployees.remove(e);
	}
	
	public void deleteTeam(Team t) {
		allTeams.remove(t);
	}
	
	public void listEmployees() {
		for( Employee e:allEmployees) {
			System.out.printf("%s (Entitled Annual Leaves: %d days)\n", e.getName(), e.getDay());
		}
	}
	
	public Employee searchEmployee(String name) throws ExEmployeeNotFound{
		if(Employee.searchEmployee(allEmployees, name) == null)
			throw new ExEmployeeNotFound();
		return Employee.searchEmployee(allEmployees, name);
	}
	
	public static Team searchTeam(ArrayList<Team> list, String teamName) {
		for(Team t:list) {
			if(t.getTeamName().equals(teamName)) {
				return t;
			}
		}
		
		return null;
	}
	
	public Team searchTeamByName(String teamName) throws ExTeamNotFound {
		if(searchTeam(allTeams,teamName) == null) {
			throw new ExTeamNotFound();
		}
		return searchTeam(allTeams,teamName);
	}
	
	
	public void listLeavesTakan(){
		for( Employee e:allEmployees) {
			if(e.getLeavesTakan()>0) {
				System.out.println(e.getName() + ":");
				e.listLeavesTaken();
			}else {
				System.out.println(e.getName() + ":");
				System.out.println("No leave record");
			}
		}
	}
	
	public boolean searchAllTeam(Employee e) {
		for(Team t: allTeams) {
			if(t.searchTeammates(e.getName()) != null)
				return true;
		}
		return false;
	}
	
	public void listRole(Employee e) {
		for(Team t: allTeams) {
			t.listRole(e);
		}
	
	}
	
	public void printTeamInfo() {
		for(Team t: allTeams)
			t.printTeamInfo();
	}
	
	public ArrayList<Team> getTeamByEmployee(Employee e) {
		ArrayList<Team> list = new ArrayList<>();
		for(Team t: allTeams) {
			if(t.getName().equals(e.getName())) {
				list.add(t);
			}
		}
		return list;
	}
	


}
