import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(System.in);

		System.out.print("Please input the file pathname: ");
		String filepathname = in.nextLine();
		
		Scanner inFile = new Scanner(new File(filepathname));
		
		//The first command in the file must be to set the system date 
		//(eg. "startNewDay|01-Jan-2018"); and it cannot be undone
		String cmdLine1 = inFile.nextLine();
		String[] cmdLine1Parts = cmdLine1.split("\\|");
		System.out.println("\n> "+cmdLine1);
		SystemDate.createTheInstance(cmdLine1Parts[1]);
		
		while (inFile.hasNext())		
		{
			String cmdLine = inFile.nextLine().trim();
			
			//Blank lines exist in data file as separators.  Skip them.
			if (cmdLine.equals("")) continue;  

			System.out.println("\n> "+cmdLine);
			
			// split the words in actionLine => create an array of word strings
			// http://stackoverflow.com/questions/5675704/java-string-split-not-returning-the-right-values
			// https://community.oracle.com/thread/2084308
			String[] cmdParts = cmdLine.split("\\|"); 
			
			if (cmdParts[0].equals("hire"))
				(new CmdHire()).execute(cmdParts);
			if (cmdParts[0].equals("listEmployees"))
				(new CmdListEmployees()).execute(cmdParts);
			if (cmdParts[0].equals("undo")) {
				if(RecordedCommand.getUndoSize()>0)
					RecordedCommand.undoOneCommand();
				else
					System.out.println("Nothing to undo.");
			}
			if (cmdParts[0].equals("redo")) {
				if(RecordedCommand.getRedoSize()>0)
					RecordedCommand.redoOneCommand();
				else
					System.out.println("Nothing to redo.");
			}
				
		}
		inFile.close();
			
		in.close();
	}
}