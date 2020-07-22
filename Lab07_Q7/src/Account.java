


public abstract class Account {

	private String account_no;
	
	public String getAccountNumber() {
		return account_no;
	}
	
	Account(String number){
		account_no = number;
	}

	public String toString() 
	{
		return "Bank A/C Number: "+getAccountNumber();
	}
	
	
	public abstract double getTotal();
	
}
