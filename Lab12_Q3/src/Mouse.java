
public class Mouse extends Animal{

	@Override
	public String getMyName() {return super.getMyName();}
	
	@Override
	public int getRunSpeed() {
		
		return 2;
	}
	
	public Mouse(String name) {
		super(name);
	}
	
	
	

}
