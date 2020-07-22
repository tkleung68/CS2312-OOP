
public class ExchangeSalaries extends RecordedCommand {

	Employee e;
	Employee e2;
	int s1;
	int s2;
	
	@Override
	public void execute(String[] cmdParts)
	{
		Company company = Company.getInstance();
		e = company.findEmployee(cmdParts[1]);
		e2 = company.findEmployee(cmdParts[2]);

		s1 = e.getSalary();
		s2 = e2.getSalary();
		
		e.changeSalary(s2);
		e2.changeSalary(s1);
		
		addUndoCommand(this); //<====== store this command (addUndoCommand is implemented in RecordedCommand.java)
		clearRedoList(); //<====== There maybe some commands stored in the redo list.  Clear them.


		System.out.println("Done.");
	}
	
	@Override
	public void undoMe()
	{
		e.changeSalary(s1);
		e2.changeSalary(s2);
		
		addRedoCommand(this); //<====== upon undo, we should keep a copy in the redo list (addRedoCommand is implemented in RecordedCommand.java)
	}
	
	@Override
	public void redoMe()
	{
		e.changeSalary(s2);
		e2.changeSalary(s1);
		
		addUndoCommand(this); //<====== upon redo, we should keep a copy in the undo list
	}
}