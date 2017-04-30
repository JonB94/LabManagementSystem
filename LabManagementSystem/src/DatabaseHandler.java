import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class DatabaseHandler {

	private static DatabaseHandler db;
	
	private final String url = "jdbc:oracle:thin:@//cs440.systems.wvu.edu:2222/cs440";
	
	private Connection con;
	
	private ResultSet rs;
	
	public DatabaseHandler() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
	
	}
	
	public void signIn(String username, String pass){
		try {
			con = DriverManager.getConnection(url, username, pass);
		} catch (SQLException e) {
			System.out.println("Could not establish connection");
		}
	}
	
	public void executeStatement(String query, ArrayList<String> optionals) {
		try {
			PreparedStatement ps = con.prepareStatement(query);
			for(int i = 0; i < optionals.size(); i++) {
				ps.setString(i+1, optionals.get(i));
			}
			
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Could not prepare the executable statement properly.");
		}
		
	}
	
	public void executeUpdate(String query, ArrayList<String> optionals) {
		try {
			PreparedStatement ps = con.prepareStatement(query);
			for(int i = 0; i < optionals.size(); i++) {
				ps.setString(i+1, optionals.get(i));
			}
			
			int count = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Could not prepare the executable statement properly.");
		}
		
	}
	
	public ResultSetMetaData getMetaData() {
		try {
			return rs.getMetaData();
		} catch (SQLException e) {
			System.out.println("Could not get the meta data for the latest query");
		} catch (NullPointerException e) {
			System.out.println("Query needs to be executed before metadata can be obtained");
		}
		return null;
	}
	
	public ResultSet getResultSet(){
		return rs;
	}
	
	public static DatabaseHandler getDatabaseHandler() throws SQLException {
		if(db == null)
			db = new DatabaseHandler();
		return db;
	}
	
}
