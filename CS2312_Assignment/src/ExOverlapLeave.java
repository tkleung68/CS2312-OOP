
public class ExOverlapLeave extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExOverlapLeave() {
		super("Overlap with leave");
	}
	
	public ExOverlapLeave(String message) {
		super(message);
	}
}
