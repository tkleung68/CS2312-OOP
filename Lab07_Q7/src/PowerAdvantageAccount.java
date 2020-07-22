public class PowerAdvantageAccount extends Account {
	
	private SavingsAccount savingsAC;
	private CreditCardAccount creditCardAC;
	
	PowerAdvantageAccount(String mainac, SavingsAccount account, CreditCardAccount account2) {
		super(mainac);
		savingsAC = account;
		creditCardAC = account2;
	}
	
	
	
	public String toString() {
		return "Power Advantage A/C Number: "+ super.getAccountNumber() +" Balance: $"+ String.format("%.2f", getTotal()) +
				"\n 1."+ savingsAC.toString() +
				"\n 2."+ creditCardAC.toString();
	}
	
	public double getTotal() {
		return savingsAC.getTotal() - creditCardAC.getTotal();
	}
	 

	
}