public class CmdCreateTeam extends RecordedCommand{

	String teamName;
	String head;
	
	@Override
	public void execute(String[] cmdParts)
	{
		//Note: In Q1, e and addAmount were local variables.  But now they are the data in the object (instance fields).
		Company company = Company.getInstance();
		teamName = cmdParts[1];
		head = cmdParts[2];
		company.createTeam(teamName, head);

		
		addUndoCommand(this); //<====== store this command (addUndoCommand is implemented in RecordedCommand.java)
		clearRedoList(); //<====== There maybe some commands stored in the redo list.  Clear them.

		System.out.println("Done.");
	}
	
	@Override
	public void undoMe() {
		Company company = Company.getInstance();
		company.deleteTeam(teamName, head);
		
		addRedoCommand(this); 
		
	}
	
	@Override
	public void redoMe() {
		Company company = Company.getInstance();
		company.createTeam(teamName, head);
		addUndoCommand(this);
	}
	
}
