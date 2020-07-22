
public class Cat extends Animal{
	@Override
	public String getMyName() {return super.getMyName();}

	@Override
	public int getRunSpeed() {
		return 5;
	}
	
	public Cat(String name) {
		super(name);
	}
	
	public void chase(Animal a) {
		if(a.getRunSpeed()<this.getRunSpeed())
			System.out.println(this.getMyName() + " Catches " + a.getMyName());
	}
	
}