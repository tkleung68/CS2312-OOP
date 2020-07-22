public class Day implements Cloneable,Comparable<Day>{
	
	private int year;
	private int month;
	private int day;
	private static final String MonthNames="JanFebMarAprMayJunJulAugSepOctNovDec";
	
	//Constructor
	public Day(String sDay) {
		set(sDay);
	}
	
    public Day(int y, int m, int d) {
        this.year=y;
        this.month=m;
        this.day=d;     
    }
	
	// check if a given year is a leap year
	static public boolean isLeapYear(int y)
	{
		if (y%400==0)
			return true;
		else if (y%100==0)
			return false;
		else if (y%4==0)
			return true;
		else
			return false;
	}
	
	// check if y,m,d valid
	static public boolean valid(int y, int m, int d)
	{
		if (m<1 || m>12 || d<1) return false;
		switch(m){
			case 1: case 3: case 5: case 7:
			case 8: case 10: case 12:
					 return d<=31; 
			case 4: case 6: case 9: case 11:
					 return d<=30; 
			case 2:
					 if (isLeapYear(y))
						 return d<=29; 
					 else
						 return d<=28; 
		}
		return false;
	}

	// Return a string for the day like dd MMM yyyy
	public String toString() {

		return day+"-"+ MonthNames.substring(month*3-3,(month*3))+"-" + year;
	}
	
	public void set(String sDay) {
		String[] sDayParts = sDay.split("-");
		this.day = Integer.parseInt(sDayParts[0]);
		this.year =  Integer.parseInt(sDayParts[2]);
		this.month = MonthNames.indexOf(sDayParts[1])/3+1;
	}
	
	@Override
	public Day clone() {
		Day copy = null;
		try {
			copy = (Day) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return copy;
	}
	

	public int compareTo(Day another) {
		if(this.year == another.year && this.month == another.month && this.day == another.day) return 0;
		else if (this.year > another.year) return 1;
		else if (this.year == another.year && this.month > another.month) return 1;
		else if (this.year == another.year && this.month == another.month && this.day > another.day) return 1;
		else return -1;
	}
	
	public int countDay(Day another) {
		int count = 0;
		Day start = this.clone();
		while(start.compareTo(another) != 0 ) {
			count++;
			start = start.next();
		}
		
		return count;
	}
	
    public boolean isEndOfAMonth() 
    {
        if (valid(year,month,day+1)) //A smart methd: check whether (year month [day+1]) is still a valid date
            return false;
        else
            return true;
    }
     
    public Day next()
    {
        if (isEndOfAMonth())
            if (month==12)
                return new Day(year+1,1,1); //Since the current day is the end of the year, the next day should be Jan 01
            else
                return new Day(year,month+1,1); // <== your task: first day of next month
        else
            return new Day(year,month,day+1); // <== your task: next day of current month
    }
    
    public boolean isOverlapWithPeriod(Day end,Day periodStart, Day periodEnd) {
    	Day s = this.clone();
    	Day ps = periodStart.clone();
    	
    	for(int i =0;i<this.countDay(end)+1;i++) {
    		ps = periodStart.clone();
    		for(int j=0;j<periodStart.countDay(periodEnd)+1;j++) {
    			
    				if(s.compareTo(ps) ==0)
    				return true;
    			ps = ps.next();
    		}
    		s = s.next();
    	}
    	return false;
    }
	
	 
}