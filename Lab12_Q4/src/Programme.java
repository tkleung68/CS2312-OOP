
import java.util.LinkedList;
import java.util.List;

public class Programme {

	private List<Course> courseList;
	private AddController addAgent;
	private DropController dropAgent;

	public Programme() {		
		courseList = new LinkedList<Course>();
		addAgent = new AddController(courseList);
		dropAgent = new DropController(courseList);
	}

	public void add(Course c) {
		addAgent.process(c);
		addAgent.printCourses();
	}

	public void drop(Course c) {
		try {
			dropAgent.process(c);
			dropAgent.printCourses();
		} catch (ExControll e) {
			System.out.println(e.getMessage());
		}
	}
}