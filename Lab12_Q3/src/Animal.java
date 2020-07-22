
public abstract class Animal implements Runnable{
	private String name;
	public Animal(String n) {name=n;}
	
	@Override
	public String getMyName() {return name;}
}