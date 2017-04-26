
public class User {
	
	public final int USER_ADMIN = 2;
	
	public final int USER_MANAGER = 1;
	
	public final int USER_RESEARCHER = 0;
	
	private int userType;
	
	public User(int userType) {
		this.userType = userType;
	}
	
	public int getUserType() {
		return userType;
	}
	
	public void setUserType(int userType){
		this.userType = userType;
	}
}
