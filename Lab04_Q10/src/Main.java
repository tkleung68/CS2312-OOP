import java.util.*;

public class Main
{
	
		static int tail(int x) //123 => 23
		{	
			if(x<100) {
				return x%10;
			}else {
				int m1 = tail(x/10); //12 => 2
				return (m1*10+x%10);
			}
	}
	
	static int leftMostDigit(int x) //31=>3
	{	
		if(x<10) {
			return x;
		}else {
			int m1 = leftMostDigit(x/10); //3=>3
			return m1;
		}
	}
	

	// Determine whether the sequences of digits in 2 integers (without the 0 digit) are opposite to one another (eg. 123 and 321)
	static boolean areOpposite(int x1, int x2) // 468 861 true
	{	
		if(x1<10 || x2<10) {		
			return (leftMostDigit(x1)==x2%10);
		}else {
			boolean m1 = areOpposite(tail(x1),(x2- x2%10)/10); // 68 86 =>true
			return (m1 && (leftMostDigit(x1)==x2%10));
		}
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x1,x2;
		System.out.print("input 2 integers, separated by a space (\"-1 -1\" to end) : "); 
		x1=s.nextInt();x2=s.nextInt();

		while (x1!=-1)
		{
			if (areOpposite(x1,x2)) 
				System.out.println("true");
			else
				System.out.println("false");
			
			System.out.print("input 2 integers, separated by a space (\"-1 -1\" to end) : "); 
			x1=s.nextInt();x2=s.nextInt();
		}

		s.close();
	}
}