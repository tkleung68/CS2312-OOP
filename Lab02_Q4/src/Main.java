import java.io.FileNotFoundException; //We will learn exceptions later
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException //We will learn exceptions later
	{
		System.out.print("Please input the file pathname: ");

		Scanner scannerObj = new Scanner(System.in);
		String filePathName = scannerObj.nextLine();
		
		Table2dMxSumRowCol t = new Table2dMxSumRowCol(filePathName);
		//Your tasks: 
		//  Create a new Table2dMxSumRowCol object and assign it to a variable of Table2dMxSumRowCol 
		//      Call its constructor with the filePathName as argument 
		//  Then apply the .print(), .getRowSumMax() and 
		//      .getColSumMax() methods to finish the work.
		//
		t.print();
		System.out.print("Maximum row sum: " + t.getRowSumMax());
		t.printAllRowsOfMax();
		System.out.print("Maximum col sum: " + t.getColSumMax());
		t.printAllColOfMax();
		scannerObj.close();
	}
	
}