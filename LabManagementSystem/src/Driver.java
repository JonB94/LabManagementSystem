import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Driver {
	public static void main(String[] args) {
		ArrayList<String> inputs = new ArrayList<String>();
		
		User testUser;
		
		String[] sampleUsernames = {"Standard", "Manager", "Admin"};
		String[] samplePass = {"Jeff", "megasuperbanana", "123456"};
	    Graphics g = new Graphics();
	
	    g.createLoginView();
	    inputs = g.getInputs();
	    try {
			DatabaseHandler.getDatabaseHandler().signIn(inputs.get(0), inputs.get(1));
		} catch (SQLException e) {
			System.out.println("Database could not be accessed. \nQuitting......");
			System.exit(0);
		}
	    
	    
	    boolean signInSuccessful = false;
	    while(!signInSuccessful) {
	    	
	    	g.createUserSignIn();
	    	inputs = g.getInputs();
	    	
	    	for(int i = 0; i < sampleUsernames.length; i++){
	    		if(inputs.get(0).equals(sampleUsernames[i]) && inputs.get(0).equals(samplePass[i])){
	    			testUser = new User(i);
	    		}
	    	}
	    	
	    }
	}
}
