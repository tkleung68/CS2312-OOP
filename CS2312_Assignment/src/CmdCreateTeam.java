public class CmdCreateTeam extends RecordedCommand{

	Team t;
	
	@Override
	public void execute(String[] cmdParts)
	{
		
		try {
			if(cmdParts.length<3)
				throw new ExInsufficientArguments();
			
			Company company = Company.getInstance();
			String teamName = cmdParts[1];
			String head = cmdParts[2];
			t = company.createTeam(teamName, head);
			
			addUndoCommand(this); 
			clearRedoList();

			System.out.println("Done.");
		} catch (ExEmployeeNotFound e) {
			System.out.println(e.getMessage());
		} catch (ExInsufficientArguments e) {
			System.out.println(e.getMessage());
		} catch (ExTeamAlreadyExists e){
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void undoMe() {
		Company company = Company.getInstance();
		company.deleteTeam(t);
		
		addRedoCommand(this); 
		
	}
	
	@Override
	public void redoMe() {
		try {
			Company company = Company.getInstance();
			company.createTeam(t);
			addUndoCommand(this);
		} catch (ExEmployeeNotFound e) {
			System.out.println(e.getMessage());
		} catch (ExTeamAlreadyExists e) {
			System.out.println(e.getMessage());
		}
	}
	
}
