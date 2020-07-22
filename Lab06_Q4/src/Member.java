public class Member 
{
	//Instance fields
	
	private String name;
	private Role role;
	//Constructor
	public Member(String name, Role aState) {
		this.name = name;
		role = aState;
	}
	
	//Assessor method
	
	public String getName() {
		return name;
	}
	
	public Role getRole() {
		return role;
	}
	
	public String getNameAndRole() {
		return role.getNameAndRole(this);
	}
	
	public void Setrole(Role role) {
		this.role = role;
	}
}