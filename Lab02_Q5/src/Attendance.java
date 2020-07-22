import java.io.*;
import java.util.Scanner;

public class Attendance {

	private int[] students;
	private int[] attendees;

	public Attendance() throws FileNotFoundException{
		students = new int[20];
		attendees = new int[20];
		Scanner sStudents = new Scanner(new File("StudentList.txt"));
		Scanner sAttendees = new Scanner(new File("AttendanceLog.txt"));
		
		int count = 0;
		while(sStudents.hasNext()) {
			students[count] = sStudents.nextInt();
			count++;
		}
		
		count = 0;
		while(sAttendees.hasNext()) {
			attendees[count] = sAttendees.nextInt();
			count++;
		}
		


		sStudents.close();
		sAttendees.close();
	}

	public boolean isPresent(int id) {
		boolean isPresented = false;
		for(int i=0;i<20;i++) {
			if(id==this.attendees[i]) 
				isPresented = true;
		}
		return isPresented;
	}

	public boolean belongToClass(int id) {
		boolean isInClass = false;
		for (int i=0;i<20;i++) {
			if (id==this.students[i])
				isInClass = true;
		}
		return isInClass;
	}

	public void listAbsentees() {
		System.out.println("List of absentees:");
		int count =0;
		for (int i=0;i<20;i++) {
			if(!isPresent(students[i])) {
				System.out.println(students[i]);
				count++;
			}
		}
		System.out.println("Total count: " + count);
	}

	public void listWalkIn() {
		System.out.println("List of walk-in students:");
		
		for (int i=0;i<20;i++) {
			if(!belongToClass(attendees[i]) && attendees[i]!=0)
				System.out.println(attendees[i]);
		}
	}


}