public class Day {
	
	private int year;
	private int month;
	private int day;
	
	//Constructor
	public Day(int y, int m, int d) {
		this.year=y;
		this.month=m;
		this.day=d;		
	}
	
	// Return a string for the day like dd MMM yyyy
	public String toString() {
		
		final String[] MonthNames = {
				"Jan", "Feb", "Mar", "Apr",
				"May", "Jun", "Jul", "Aug",
				"Sep", "Oct", "Nov", "Dec"};
		
		return day+" "+ MonthNames[month-1] + " "+ year;
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
					 return d<=31; 	//return turn or false
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
	
	// check if the current object is the end of a month
	public boolean isEndOfAMonth() 
	{
		if (valid(year,month,day+1)) //A smart method: check whether (year month [day+1]) is still a valid date
			return false;
		else
			return true;
	}
	
	public boolean isStartOfAMonth() 
	{
		if (valid(year,month,day) && day == 1) //A smart method: check whether (year month [day+1]) is still a valid date
			return true;
		else
			return false;
	}
	
	// create and return a new Day object which is the "next day" of the current day object
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
	
	public Day previous() {
		if (isStartOfAMonth()) {
			if (month==1) 
				return new Day(year-1,12,31);
			else if (month-1==1 ||month-1==3 || month-1==5 || month-1==7|| month-1==8 || month-1==10)
				return new Day(year,month-1,31); 
			else if (month-1==4 || month-1==6 || month-1==9 || month-1==11)
				return new Day(year,month-1,30);
			else if (month-1==2 && isLeapYear(year))
				return new Day(year,month-1,29);
			else
				return new Day(year,month-1,28); 
			}
		else
			return new Day(year,month,day-1); 
		
	
	}
}