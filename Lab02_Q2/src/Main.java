import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		
		int width, height;
		
		Scanner obj = new Scanner(System.in);
		
		System.out.print("Input the width of the multiplication table (2-10): ");
		width =  obj.nextInt();
		
		System.out.print("Input the height of the multiplication table (2-10): ");
		height =  obj.nextInt();
		
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				System.out.printf("%5d",(i+1)*(j+1) );
				System.out.print("|");
			}
			System.out.println();
		}
		obj.close();
		
	}
}
