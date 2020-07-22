import java.util.ArrayList;

public class CmdTakeLeaves extends RecordedCommand{
	Employee employee;
	LeaveRecord leaveRecord;
	ArrayList<ActingHead> allActingHeads = new ArrayList<>();
	
	
	@Override
	public void execute(String[] cmdParts)
	{
		
		try {
			if(cmdParts.length<3)
				throw new ExInsufficientArguments();
			
			Company company = Company.getInstance();
			employee = company.searchEmployee(cmdParts[1]);
			leaveRecord = new LeaveRecord(new Day(cmdParts[2]),new Day(cmdParts[3]));
				
			if(leaveRecord.countDay() > employee.getDay())
				throw new ExInsufficientBalance();
			
			if(leaveRecord.getStart().compareTo(SystemDate.getInstance()) == -1 || leaveRecord.getEnd().compareTo(SystemDate.getInstance()) == -1)
				throw new ExWrongDate();
			
			ArrayList<ActingHead> tempActingHeads = new ArrayList<>();
			for(Team t: company.getTeamByEmployee(employee)) {
				int key = 4;
				
				while(key < cmdParts.length && !cmdParts[key].equals(t.getTeamName()))
					key = key +2;
			
				if(key >=cmdParts.length)
					throw new ExInsufficientArguments("Please name a member to be the acting head of " + t.getTeamName());
				

				
				if(t.searchTeammates(cmdParts[key+1]) == null) 
					throw new ExEmployeeNotFound("Employee (" + cmdParts[key+1] + ") not found for " + t.getTeamName() + "!");
				
				ActingHead actingHead = new ActingHead(t.searchTeammates(cmdParts[key+1]),t,leaveRecord);
				tempActingHeads.add(actingHead);
				
			}
			

			
			
			employee.takeLeave(leaveRecord);
			allActingHeads = tempActingHeads;
			int i = 0;
			for(Team t: company.getTeamByEmployee(employee)) {
				t.setActingHead(tempActingHeads.get(i));
				tempActingHeads.get(i).getActingHead().addActingHead(tempActingHeads.get(i));
				i++;
			}
		
			

			
			addUndoCommand(this);
			clearRedoList();
			System.out.println("Done.");
			
		} catch(ExInsufficientArguments e) {
			System.out.println(e.getMessage());
		} catch(ExWrongDate e) {
			System.out.printf("Wrong Date.   System date is already %s!\n",SystemDate.getInstance().toString());
		} catch(ExInsufficientBalance e) {
			System.out.printf("Insufficient balance.  %d days left only!\n", employee.getDay());
		} catch(ExOverlapLeave e) {
			System.out.println(e.getMessage());
		} catch (ExEmployeeNotFound e) {
			System.out.println(e.getMessage());
		} catch (ExOverlapActingHead e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void undoMe()
	{
		
		employee.removeLeave(leaveRecord);
		for(ActingHead head:allActingHeads) {
			Team t = head.getTeam();
			t.removeActingHead(head);
			head.getActingHead().removeActingHead(head);
			
		}
		
		addRedoCommand(this); 
	}
	
	@Override
	public void redoMe()
	{
		try {
			employee.takeLeave(leaveRecord);
			for(ActingHead head:allActingHeads) {
				Team t = head.getTeam();
				t.setActingHead(head);
				head.getActingHead().addActingHead(head);
			}
			
			addUndoCommand(this);
		} catch (ExOverlapLeave e) {
			System.out.println(e.getMessage());
		} catch (ExOverlapActingHead e) {
			System.out.println(e.getMessage());
		} 
	}
}
