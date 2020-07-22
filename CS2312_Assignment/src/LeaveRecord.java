
public class LeaveRecord implements Comparable<LeaveRecord>{
	private Day start;
	private Day end;
	
	public LeaveRecord(Day start,Day end) {
		this.start = start;
		this.end = end;
	}
	
	public String toString() {
		return  start.toString() + " to " + end.toString();
	}
	
	public int countDay() {
		return start.countDay(end);
	}
	
	public Day getStart() {
		return start;
	}
	
	public Day getEnd() {
		return end;
	}
	
	public boolean isOverlapWithPeriod(LeaveRecord record) {
    	Day s = this.getStart().clone();
    	Day ps = record.getStart().clone();
    	
    	for(int i =0;i<this.countDay()+1;i++) {
    		ps = record.getStart().clone();
    		for(int j=0;j<record.countDay()+1;j++) {
    			
    				if(s.compareTo(ps) ==0)
    				return true;
    			ps = ps.next();
    		}
    		s = s.next();
    	}
    	return false;
	}

	@Override
	public int compareTo(LeaveRecord o) {
		return start.compareTo(o.getStart());
	}
}
