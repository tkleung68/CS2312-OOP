import java.util.*;
import java.io.*;

public class Main{
	
	//Add the method called findAccount
	private static Account findAccount(ArrayList<Account> acs, String account_no) {
		for(int i=0;i<acs.size();i++) {
			if(acs.get(i).getAccountNumber().equals(account_no)) 
				return acs.get(i);
		
		}
		return null;
	}
	
	
	
	
	public static void main(String [] args) throws FileNotFoundException
	{	
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please input the file pathname: ");
		String filepathname = in.nextLine();
		
		ArrayList<Account> acs = new ArrayList<>();
		
		Scanner infile = new Scanner(new File(filepathname));
		
		while(infile.hasNext()) {
			String temp = infile.next();
	
			if(temp.charAt(0) >= '0' && temp.charAt(0) <= '5') {
				double value = infile.nextDouble();
				acs.add(new SavingsAccount(temp,value));
			}else if(temp.charAt(0) >= '6' && temp.charAt(0) <='8') {
				double value1 = infile.nextDouble();
				double value2 = infile.nextDouble();
				acs.add(new CreditCardAccount(temp,value1, value2));
			}else if(temp.charAt(0) == '9') {
				
				PowerAdvantageAccount ac2 = new PowerAdvantageAccount(temp, (SavingsAccount)findAccount(acs, infile.next()), (CreditCardAccount)findAccount(acs, infile.next()));
				acs.add(ac2);
			}
			
			
		}
		
		
		infile.close();
		System.out.print("\nInput an account number to search: ");
		String target = "";
		target = in.next();
		
		if (findAccount(acs,target)!=null)
			System.out.println("\n[Result]\n"+ findAccount(acs,target).toString());
		else
			System.out.println("\n[Result]\nThe account is not found.");
			
		in.close();
	}
}
