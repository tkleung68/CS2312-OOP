import java.util.*;

public class Main
{
	// Return the left-most digit in integer x 	
	static int leftMostDigit(int x) //31=>3
	{	
		if(x<10) {
			return x;
		}else {
			int m1 = leftMostDigit(x/10); //3=>3
			return m1;
		}
	}


	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x;
		System.out.print("input x (-1 to end) : "); x=s.nextInt();

		while (x!=-1)
		{
			System.out.println(leftMostDigit(x));
			System.out.print("input x (-1 to end) : "); x=s.nextInt();
		}

		s.close();
	}
}