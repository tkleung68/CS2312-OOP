
public class ActingHead implements Comparable<ActingHead>{
	private Employee actingHead;
	private Team team;
	private LeaveRecord record;

	public ActingHead(Employee e, Team t, LeaveRecord d) {
		actingHead = e;
		team = t;
		record = d;
	}
	
	public Team getTeam() {
		return team;
	}
	
	public Employee getActingHead() {
		return actingHead;
	}

	public LeaveRecord getLeaveRecord() {
		return record;
	}

	@Override
	public int compareTo(ActingHead o) {
		
		return this.record.compareTo(o.getLeaveRecord());
	}
}
