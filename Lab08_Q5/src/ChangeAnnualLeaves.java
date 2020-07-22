
public class ChangeAnnualLeaves extends RecordedCommand {

	Employee e;
	int days;
	int previous;
	
	@Override
	public void execute(String[] cmdParts)
	{
		Company company = Company.getInstance();
		e = company.findEmployee(cmdParts[1]);
		previous = e.getAnnualleaves();
		days=Integer.parseInt(cmdParts[2]);

		e.changeLeave(days);
		
		addUndoCommand(this); //<====== store this command (addUndoCommand is implemented in RecordedCommand.java)
		clearRedoList(); //<====== There maybe some commands stored in the redo list.  Clear them.


		System.out.println("Done.");
	}
	
	@Override
	public void undoMe()
	{
		e.changeLeave(previous);
		addRedoCommand(this); //<====== upon undo, we should keep a copy in the redo list (addRedoCommand is implemented in RecordedCommand.java)
	}
	
	@Override
	public void redoMe()
	{
		e.changeLeave(days);
		addUndoCommand(this); //<====== upon redo, we should keep a copy in the undo list
	}
}