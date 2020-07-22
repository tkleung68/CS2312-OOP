public class Main
{
	public static void main(String[] args) 
	{
		Person person = new Person();
		
		String[] playables = {"Football", "Piano", "Piano", "Football", "Chess"};
		
		for (String s:playables)
		{
			person.getPlay(s).play();
		}
	}
}
 
