import java.util.*;

public class Team implements Comparable<Team>{
	
	private String teamName;
	private Employee head;
	private Day dateSetup;
	private ArrayList<Employee> allTeammates;
	private ArrayList<ActingHead> allActingHeads; 

public Team(String n, Employee hd) {
	head = hd;
	teamName = n;
	dateSetup = SystemDate.getInstance().clone();
	allTeammates = new ArrayList<>();
	allTeammates.add(head);
	allActingHeads = new ArrayList<>();
}

public String getTeamName() {
	return teamName;
}

public String getName() {
	return head.getName();
}


public static Team searchTeamByTeamName(ArrayList<Team> list, String teamName) {
	for(Team t:list) {
		if(t.getTeamName().equals(teamName)) {
			return t;
		}
	}
	return null;
}

public static void list (ArrayList<Team> list) {

	System.out.printf("%-30s%-10s%-13s\n", "Team Name", "Leader" , "Setup Date");
	for (Team t : list)
		System.out.printf("%-30s%-10s%-13s\n",t.teamName,t.head.getName(),t.dateSetup.toString()); //display t.teamName, etc..
}

@Override
public int compareTo(Team o) {
	return this.teamName.compareTo(o.teamName);
}

public void addTeamMember (Employee e) {
	allTeammates.add(e);
	Collections.sort(allTeammates);
}

public void deleteTeamMember(Employee e) {
	allTeammates.remove(e);
}

public Employee searchTeammates(String s) {
	for(Employee e:allTeammates) {
		if(s.equals(e.getName()))
			return e;
	}
	return null;
}

public void listRole(Employee e) {

	for(Employee employee: allTeammates) {
		if(employee.equals(e)) {
			if(e.equals(head)) {
				System.out.println((teamName +  " (Head of Team)")); 
			}else {
				System.out.println(teamName);
			}
		}
	}
}

public void printTeamInfo() {
	System.out.println(teamName + ":");
	
	for(Employee e:allTeammates) {
		if(e.getName().equals(head.getName())) {
			System.out.println((head.getName() +  " (Head of Team)"));
		}else {
			System.out.println(e.getName());
		}
	}
	
	if(allActingHeads.size() > 0) {
		System.out.println("Acting heads:");
		
		for(ActingHead e:allActingHeads) {
			
			System.out.println(e.getLeaveRecord().toString() + ": " + e.getActingHead().getName());
			
		}	
	}
	System.out.println();
}

public void setActingHead(ActingHead e) throws ExOverlapLeave {
	for(int i=0;i<e.getActingHead().getLeavesTakan();i++) {
		if(e.getActingHead().getLeavesByPeriod(i).isOverlapWithPeriod(e.getLeaveRecord()))
			throw new ExOverlapLeave(e.getActingHead().getName()+"  is on leave during " + e.getActingHead().getLeavesByPeriod(i).toString());
			
	}
	allActingHeads.add(e);
	Collections.sort(allActingHeads);
}

public void removeActingHead(ActingHead e) {
	allActingHeads.remove(e);
}


}
