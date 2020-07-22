
public class ExWrongCommand extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExWrongCommand() {
		super("Overlap with leave");
	}
	
	public ExWrongCommand(String message) {
		super(message);
	}
}
