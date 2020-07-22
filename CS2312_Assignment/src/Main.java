import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(System.in);

		System.out.print("Please input the file pathname: ");
		String filepathname = in.nextLine();
		
		Scanner inFile = null;
		
		try {
			inFile = new Scanner(new File(filepathname));

			String cmdLine1 = inFile.nextLine();
			String[] cmdLine1Parts = cmdLine1.split("\\|");
			System.out.println("\n> "+cmdLine1);
			SystemDate.createTheInstance(cmdLine1Parts[1]);
			
			while (inFile.hasNext())		
			{
				String cmdLine = inFile.nextLine().trim();
				
				if (cmdLine.equals("")) continue;  

				System.out.println("\n> "+cmdLine);

				String[] cmdParts = cmdLine.split("\\|"); 
				
				if (cmdParts[0].equals("hire"))
					(new CmdHire()).execute(cmdParts);
				else if (cmdParts[0].equals("listEmployees"))
					(new CmdListEmployees()).execute(cmdParts);
				else if (cmdParts[0].equals("undo")) {
					if(RecordedCommand.getUndoSize()>0)
						RecordedCommand.undoOneCommand();
					else
						System.out.println("Nothing to undo.");
				}
				else if (cmdParts[0].equals("redo")) {
					if(RecordedCommand.getRedoSize()>0)
						RecordedCommand.redoOneCommand();
					else
						System.out.println("Nothing to redo.");
				}
				else if(cmdParts[0].equals("setupTeam"))
					(new CmdCreateTeam()).execute(cmdParts);
				else if(cmdParts[0].equals("listTeams")) 
					(new CmdListTeam()).execute(cmdParts);
				else if(cmdParts[0].equals("startNewDay"))
					(new CmdStartNewDay()).execute(cmdParts);
				else if(cmdParts[0].equals("takeLeave"))
					(new CmdTakeLeaves()).execute(cmdParts);
				else if(cmdParts[0].equals("listLeaves"))
					(new CmdListLeaves()).execute(cmdParts);
				else if(cmdParts[0].equals("addTeamMember"))
					(new CmdAddTeamMember()).execute(cmdParts);
				else if(cmdParts[0].equals("listRoles"))
					(new CmdListRoles()).execute(cmdParts);
				else if(cmdParts[0].equals("listTeamMembers"))
					(new CmdListTeamMembers()).execute(cmdParts);
				else
					throw new ExWrongCommand();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (InputMismatchException e) {
			System.out.println("File content problem. Program terminated.");
		} catch (ExWrongCommand e) {
			System.out.println("Unknown command - ignored!");
		}finally {
			if(inFile!=null)
				inFile.close();
			in.close();
		} 

	}
}