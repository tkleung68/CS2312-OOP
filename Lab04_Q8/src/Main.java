import java.util.*;

public class Main
{
	
	// Determine whether integer x contains non-decreasing digits (eg. 1234, 14789, 224466)
	//i.e., whether the sequence of digits is "sorted" in ascending order.
	
	static boolean containNonDecreasingDigits(int x) // 132 => false
	{	
		if(x<10) {
			return true;
		}else {
			boolean m1 = containNonDecreasingDigits(x/10); //13 => true
				int r1 = x%10;
				int r2 = (x/10)%10;
				return (r1>=r2 && m1);
		}
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x;
		System.out.print("input x (-1 to end) : "); x=s.nextInt();

		while (x!=-1)
		{
			if (containNonDecreasingDigits(x)) 
				System.out.println("true");
			else
				System.out.println("false");
			
			System.out.print("input x (-1 to end) : "); x=s.nextInt();
		}

		s.close();
	}
}