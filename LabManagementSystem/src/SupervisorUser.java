
public class SupervisorUser extends User {

	protected SupervisorUser() {
		super(USER_SUPERVISOR);
	}

	public String addMaterials(){
		final String query = "INSERT INTO LAB_MATERIALS "
							 + "VALUES (?,?,?,?,?)";
		return query;
	}
	
}
