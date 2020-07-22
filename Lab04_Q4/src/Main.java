import java.util.*;

public class Main
{
	// Show the digits of integer x reversely (each followed by a space). 	
	static void showDigitsReverse(int x) //567 => 7 6 5
	{	if(x<10) {
		System.out.print(x+" ");
		}else {
			int leading = x/10;	
			int right_most = x%10;	
			System.out.print(right_most+" "); 
			showDigitsReverse(leading);	// 56 => 76
			
		}
	

	}
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x;
		System.out.print("input x (-1 to end) : "); x=s.nextInt();

		while (x!=-1)
		{
			showDigitsReverse(x);
			
			System.out.println();
			
			System.out.print("input x (-1 to end) : "); x=s.nextInt();
		}

		s.close();
	}
}