
public class User {
	
	public final int USER_ADMIN = 0;
	
	public final int USER_MANAGER = 1;
	
	public final int USER_RESEARCHER = 2;
	
	private int userType;
	
	public User(int userType) {
		this.userType = userType;
	}
	
	public int getUserType() {
		return userType;
	}
}
