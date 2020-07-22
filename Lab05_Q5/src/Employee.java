import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Employee
{
	private String id;
	private String name;
	private double salary;

	//Constructor
	public Employee(String aId, String aName, double aSalary)
	{
		id = aId;
		name = aName;
		salary = aSalary;
	}

	//Accessor methods
	public String getId()	{return id;}
	public String getName()	{return name;}
	public double getSalary()	{return salary;}

	//Return a string representation for salary details
	public String toStringSalaryDetails() 
	{ 
		return String.format("[%s %s] Salary: %.2f", id, name, salary); //Compose the string: String.format("[%s %s] Salary: %.2f", id, ____, ____);
	}
	
	//Raise the salary by a given percentage (will be used later)
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	

}