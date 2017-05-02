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
		inputFields = new ArrayList<String>();
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

	public void createUserSignIn() {
		inputFields = new ArrayList<String>();
		final String username;
	    final char[] password;
		{
		    JTextField user = new JTextField();
		    JPasswordField pass = new JPasswordField();
	        int result = JOptionPane.showConfirmDialog(
	        	null, 
	        	new Object[]{
	    			new JLabel("Username:"), user,
	    			new JLabel("Password:"), pass
	        	}, 
	        	"User login", 
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
	
	public static void createErrorMessage(String message){
		JOptionPane.showMessageDialog(
				null, new String(message), 
				"ERROR",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public static int createSuccessBox(String message){
		return JOptionPane.showConfirmDialog(
				null,
				message,
				"Success!",
				JOptionPane.OK_OPTION);
	}
	
	public static String[] createGeneralInputBox(String[] inputs, String name){
		String[] outputs = new String[inputs.length];
		
		{
		    JTextField[] fields = new JTextField[inputs.length];
		    
		    for(int i = 0; i < fields.length;i++){
		    	fields[i] = new JTextField();
		    }
		    
		    //Creating labels
		    Object[] labels = new Object[fields.length*2];
		    for(int i = 0; i < labels.length; i = i+2){
		    	labels[i] = new JLabel();
		    	labels[i+1] = fields[i];
		    }
		    
	        int result = JOptionPane.showConfirmDialog(
	        	null, 
	        	labels, 
	        	name, 
	        	JOptionPane.OK_CANCEL_OPTION
	        );
	
	        
	        if (result == JOptionPane.OK_OPTION)
	        	for(int i = 0; i < outputs.length;i++){
	        		outputs[i] = ((JTextField)labels[i+1]).getText();
	        	}
	        
	        return outputs;
		}
		
	}
}
