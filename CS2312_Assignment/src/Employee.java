import java.util.*;
import java.util.Collections;
public class Employee implements Comparable<Employee>{

	
	private String name;
	private int yrLeavesEntitled;
	private ArrayList<LeaveRecord> takeLeaveList;
	private ArrayList<ActingHead> allActingHeads;
	
	public String getName() {
		return name;
	}
	
	public static Employee searchEmployee(ArrayList<Employee> list, String nameToSearch) {
		for(Employee e:list) {
			if(e.getName().equals(nameToSearch)) {
				return e;
			}
		}
		
		return null;
	}
	
	public Employee(String n, int yle) {
		name = n;
		yrLeavesEntitled = yle;
		takeLeaveList = new ArrayList<>();
		allActingHeads = new ArrayList<>();
	}
	
	@Override
	public int compareTo(Employee another) {
		if(this.name.equals(another.name)) return 0;		
		else if (this.name.compareTo(another.name)>0) return 1;
		else return -1;
	}
	
	public int getDay() {
		return yrLeavesEntitled;
	}
	
	public void takeLeave(LeaveRecord record) throws ExOverlapLeave, ExOverlapActingHead{
		for(LeaveRecord l:takeLeaveList) {
			if(record.isOverlapWithPeriod(l))
				throw new ExOverlapLeave("Overlap with leave from " + l.getStart().toString() + " to " + l.getEnd().toString()  +"!");
		}
		
		for(ActingHead actingHead:allActingHeads) {
			if(actingHead.getLeaveRecord().isOverlapWithPeriod(record))
				throw new  ExOverlapActingHead("Cannot take leave. "  + actingHead.getActingHead().getName() + " is the acting head of " + actingHead.getTeam().getTeamName() + " during " + actingHead.getLeaveRecord().toString() +"!");
		}
		
		takeLeaveList.add(record);
		yrLeavesEntitled = yrLeavesEntitled - record.countDay() - 1;
		Collections.sort(takeLeaveList);
	}
	
	public void removeLeave(LeaveRecord record) {
		takeLeaveList.remove(record);
		yrLeavesEntitled = yrLeavesEntitled + record.countDay() +1;
		
	}
	public void listLeavesTaken() {
		for(LeaveRecord l:takeLeaveList) {
			System.out.printf("%s to %s\n",l.getStart().toString(),l.getEnd().toString());
		}
	}
	public LeaveRecord getLeavesByPeriod(int x) {
		return takeLeaveList.get(x);
	}
	
	public int getLeavesTakan() {
		return takeLeaveList.size();
	}
	
	public void addActingHead(ActingHead actingHead) {
		allActingHeads.add(actingHead);
	}
	
	public void removeActingHead(ActingHead actingHead) {
		allActingHeads.remove(actingHead);
	}
	
}
