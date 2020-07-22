
public class Group {
	private int count;
	private Customer[] customerList;
	
	public Group() {
		count = 0;
		customerList = new Customer[10];
	}
	
	public void add(Customer c) {
		customerList[count] = c;
		count++;
	}
	
	public void spend(int money) {
		int moneyForEach = money/count;
		for (int i = 0; i < count; i++) {
			customerList[i].spend(moneyForEach);
		}
	}
}
