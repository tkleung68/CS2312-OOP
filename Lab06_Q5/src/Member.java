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
	
	public String getRoleDescription() {
		if( this.getRole() instanceof RNormalMember) {
			return "a normal member";
		}else if ( this.getRole() instanceof RLeader) {
			return "the leader";
		}else {
			return "a disappeared member";
		}
		
	}
}
