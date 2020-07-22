import java.util.List;
 
public class DropController extends Controller{
     
 
 
    public DropController(List<Course> list) {
        super(list);
    }
 
    @Override
    public void process(Course c) throws ExNotExist, ExRequired {
        if(!courseList.contains(c)) 
            throw new ExNotExist("Cannot drop "+ c.toString() + " (Course doesn't exist in the list)");
         
        for(Course p:courseList) {
            if(p.getPreRequisites().contains(c)) 
                throw new ExRequired("Cannot drop "+ c.toString() + " (Required for " + p.toString() + ")");
 
        }
         
        courseList.remove(c);
    }
}