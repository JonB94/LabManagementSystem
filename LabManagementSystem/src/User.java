import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
	
	public final static int USER_ADMIN = 2;
	
	public final static int USER_SUPERVISOR = 1;
	
	public final static int USER_RESEARCHER = 0;
	
	private static User user;
	
	private int userType;
	
	protected User(int userType) {
		this.userType = userType;
	}
	
	public int getUserType() {
		return userType;
	}
	
	public void setUserType(int userType){
		this.userType = userType;
	}
	
	public static User getUser(int userType){
		if(user == null)
			if(userType == USER_ADMIN)
				user = new AdminUser();
			else if(userType == USER_SUPERVISOR)
				user = new SupervisorUser();
			else if(userType == USER_RESEARCHER)
				user = new StandardUser();
		return user;
	}
	
	public String getProjects(){
		final String query = "SELECT * "
							+ "FROM PROJECTS";
		
		return query;
	}
	
	public String getEmployees(){
		final String query = "SELECT First_name, Last_name "
							+ "FROM RESEARCHERS";
		return query;
	}
	
	public String getLabMaterials(){
		final String query = "SELECT * "
							+ "FROM LAB_MATERIALS";
		return query;
	}
	
	public String getProjectsForUser(){
		final String query = "SELECT r.First_name, r.Last_name, Project_name, p.project_number, "
				+ "project_start_date, project_deadline, p.supervisor_id "
				+ "FROM WORKS_ON w LEFT OUTER JOIN PROJECTS p ON w.PROJECT_NUMBER = p.PROJECT_NUMBER, "
				+ "RESEARCHERS r "
				+ "WHERE r.First_name = ? AND r.Last_name = ? AND w.EMPLOYEE_ID = r.EMPLOYEE_ID"; 
		return query;
	}
	
	public String checkoutMaterial(){
		final String query = "INSERT INTO Checks_out "
							+ "VALUES (?,?,?,?,?)";
		return query;
	}
	
	public String returnMaterial(){
		final String query = "UPDATE Checks_out "
							+ "SET Amount_returned = ? "
							+ "WHERE Employee_id = ?";
		return query;
	}
	
	/* NOT SURE IF WE WILL NEED THIS QUERY
	public String findMaterial(){
		final String query = "SELECT "
	}
	*/
	
}
