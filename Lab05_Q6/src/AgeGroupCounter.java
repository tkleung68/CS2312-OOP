
public class AgeGroupCounter extends Counter{
	
	
	private int start;
	private int end;
	
	public AgeGroupCounter(int a, int b)
	{
		start = a;
		end = b;
	}
	
	public void countData(Record r) {
		if (r.getAge()>=start && r.getAge()<=end)
			super.countData(r);
	}
	

	public String toString()
	{
		return String.format("[Age %d to %d] Count = %d", start, end, getCount());
	}
}
