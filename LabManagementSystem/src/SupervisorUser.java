
public class SupervisorUser extends User {

	protected SupervisorUser() {
		super(USER_SUPERVISOR);
	}

	public String addMaterials(){
		final String query = "INSERT INTO LAB_MATERIALS "
							 + "VALUES (?,?,?,?,?)";
		return query;
	}
	
	public String createNewProject(){
		final String query = "INSERT INTO PROJECTS(PROJECT_NAME, PROJECT_NUMBER, PROJECT_START_DATE, SUPERVISOR_ID) "
							+ "VALUES ('?', ?, TO_DATE('?', 'yyyy/mm/dd hh24:mi:ss'), ?)";
		return query;
	}
	
	public String getCheckoutOfAllUsers(){
		final String query = "SELECT R.First_name, R.Last_name, R.Employee_id, L.Name, L.Model_number, C.Checkout_date "
				+ "FROM (LAB_MATERIALS L JOIN CHECKS_OUT C on L.Model_number = C.Model_number) "
				+ "JOIN RESEARCHERS R ON R.EMPLOYEE_ID = C.EMPLOYEE_ID "
				+ "WHERE EXISTS (SELECT C.EMPLOYEE_ID "
				+ "FROM CHECKS_OUT C "
				+ "WHERE R.EMPLOYEE_ID = C.EMPLOYEE_ID) "
				+ "ORDER BY R.Last_name, R.First_name, R.Employee_id";
		return query;
	}
	
	public String refillMaterials(){
		final String query = "UPDATE LAB_MATERIALS "
							+ "SET Quantity = Quantity + 5 "
							+ "WHERE Manufacturer LIKE '?%' ";
		return query;

	}
	
	
	
}
