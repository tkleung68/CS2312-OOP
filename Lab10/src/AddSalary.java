public class AddSalary extends RecordedCommand //<=== note the change
{
	//When addSalary is invoked, an object of the AddSalary class will be 
	// added to the undo list (and may also be stored in the redo list later)
	//We add instance fields in the objects to store the data which will be needed upon undo/redo
	Employee e;
	int addAmount; 
	
	@Override
	public void execute(String[] cmdParts)
	{
		
		try {
			
			if(cmdParts.length < 3)
				throw new ExInsufficientArguments();
			
			Company company = Company.getInstance();
			e = company.findEmployee(cmdParts[1]);
			addAmount=Integer.parseInt(cmdParts[2]);

			e.addSalary(addAmount);

			addUndoCommand(this);
			clearRedoList(); 
			System.out.println("Done.");
		} catch (NumberFormatException e) {
			System.out.println("Wrong number format!");
		} catch (ExEmployeeNotFound e) {
			System.out.println(e.getMessage());
		} catch(ExInsufficientArguments e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void undoMe()
	{
		e.addSalary(-addAmount);
		addRedoCommand(this); 
	}
	
	@Override
	public void redoMe()
	{
		e.addSalary(addAmount);
		addUndoCommand(this); 
	}
}