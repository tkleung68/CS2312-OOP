import java.util.*;
import java.io.*;

public class Main{
	


	public static void main(String [] args) throws FileNotFoundException
	{	
		System.out.print("Please input the file pathname: ");
		Scanner in = new Scanner(System.in);
		String filepathname = in.nextLine();
		

		Student[] students; //Define an array of students: Student[] students;
		students = Student.createStudentListFromFile(filepathname); //Call the given static method in the Student class for reading from file: Student.createStudentListFromFile(filepathname);
		

		int numOfteams;

		System.out.print("Enter the number of teams: " );
		numOfteams = in.nextInt();
		
		if(students.length % numOfteams !=0) {
			System.out.println("Wrong input - It is not a factor of " + students.length + ".");
			return;
		}
		
		

		
		Team[] teams; //Define an array of teams: Team [] 
		teams = createTeams(students, numOfteams);//Call the private method (one of the 3 methods in Main.java) to create the teams for students: createTeams(students);
		
		//Print the grouping result:
		System.out.println("\nGrouping result: ");				
		
		for(int i=0;i<numOfteams;i++) {
			System.out.println(teams[i].toString());
		}
		
		//Create the assignments
		Assignment[] assignments; //Define an array of assignments: Assignment[] assignments 
		assignments =  decideTasks(teams, in); ;//Call the private method (one of the 3 methods in Main.java) to input the tasks for each team: decideTasks(teams, in); 
		

		in.close();
	}
	
	//Todo(2) the createTeams() method --- see Main_GivenCode.txt
	
	
	//Create the teams from the students array: students[0..5] go to team A, students[6..11] go to team B, etc..
	private static Team[] createTeams(Student[] students, int num) 
	{
		Team[] result; //Define an array of teams to store the result: Team[] result;
		result = new Team[num]; //Create the array: new Team[5];
		char name = 'A';
		
		//Create the 5 teams
//		result[0]=new Team("Team A", Arrays.copyOfRange(students, 0,3));
//		result[1]=new Team("Team B", Arrays.copyOfRange(students, 3,6));
//		result[2]=new Team("Team C", Arrays.copyOfRange(students, 12,18));
//		result[3]=new Team("Team D", Arrays.copyOfRange(students, 18,24));
//		result[4]=new Team("Team E", Arrays.copyOfRange(students, 24,30));
		
		
		for( int i=0; i< num; i++) {
			result[i] = new Team("Team " + (char)(name+i) , Arrays.copyOfRange(students, (students.length/num)*(i),(students.length/num)*(i+1)));
		}
		return result; //Return the result: return result;
	}	
	
	//Todo(3) the decideTasks() method --- see Main_GivenCode.txt
	

	//assignment of lab tasks to teams based on user input
	private static Assignment[] decideTasks(Team[] teams, Scanner in)
	{
		Assignment[] assignments; //Define an array of assignments to store the result: Assignment[] assignments;
		assignments = new Assignment[teams.length]; //Create the array: new Assignment[5];
		
		String []assignmentName = new String[teams.length];
		System.out.println("\nEnter " + teams.length +  " task names (eg. \"Lab05 Lab06 Lab07 ..\"):");
		for(int i=0;i<teams.length;i++) {
			assignmentName[i] = in.next();
		}
		
		System.out.print("\nEnter tasks for the teams (");
		for(int i=0;i<teams.length;i++) {
			System.out.print(assignmentName[i]);
			if(i==teams.length-1) {
				System.out.print("): ");
			}else {
				System.out.print(",");
			}
		}
		
		
		for (int i=0; i<teams.length; i++)
		{
			System.out.print(teams[i].getName()+ ": "); //Prompt for a team: teams[i].getName()
			String taskName = in.next(); //Get user input of the task name from keyboard: in.next();
			assignments[i] = new Assignment (teams[i] ,new Task(taskName)); //Create the assignment for:  teams[i], new Task(taskName)
		}
		
		//Display sorted listing by tasks:
		System.out.println("\nSorted listing by tasks: ");
		for(int i=0;i<teams.length;i++) {

		Assignment.printTaskTeam(assignmentName[i], assignments);
			
		}
		
		
		return assignments; //Return the result: return assignments;
	}

	
	
}