

import java.util.*;
import java.io.*;

public class Main{

	public static void main(String [] args) throws FileNotFoundException
	{	
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please input the file pathname of each team: ");
		String str = in.nextLine();

		ArrayList<Team> t = new ArrayList<Team>();
		Scanner ss = new Scanner(str);
		while(ss.hasNext()) {
			t.add(new Team(ss.next()));
		}
		ss.close();
		
		
		
		
		System.out.println("\nListing of teams:");
		for(int i=0;i<t.size();i++) {
		System.out.printf(
			"[Team %d] %d members: %s\n", 
			i+1,t.get(i).getMemberCount(), t.get(i).getStringOfAllMembers()); //call Team methods to get the results: getMemberCount, getStringOfAllMembers
		 //call Team method: printTeamContactMessages
		}
		
		System.out.print("\nEnter a name for searching: ");
		String str2;
		str2 = in.next();
		boolean notfound = true;
		for(int i=0;i<t.size() && notfound;i++) {
			if(t.get(i).find(str2)) {
				System.out.printf("Result: %s is %s in Team %d",str2,t.get(i).search(str2),i+1);
				notfound = false;
			}else if(i== t.size()-1 && !t.get(i).find(str2)) {
				System.out.print("Result: Not found");
			}
		}
		
		
		in.close();
	}
}