
public class CmdListRoles implements Command{
	public void execute(String[] cmdParts){
		try {
			Company company = Company.getInstance();
			Employee e =company.searchEmployee(cmdParts[1]);
			if(e==null) {
				throw new ExEmployeeNotFound();
			}
			if(!company.searchAllTeam(e)) 
				System.out.println("No role");
			else {
				company.listRole(e);
			}
		} catch (ExEmployeeNotFound e) {
			System.out.println(e.getMessage());
		}
		
	}
}
