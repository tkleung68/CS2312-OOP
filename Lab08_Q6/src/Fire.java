
public class Fire extends RecordedCommand {

	Employee e;

	
	@Override
	public void execute(String[] cmdParts)
	{
		Company company = Company.getInstance();
		e = company.findEmployee(cmdParts[1]);

		
		addUndoCommand(this); //<====== store this command (addUndoCommand is implemented in RecordedCommand.java)
		clearRedoList(); //<====== There maybe some commands stored in the redo list.  Clear them.

		company.removeEmployee(e);
		System.out.println("Done.");
	}
	
	@Override
	public void undoMe()
	{
		Company company = Company.getInstance();
		company.addEmployee(e);
		addRedoCommand(this); //<====== upon undo, we should keep a copy in the redo list (addRedoCommand is implemented in RecordedCommand.java)
	}
	
	@Override
	public void redoMe()
	{
		Company company = Company.getInstance();
		company.removeEmployee(e);
		addUndoCommand(this); //<====== upon redo, we should keep a copy in the undo list
	}
}