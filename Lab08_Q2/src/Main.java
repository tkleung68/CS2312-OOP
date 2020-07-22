import java.util.*;
import java.io.*;

public class Main {
 public static void main(String[] args) throws FileNotFoundException {
	 Company c = Company.getInstance(); 
	 String pathname;
	 System.out.print("Please input the file pathname: ");
	 Scanner in = new Scanner(System.in);
	 
	 pathname = in.next();
	 
	 Scanner inFile = new Scanner(new File(pathname));
	 int tot = inFile.nextInt();
	 for(int i=0;i< tot;i++) {
		 String name = inFile.next();
		 int salary = inFile.nextInt();
		 int leaves = inFile.nextInt();
		 c.addEmployee(new Employee(name,salary,leaves));
	 }
	 
	 while (inFile.hasNext())		
		{
			String cmdLine = inFile.nextLine();
			
			//Blank lines exist in data file as separators.  Skip them.
			if (cmdLine.equals("")) continue;  
			
			System.out.println("\n> "+cmdLine);
			
			//split the words in actionLine => create an array of word strings [!!! LEARN !!!]
			String[] cmdParts = cmdLine.split(" "); 
			
			if (cmdParts[0].equals("addSalary"))
				(new AddSalary()).execute(cmdParts);
			if (cmdParts[0].equals("list"))
				(new ListAllRecords()).execute(cmdParts);
			if (cmdParts[0].equals("undo"))
				RecordedCommand.undoOneCommand();
			if (cmdParts[0].equals("redo"))
				RecordedCommand.redoOneCommand();

		}
	 

	 
	inFile.close();			
	in.close();
 }
}
