import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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
			Graphics.createErrorMessage("Could not establish connection");
		}
	}
	
	public void executeStatement(String query, ArrayList<String> optionals, ArrayList<Integer> types) {
		try {
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("Your query is: " + query);
			System.out.println("The size of your optionals is: " + optionals.size());
			System.out.println("The contents of your optionals is: " + optionals.toString());
			for(int i = 0; i < optionals.size(); i++) {
				if(types.get(i) == Types.NUMERIC )
					ps.setInt(i+1, Integer.parseInt(optionals.get(i)));
				else if(types.get(i) == Types.VARCHAR)
					ps.setString(i+1, optionals.get(i));
				else if(types.get(i) == Types.DATE)
					ps.setDate(i+1, (Date) new SimpleDateFormat("dd/MM/yyyy").parse(optionals.get(i)));
				else if(types.get(i) == Types.CLOB){
					System.out.println();
					//Figure out how to handle this
				}else if(types.get(i) == Types.BLOB){
					File image = new File(optionals.get(i));
				    FileInputStream   fis = new FileInputStream(image);
					ps.setBinaryStream(i+1, fis, (int) image.length());
					
				}
			}
			
			rs = ps.executeQuery();
		} catch (SQLException e) {
			Graphics.createErrorMessage("Could not prepare the executable statement properly.");
		} catch (ParseException e) {
			Graphics.createErrorMessage("Could not parse the date format");
		} catch (FileNotFoundException e) {
			Graphics.createErrorMessage("Could not find the image specified");
		}
		
	}
	
	public int executeUpdate(String query, ArrayList<String> optionals, ArrayList<Integer> types) {
		try {
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("Your query is: " + query);
			System.out.println("The size of your optionals is: " + optionals.size());
			System.out.println("The contents of your optionals is: " + optionals.toString());
			for(int i = 0; i < optionals.size(); i++) {
				if(types.get(i) == Types.NUMERIC )
					ps.setInt(i+1, Integer.parseInt(optionals.get(i)));
				else if(types.get(i) == Types.VARCHAR)
					ps.setString(i+1, optionals.get(i));
				else if(types.get(i) == Types.DATE)
					ps.setDate(i+1, (Date) new SimpleDateFormat("dd/MM/yyyy").parse(optionals.get(i)));
				else if(types.get(i) == Types.CLOB){
					File inputTextFile = new File(optionals.get(i));
		            FileInputStream inputFileInputStream = new FileInputStream(inputTextFile);
				}else if(types.get(i) == Types.BLOB){
					File image = new File(optionals.get(i));
					FileInputStream fis = new FileInputStream(image);
					ps.setBinaryStream(i+1, fis, (int) image.length());
				}
			}
			
			int count = ps.executeUpdate();
			return count;
		} catch (SQLException e) {
			
			Graphics.createErrorMessage("Could not prepare the executable statement properly.");
		} catch (ParseException e) {
			Graphics.createErrorMessage("Could not parse the date format");
		} catch (FileNotFoundException e) {
			Graphics.createErrorMessage("Could not find the image specified");
		}
		return 0;
		
	}
	
	public ResultSetMetaData getMetaData() {
		try {
			return rs.getMetaData();
		} catch (SQLException e) {
			Graphics.createErrorMessage("Could not get the meta data for the latest query");
		} catch (NullPointerException e) {
			Graphics.createErrorMessage("Query needs to be executed before metadata can be obtained");
		}
		return null;
	}
	
	public ResultSet getResultSet(){
		return rs;
	}
	
	public BufferedImage handleBLOB(Blob blob){
		try {
			InputStream in = blob.getBinaryStream();
			return ImageIO.read(in);
		} catch (IOException e) {
			Graphics.createErrorMessage("Could not convert blob to image");
		} catch (SQLException e) {
			Graphics.createErrorMessage("Could not read in the blob");
		}
		return null;
	}
	
	public static DatabaseHandler getDatabaseHandler() throws SQLException {
		if(db == null)
			db = new DatabaseHandler();
		return db;
	}
	
}
