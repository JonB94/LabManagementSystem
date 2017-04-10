import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Graphics {
	
	ArrayList<String> inputFields;
	
	public Graphics() {
		inputFields = new ArrayList<String>();
	}
		
	public ArrayList<String> getInputs(){
		return inputFields;
	}
	
	public void createLoginView() {
		
		final String username;
	    final char[] password;
		{
		    JTextField user = new JTextField();
		    JPasswordField pass = new JPasswordField();
		    JTextField table = new JTextField();
	        int result = JOptionPane.showConfirmDialog(
	        	null, 
	        	new Object[]{
	    			new JLabel("Username:"), user,
	    			new JLabel("Password:"), pass
	        	}, 
	        	"View Table", 
	        	JOptionPane.OK_CANCEL_OPTION
	        );
	
	        if (result != JOptionPane.OK_OPTION)
	        	System.exit(0);
		
	        username = user.getText();
	        password = pass.getPassword();
		}
		
		inputFields.add(username);
		inputFields.add(new String(password));
	}
	
	public void createAddUserView() {
		
	}
	
	public void createAddSupplyView() {
		
	}
	
	public void createCheckoutView(){
		
	}
}
