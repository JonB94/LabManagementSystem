import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Label;


public class CreateProject extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblCreateProject;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public CreateProject() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(147, 59, 259, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 92, 259, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 123, 259, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(147, 154, 259, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(147, 185, 259, 20);
		add(textField_4);
		
		lblCreateProject = new JLabel("CREATE PROJECT");
		lblCreateProject.setForeground(Color.ORANGE);
		lblCreateProject.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCreateProject.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateProject.setBounds(10, 11, 430, 14);
		add(lblCreateProject);
		
		Label label = new Label("Project name");
		label.setBounds(26, 57, 115, 22);
		add(label);
		
		Label label_1 = new Label("Project number");
		label_1.setBounds(26, 90, 115, 22);
		add(label_1);
		
		Label label_2 = new Label("Project start date");
		label_2.setBounds(26, 121, 115, 22);
		add(label_2);
		
		Label label_3 = new Label("Project deadline");
		label_3.setBounds(26, 152, 115, 22);
		add(label_3);
		
		Label label_4 = new Label("Supervisor ID");
		label_4.setBounds(26, 183, 115, 22);
		add(label_4);
		
		Label label_5 = new Label("Progress report");
		label_5.setBounds(26, 214, 115, 22);
		add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(147, 216, 259, 20);
		add(textField_5);

	}
}
