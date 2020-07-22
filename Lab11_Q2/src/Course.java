import java.util.ArrayList;

public class Course {
	private String code;
	private ArrayList<Offering> offerings;
	
	public Course(String code) {
		this.code = code;
		offerings = new ArrayList<>();
	}

	public void addOffering(String semID) {
		this.offerings.add(new Offering(semID));
	}
	
	public Offering getOffering(String semID) {
		for (Offering o:offerings) {
			if (o.getSemID().equals(semID))
				return o;
		}
		return null;
	}

	public void listStudents() {
		for(Offering o:offerings) {
			o.printInfo();
		}
		
	}
	
}
