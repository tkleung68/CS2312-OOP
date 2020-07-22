
public class ExOverlapActingHead extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExOverlapActingHead() {
		super("Overlap with acting head job!");
	}
	
	public ExOverlapActingHead(String message) {
		super(message);
	}
}
