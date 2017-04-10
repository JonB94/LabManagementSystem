import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Driver {
	public static void main(String[] args) {
		ArrayList<String> inputs = new ArrayList<String>();
	    Graphics g = new Graphics();
	
	    g.createLoginView();
	    inputs = g.getInputs();
	    try {
			DatabaseHandler.getDatabaseHandler().signIn(inputs.get(0), inputs.get(1));
		} catch (SQLException e) {
			System.out.println("Database could not be accessed. \nQuitting......");
			System.exit(0);
		}
	    while(true) {
	    	
	    }
	}
}
