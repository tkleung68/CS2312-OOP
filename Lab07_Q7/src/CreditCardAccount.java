/*
Add the class called CreditCardAccount 
It should extend the superclass: Account 

Given code for strings:


*/

public class CreditCardAccount extends Account {
	private double balance;
	private double creditlimit;
	
	CreditCardAccount(String number, double value, double cl) {
		super(number);
		balance = value;
		creditlimit = cl;
	}
	
	public String toString() {
		 return "Credit Card A/C Number: "+ super.getAccountNumber()+
					" Balance: $"+String.format("%.2f", balance)+
					" Credit limit: $"+String.format("%.2f",creditlimit);
	}
	
	public double getTotal() {
		return balance;
	}
}

