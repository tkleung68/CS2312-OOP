import java.io.*; //For file I/O
import java.util.*;

public class Table2dMxSumRowCol 
{

	//(1) Add the instance field, nums, for the 2D array here
	private int[][] nums;

	
	//Constructor
	public Table2dMxSumRowCol(String filepathname) throws FileNotFoundException //learn exceptions later
	{
		//Part I. Create the 2D array
		nums = new int[10][10];

		
		//Part II. Perform file reading and insert values into the 2D array
		Scanner inFile = new Scanner(new File(filepathname)); //(3) construct the scanner object for file reading

		// (4) read the file until the end and add values 
		while (inFile.hasNext()) //replace the blank with: inFile.hasNext()
		{
			int row, col, value;
			row = inFile.nextInt();
			col = inFile.nextInt();
			value = inFile.nextInt();
			nums[row][col] = value ; //Note: should be [row][col], do not change the order
		}
		inFile.close();
	}
	
	public void print() {

		/* For each row, we print the columns in that row.

		   Note: row and column are easily mixed up.
			To avoid careless mistake, readability is important.
			Use meaningful variable names like row,col or r,c, or y,x etc. 
			Do not use i,j. 
		*/

		for (int row=0; row<10; row++) 
		{
			for (int col=0; col<10; col++)
			{
				System.out.print("\t"+nums[row][col]); //separated by tabs
			}
			System.out.println();
		}
	}	

	
	public int getRowSumMax(){
		int max = 0;
		
		for (int i=0;i< 10; i++) {
			int sum = 0;
			for(int j=0;j<10;j++) {
				sum = nums[i][j] + sum;
			}
			if (sum>max) {
				max = sum;
			}
		}
		return max; 
	}
	
	public int getColSumMax(){
		int max = 0;
		
		for (int i=0;i< 10; i++) {
			int sum = 0;
			for(int j=0;j<10;j++) {
				sum = nums[j][i] + sum;
			}
			if (sum>max) {
				max = sum;
			}
		}
		return max; 
	}
	
	public void printAllRowsOfMax() {
		int max = getRowSumMax();
		int count = 0;
		System.out.print(" (row ");
		for (int i=0;i< 10; i++) {
			int sum = 0;
			for(int j=0;j<10;j++) {
				sum = nums[i][j] + sum;
			}
			if (sum==max) {
				if(count>0) {
					System.out.print(",");
				}
				System.out.print(i);
				count++;
			}
	}
		System.out.println(")");
	}

	public void printAllColOfMax() {
		int max = getColSumMax();
		int count = 0;
		System.out.print(" (col ");
		for (int i=0;i< 10; i++) {
			int sum = 0;
			for(int j=0;j<10;j++) {
				sum = nums[j][i] + sum;
			}
			if (sum==max) {
				if(count>0) {
					System.out.print(",");
				}
				System.out.print(i);
				count++;
			}
	}
		System.out.println(")");
	}
	
}