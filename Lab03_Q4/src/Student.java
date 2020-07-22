import java.io.*;
import java.util.Scanner;

public class Student {

	//Instance fields
	private String name; //A reference to the student name: String name;
	
	//Constructor
	public Student(String studentName) //One input parameter: String name
	{
		this.name = studentName;
	}
	
	//Return the String representation 
	public String toString()
	{
		return this.name;//Return the student name: return name;
	}
	
	//Static method for reading a list of students from the file and return an array of student objects
	public static Student[] createStudentListFromFile(String filepathname) throws FileNotFoundException
	{

		int count;
		Scanner inFile = new Scanner(new File(filepathname));
		
		count=inFile.nextInt();
		inFile.nextLine();


		Student[] result;
		result = new Student[count]; 	

		for (int i=0;i<count;i++)
		{
			String name = inFile.nextLine(); //Read a line of student name: inFile.nextLine();
			result[i] = new Student(name); //Create a student object for result[i]: new Student(name);
		}
		
		System.out.println("Total number of students: " + count );
		
		
		inFile.close();//Close the file: inFile.close();
		return result;//Return the result: return result;
	}
	
}