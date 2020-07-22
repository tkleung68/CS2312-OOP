import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		
		int width, height;
		
		Scanner obj = new Scanner(System.in);
		
		System.out.print("Input the width of the multiplication table (2-10): ");
		width =  obj.nextInt();
		
		System.out.print("Input the height of the multiplication table (2-10): ");
		height =  obj.nextInt();
		int totalWidth = 7 + (width - 1)*6 +2;
		
		for (int i=0;i<totalWidth;i++) {
			if(i==0) {
				System.out.print("/");
			}else if(i< totalWidth -1) {
				System.out.print("-");
			}else {
				System.out.print("\\");
			}
		}
		System.out.println();
		
		for(int i=0;i<height;i++) {
			if(i==1) {
				for (int k=0;k<totalWidth;k++) {
					if(k==0 || k==totalWidth-1) {
						System.out.print("|");
					}else {
						System.out.print("-");
					}
				}
				System.out.println();
			}
			for(int j=0;j<width;j++) {
				
				if(j==0) {
					System.out.print("|");
				}

				System.out.printf("%6d",(i+1)*(j+1) );
				if(j==0) {
					System.out.print("|");
				}else if(j== width-1) {
					System.out.print(" |");
				}
			}
			System.out.println();
		}
		
		for (int i=0;i<totalWidth;i++) {
			if(i==0) {
				System.out.print("\\");
			}else if(i< totalWidth -1) {
				System.out.print("-");
			}else {
				System.out.print("/");
			}
		}
		
		obj.close();
		
	}
}
