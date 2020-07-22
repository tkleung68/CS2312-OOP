
public class ExAnnualLeavesRange extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExAnnualLeavesRange() {
		super("Annual leaves out of range (0-300)!");
	}
	
	public ExAnnualLeavesRange(String message) {
		super(message);
	}
}
