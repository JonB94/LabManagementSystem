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
		final String query = "INSERT INTO Checks_out (Employee_id, Amount, Model_number, Checkout_date, Return_deadline) "
							+ "VALUES (?,?,?, SYSDATE , SYSDATE + 5)";
		return query;
	}
	
	public String returnMaterial(){
		final String query = "UPDATE Checks_out "
							+ "SET Amount_returned = ? "
							+ "WHERE Model_number = ?";
		return query;
	}
	
	public String removeMaterial(){
		final String query = "UPDATE Lab_materials "
							+ "SET Quantity = Quantity - ? "
							+ "WHERE Model_number = ?";
		return query;
	}
	
	public String updateLabMaterialAmount(){
		final String query = "UPDATE Lab_materials "
							+ "SET Quantity = Quantity + ? "
							+ "WHERE Model_number = ?";
		return query;
	}
	
	public String getOverCheckoutUsers(){
		final String query = "SELECT FIRST_NAME, LAST_NAME, C.EMPLOYEE_ID AS \"Emp_id\", COUNT(*) AS \"Items\" "
							+ "FROM CHECKS_OUT C, RESEARCHERS R "
							+ "WHERE R.EMPLOYEE_ID = C.EMPLOYEE_ID AND AMOUNT_RETURNED < AMOUNT "
							+ " GROUP BY FIRST_NAME, LAST_NAME, C.EMPLOYEE_ID "
							+ "HAVING COUNT(*) >= 5";
		return query;
	}
	
	public String getResearchersUnderSup(){
		final String query = "SELECT R.First_name, R.Last_name, R.Employee_id "
							+ "FROM RESEARCHERS R LEFT OUTER JOIN RESEARCHERS S on R.Supervisor_id = S.Employee_id "
							+ "WHERE R.SUPERVISOR_ID = S.EMPLOYEE_ID AND S.First_name = ? "
							+ "AND S.Last_name = ? "
							+ "ORDER BY R.Last_name, R.First_name";
		return query;
	}
	
	public String getCheckoutMaterialsByUser(){
		final String query = "SELECT Employee_id, L.name, C.Model_number, Amount, Checkout_date "
							+ "FROM LAB_MATERIALS L LEFT OUTER JOIN CHECKS_OUT C on L.Model_number = C.Model_number "
							+ "WHERE C.EMPLOYEE_ID IN (SELECT R.EMPLOYEE_ID "
							+ "FROM RESEARCHERS R "
							+ "WHERE R.FIRST_NAME = ? AND R.Last_name = ?)";
		return query;
	}
	
	public String getExtraCheckoutMaterials(){
		final String query = "(SELECT L.Model_number "
				+ "FROM CHECKS_OUT C LEFT OUTER JOIN LAB_MATERIALS L ON C.Model_number = L.Model_number) "
				+ "INTERSECT "
				+ "(SELECT C.Model_number "
				+ "FROM CHECKS_OUT C LEFT OUTER JOIN RESEARCHERS R ON C.Employee_id = R.Employee_id)";
		return query;
	}
	
	public String getLastCheckouts(){
		final String query = "SELECT R.FIRST_NAME, R.LAST_NAME, C.MODEL_NUMBER, C.CHECKOUT_DATE "
				+ "FROM CHECKS_OUT C LEFT OUTER JOIN RESEARCHERS R ON R.EMPLOYEE_ID = C.EMPLOYEE_ID "
				+ "WHERE ROWNUM < 5 "
				+ "ORDER BY C.CHECKOUT_DATE ASC";
		return query;
	}
	
	public String updatePicture(){
		final String query = "UPDATE RESEARCHERS "
							+ "SET Employee_photo = ? "
							+ "WHERE Employee_id = ?";
		return query;
	}
	
	public String getPhoto(){
		final String query = "SELECT Employee_photo "
							+ "FROM RESEARCHERS "
							+ "WHERE Employee_id = ?";
		return query;
	}
	
	public String getProjectUpdate(){
		final String query = "SELECT PROGRESS_REPORT "
							+ "FROM PROJECTS "
							+ "WHERE Project_number = ? ";
		return query;
	}
	
	public String updateProjectReport(){
		final String query = "UPDATE PROJECTS "
							+ "SET PROGRESS_REPORT = ? "
							+ "WHERE PROJECT_NUMBER = ?";
		return query;
				
	}
}
