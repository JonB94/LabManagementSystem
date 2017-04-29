import java.sql.PreparedStatement;

public class User {
	
	public final static int USER_ADMIN = 2;
	
	public final static int USER_SUPERVISOR = 1;
	
	public final static int USER_RESEARCHER = 0;
	
	private User user;
	
	private int userType;
	
	protected User(int userType) {
		this.userType = userType;
		if(userType == USER_ADMIN)
			user = new AdminUser();
		else if(userType == USER_SUPERVISOR)
			user = new SupervisorUser();
		else if(userType == USER_RESEARCHER)
			user = new StandardUser();
	}
	
	public int getUserType() {
		return userType;
	}
	
	public void setUserType(int userType){
		this.userType = userType;
	}
	
	public User getUser(int userType){
		if(user == null)
			user = new User(userType);
		return user;
	}
	
	public PreparedStatement getProjects(){
		PreparedStatement project = null;
		
		return project;
	}
}
