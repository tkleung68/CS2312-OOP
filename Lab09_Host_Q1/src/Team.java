import java.util.*;

public class Team implements Comparable<Team>{
	/* Very simple - please follow lab sheet */
	private String teamName;
	private Employee head;
	private Day dateSetup;

public Team(String n, Employee hd) {
	head = hd;
	teamName = n;
	dateSetup = SystemDate.getInstance().clone();
}

public static void list (ArrayList<Team> list) {
	//Learn: "-" means left-aligned
	System.out.printf("%-30s%-10s%-13s\n", "Team Name", "Leader" , "Setup Date");
	for (Team t : list)
		System.out.printf("%-30s%-10s%-13s\n",t.teamName,t.head.getName(),t.dateSetup.toString()); //display t.teamName, etc..
}

@Override
public int compareTo(Team o) {
	return this.teamName.compareTo(o.teamName);
}



}
