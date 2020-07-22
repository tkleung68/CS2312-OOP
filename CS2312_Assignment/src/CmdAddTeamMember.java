
public class CmdAddTeamMember extends RecordedCommand{
	Employee e;
	Team t;
	
	public void execute(String[] cmdParts)
	{
		try {
			if(cmdParts.length<3)
				throw new ExInsufficientArguments();
			Company company = Company.getInstance();
			t = company.searchTeamByName(cmdParts[1]);
			e = company.searchEmployee(cmdParts[2]);
			
			if(t.searchTeammates(e.getName()) != null)
				throw new ExEmployeeAlreadyJoined();
			
			t.addTeamMember(e);
			addUndoCommand(this);
			clearRedoList();
			System.out.println("Done.");
		} catch (ExInsufficientArguments e) {
			System.out.println(e.getMessage());
		} catch (ExEmployeeAlreadyJoined e) {
			System.out.println(e.getMessage());
		} catch (ExTeamNotFound e) {
			System.out.println(e.getMessage());
		} catch (ExEmployeeNotFound e) {
			System.out.println(e.getMessage());
		} 
		
	}

	@Override
	public void undoMe()
	{
		t.deleteTeamMember(e);
		addRedoCommand(this); 
	}
	
	@Override
	public void redoMe()
	{
		t.addTeamMember(e);
		addUndoCommand(this); 
	}
}
