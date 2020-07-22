import java.util.ArrayList;

public class Student {
	
	private String id;
	private ArrayList<Offering> studies;
	
	public Student(String id) {
		this.id = id;
		studies = new ArrayList<>();
	}

	public void takeCourse(Course course, String semID) {
		Offering o = course.getOffering(semID);
		o.addStudent(this);
		studies.add(o);
		
	}

	public boolean hasBeenClassmateOf(Student s2) {
		for(Offering o:studies) {
			if(s2.hasTaken(o))
				return true;
		}
		return false;
	}
	
	public boolean hasTaken(Offering offering) {
		for(Offering o:studies) {
			if(o.equals(offering))
				return true;
		}
		return false;
	}
	
	public String getID() {
		return id;
	}
}
