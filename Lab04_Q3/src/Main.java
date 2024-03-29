import java.util.*;

public class Main
{
	// Determine whether an integer x contains even digit(s) (0,2,4,6,8)	
	static boolean containEven(int x){		//56732 => true	
		if(x<10) {
			return (x%2==0);
		}else {
			boolean m1 = containEven(x/10);	//5673 => true
			if(x%2==0) {
				return true;
			}else {
				return m1;
			}
		}
	}


	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x;
		System.out.print("input x (-1 to end) : "); x=s.nextInt();

		while (x!=-1)
		{
			if (containEven(x)) 
				System.out.println("true");
			else
				System.out.println("false");
			
			System.out.print("input x (-1 to end) : "); x=s.nextInt();
		}

		s.close();
	}
}