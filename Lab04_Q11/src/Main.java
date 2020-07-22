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
	
	// Return an integer that is the reversed version of the input integer x (without the 0 digit). eg. 1234=>4321 
	static int reverse(int x) //123 -> 321
	{	
		if(x<10) {
			return x;
		}else {
			return (leftMostDigit(x) + reverse(tail(x))*10);
					
				
		}
	}


	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x;
		System.out.print("input x (-1 to end) : "); x=s.nextInt();

		while (x!=-1)
		{
			System.out.println(reverse(x));
			
			System.out.print("input x (-1 to end) : "); x=s.nextInt();
		}

		s.close();
	}
}