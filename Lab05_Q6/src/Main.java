

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{
		//Read input file pathname
		Scanner in = new Scanner(System.in); 
		System.out.print("Please enter the filename: ");
		String filepathname = in.next();
		
		
		StatisticsSystem ss = StatisticsSystem.getInstance();  
		ss.addCounter(new Counter());

		

		in.nextLine(); 
		System.out.print("\nEnter the area names (e.g. TaiPo YuenLong WongTaiSin KwunTong): ");
		String line = in.nextLine(); ; //Read a line: 
		Scanner scannerLine = new Scanner(line);; //Create the scanner for input from the string: 
		while (scannerLine.hasNext()) //Still have contents or not: hasNext()
			ss.addCounter(new AreaCounter(scannerLine.next())); //Area name is grabbed from the string: scannerLine.next()
		scannerLine.close(); //Close the scanner: close();


		int a = 0;
		int b = 0;
		do {
			System.out.print("\nEnter the age groups ('-1 -1' to end): ");
			a = in.nextInt();
			b = in.nextInt();
			
			if(a!=-1 && b!=-1) {
				ss.addCounter(new AgeGroupCounter(a,b));
			}
			
		}while(a!=-1 && b!=-1);
	
		
		//The ss will load file data and tell its counters to count 
		ss.countData(filepathname);		
		

		
		//The ss will tell its counters to report
		ss.report();
		

		
		in.close();
	}
}