public class CmdHire extends RecordedCommand //<=== note the change
{

	Employee e;
	
	@Override
	public void execute(String[] cmdParts)
	{
		try {
			if(cmdParts.length<3)
				throw new ExInsufficientArguments();
			
			if(Integer.parseInt(cmdParts[2]) < 0 || Integer.parseInt(cmdParts[2]) > 300)
				throw new ExAnnualLeavesRange();
			Company company = Company.getInstance();
			String name = cmdParts[1];
			int yrLeavesEntitled = Integer.parseInt(cmdParts[2]);

			e = company.createEmployee(name, yrLeavesEntitled);
			
			addUndoCommand(this);
			clearRedoList();
			System.out.println("Done.");
		} catch (NumberFormatException e) {
			System.out.println("Wrong number format!");
		} catch (ExEmployeeAlreadyExists e) {
			System.out.println("Employee already exists!");
		} catch(ExInsufficientArguments e) {
			System.out.println(e.getMessage());
		} catch(ExAnnualLeavesRange e) {
			System.out.println(e.getMessage());
		}

		
	}
	
	@Override
	public void undoMe()
	{
		Company company = Company.getInstance();
		company.deleteEmployee(e);
		addRedoCommand(this); 
	}
	
	@Override
	public void redoMe()
	{
		Company company = Company.getInstance();
		company.createEmployee(e);
		
		addUndoCommand(this); 
	}
}