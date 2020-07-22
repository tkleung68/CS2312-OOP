
public class CmdStartNewDay extends RecordedCommand{
	String Date;
	String Previous;
	
	@Override
	public void execute(String[] cmdParts)
	{
		SystemDate s = SystemDate.getInstance();
		Previous = s.getDate();
		Date = cmdParts[1];
		s.set(Date);
		
		addUndoCommand(this); //<====== store this command (addUndoCommand is implemented in RecordedCommand.java)
		clearRedoList(); //<====== There maybe some commands stored in the redo list.  Clear them.

		System.out.println("Done.");
	}
	
	@Override
	public void undoMe() {
		SystemDate s = SystemDate.getInstance();
		s.set(Previous);
		addRedoCommand(this); 
	}
	
	@Override
	public void redoMe() {
		SystemDate s = SystemDate.getInstance();
		s.set(Date);
		addUndoCommand(this);
	}
}
