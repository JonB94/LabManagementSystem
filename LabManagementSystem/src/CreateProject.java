import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JButton;


public class CreateProject extends JPanel {
	private JTextField textField_projectname;
	private JTextField textField_projectnumber;
	private JLabel lblCreateProject;
	private JTextField textField_startdate;
	private JTextField textField_deadline;
	private JTextField textField_supervisor;
	private JTextField textField_progressreport;

	private SpringLayout currentLayout;
	private JButton btnSubmit;
	
	/**
	 * Create the panel.
	 */
	public CreateProject() {
		setPreferredSize(new Dimension(900,600));
		currentLayout = new SpringLayout();
		setBackground(new Color(255,255,255));
		this.setLayout(currentLayout);
		
		textField_projectname = new JTextField();
		currentLayout.putConstraint(SpringLayout.WEST, textField_projectname, 350, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.EAST, textField_projectname, 638, SpringLayout.WEST, this);
		textField_projectname.setBounds(147, 59, 259, 20);
		add(textField_projectname);
		textField_projectname.setColumns(10);
		
		textField_projectnumber = new JTextField();
		currentLayout.putConstraint(SpringLayout.EAST, textField_projectnumber, -262, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, textField_projectname, -47, SpringLayout.NORTH, textField_projectnumber);
		textField_projectnumber.setColumns(10);
		textField_projectnumber.setBounds(147, 92, 259, 20);
		add(textField_projectnumber);
		
		textField_startdate = new JTextField();
		currentLayout.putConstraint(SpringLayout.EAST, textField_startdate, -262, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, textField_projectnumber, -49, SpringLayout.NORTH, textField_startdate);
		textField_startdate.setColumns(10);
		textField_startdate.setBounds(147, 123, 259, 20);
		add(textField_startdate);
		
		textField_deadline = new JTextField();
		currentLayout.putConstraint(SpringLayout.SOUTH, textField_startdate, -45, SpringLayout.NORTH, textField_deadline);
		currentLayout.putConstraint(SpringLayout.NORTH, textField_deadline, 306, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, textField_deadline, -288, SpringLayout.EAST, textField_projectname);
		currentLayout.putConstraint(SpringLayout.EAST, textField_deadline, 0, SpringLayout.EAST, textField_projectname);
		textField_deadline.setColumns(10);
		textField_deadline.setBounds(147, 154, 259, 20);
		add(textField_deadline);
		
		textField_supervisor = new JTextField();
		currentLayout.putConstraint(SpringLayout.EAST, textField_supervisor, 0, SpringLayout.EAST, textField_projectname);
		textField_supervisor.setColumns(10);
		textField_supervisor.setBounds(147, 185, 259, 20);
		add(textField_supervisor);
		
		lblCreateProject = new JLabel("CREATE PROJECT");
		currentLayout.putConstraint(SpringLayout.NORTH, lblCreateProject, 10, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, lblCreateProject, -296, SpringLayout.EAST, this);
		lblCreateProject.setForeground(Color.ORANGE);
		lblCreateProject.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblCreateProject.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateProject.setBounds(10, 11, 430, 14);
		add(lblCreateProject);
		
		Label label = new Label("Project name");
		currentLayout.putConstraint(SpringLayout.EAST, label, -24, SpringLayout.WEST, textField_projectname);
		label.setBounds(26, 57, 115, 22);
		add(label);
		
		Label label_1 = new Label("Project number");
		currentLayout.putConstraint(SpringLayout.SOUTH, label, -45, SpringLayout.NORTH, label_1);
		currentLayout.putConstraint(SpringLayout.WEST, textField_projectnumber, 14, SpringLayout.EAST, label_1);
		currentLayout.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		currentLayout.putConstraint(SpringLayout.SOUTH, label_1, 0, SpringLayout.SOUTH, textField_projectnumber);
		label_1.setBounds(26, 90, 115, 22);
		add(label_1);
		
		Label label_2 = new Label("Project start date");
		currentLayout.putConstraint(SpringLayout.WEST, textField_startdate, 4, SpringLayout.EAST, label_2);
		currentLayout.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, label);
		currentLayout.putConstraint(SpringLayout.SOUTH, label_2, 0, SpringLayout.SOUTH, textField_startdate);
		label_2.setBounds(26, 121, 115, 22);
		add(label_2);
		
		Label label_3 = new Label("Project deadline");
		currentLayout.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, label);
		label_3.setBounds(26, 152, 115, 22);
		add(label_3);
		
		Label label_4 = new Label("Supervisor ID");
		currentLayout.putConstraint(SpringLayout.SOUTH, label_3, -38, SpringLayout.NORTH, label_4);
		currentLayout.putConstraint(SpringLayout.WEST, textField_supervisor, 21, SpringLayout.EAST, label_4);
		currentLayout.putConstraint(SpringLayout.SOUTH, textField_supervisor, 0, SpringLayout.SOUTH, label_4);
		currentLayout.putConstraint(SpringLayout.WEST, label_4, 0, SpringLayout.WEST, label);
		label_4.setBounds(26, 183, 115, 22);
		add(label_4);
		
		Label label_5 = new Label("Progress report");
		currentLayout.putConstraint(SpringLayout.NORTH, label_5, 422, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, label_4, -36, SpringLayout.NORTH, label_5);
		currentLayout.putConstraint(SpringLayout.WEST, label_5, 0, SpringLayout.WEST, label);
		label_5.setBounds(26, 214, 115, 22);
		add(label_5);
		
		textField_progressreport = new JTextField();
		currentLayout.putConstraint(SpringLayout.WEST, textField_progressreport, 10, SpringLayout.EAST, label_5);
		currentLayout.putConstraint(SpringLayout.SOUTH, textField_progressreport, 0, SpringLayout.SOUTH, label_5);
		currentLayout.putConstraint(SpringLayout.EAST, textField_progressreport, 0, SpringLayout.EAST, textField_projectname);
		textField_progressreport.setColumns(10);
		textField_progressreport.setBounds(147, 216, 259, 20);
		add(textField_progressreport);
		
		btnSubmit = new JButton("Submit");
		currentLayout.putConstraint(SpringLayout.NORTH, btnSubmit, 274, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, btnSubmit, -85, SpringLayout.EAST, this);
		add(btnSubmit);

	}
}
