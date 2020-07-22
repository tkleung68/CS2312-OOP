
public class ExInsufficientBalance extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExInsufficientBalance() {
		super("Insufficient balance.");
	}
	
	public ExInsufficientBalance(String message) {
		super(message);
	}
}
