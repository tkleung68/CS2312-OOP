import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner in = new Scanner(System.in); //create a scanner object for keyboard input

		System.out.print("Please enter the filename: ");
		String filepathname = in.next(); //Read user input: in.next();
		
		Day[] days= Day.createDayListFromFile(filepathname);// days = results
		
		System.out.println("\nValid dates: ");
		for (int i=0; i<days.length;i++)
			if (days[i].valid())
				System.out.println(days[i].toString());

		/* Print the invalid dates (finish this part on your own) */
		System.out.println("\nInvalid dates: ");
		for (int i=0; i<days.length;i++)
			if (!days[i].valid())
				System.out.println(days[i].getDay() + "/" + days[i].getMonth() + "/" + days[i].getYear());
		





		in.close();
	}
}