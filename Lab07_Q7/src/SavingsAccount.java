/*
Add the class called SavingsAccount 
It should extend the superclass: Account 

Given code for strings:
 return "Savings A/C Number: "+_________________+
				" Balance: $"+String.format("%.2f",______________);

*/

public class SavingsAccount extends Account {
	private double balance;
	
	SavingsAccount(String number, double value){
		super(number);
		balance = value;
	}
	
	public String getAC() {
		return super.getAccountNumber();
	}
	
	public String toString() {
		return "Savings A/C Number: " + getAC() + 
				" Balance: $" +String.format("%.2f", balance);
	}
	
	
	public double getTotal() {
		return balance;
	}
}