
public class CmdStartNewDay extends RecordedCommand{
	private String newDate;
	private String previousDate;
	
	@Override
	public void execute(String[] cmdParts)
	{
		try {
			if(cmdParts.length<2)
				throw new ExInsufficientArguments();
			
			SystemDate s = SystemDate.getInstance();
			previousDate = s.getDate();
			newDate = cmdParts[1];
			s.set(newDate);
			
			addUndoCommand(this);
			clearRedoList();

			System.out.println("Done.");
		} catch (ExInsufficientArguments e) {
			e.getMessage();
		}
	}
	
	@Override
	public void undoMe() {
		SystemDate s = SystemDate.getInstance();
		s.set(previousDate);
		addRedoCommand(this); 
	}
	
	@Override
	public void redoMe() {
		SystemDate s = SystemDate.getInstance();
		s.set(newDate);
		addUndoCommand(this);
	}
}
