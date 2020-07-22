
public class CmdListLeaves implements Command {
	@Override
	public void execute(String[] cmdParts) {
		
		try {
			Company company = Company.getInstance();
			if (cmdParts.length == 2) {
				Employee e = company.searchEmployee(cmdParts[1]);
				e.listLeavesTaken();
			}else {
				company.listLeavesTakan();
			}
		} catch (ExEmployeeNotFound e) {
			System.out.println(e.getMessage());
		}
	}
}
