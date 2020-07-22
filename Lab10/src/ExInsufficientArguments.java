
public class ExInsufficientArguments extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8027119293632736888L;

	public ExInsufficientArguments() {
		super("Insufficient command arguments!");
	}
	
	public ExInsufficientArguments(String message) {
		super(message);
	}
}
