import java.util.ArrayList;

public class Offering {
	private String semID;
	private ArrayList<Student> allstudents;
	
	
	public String getSemID(){
		return semID;
	}
	
	public Offering(String semID) {
		this.semID = semID;
		allstudents = new ArrayList<>();
	}
	
	public void addStudent(Student s) {
		allstudents.add(s);
	}
	
	public void printInfo() {
		System.out.printf("%s: ",semID);
		for(Student s:allstudents) {
			System.out.print(s.getID()+ " ");
		}
		System.out.print("\n");
	}
}
