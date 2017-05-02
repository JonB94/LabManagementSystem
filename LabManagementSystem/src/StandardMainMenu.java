import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;

public class StandardMainMenu extends JPanel {

	private JButton projectsButton;
	private JButton checkoutButton;
	private SpringLayout currentLayout;
	private JScrollPane scroll;
	private JTextArea textArea;
	private JButton btnMyProjects;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnReturnMaterial;
	private JButton btnExtraCheckoutMaterials;
	
	public StandardMainMenu(){
		
		setPreferredSize(new Dimension(900,600));
		textArea = new JTextArea();
		textArea.setSize(new Dimension(500,600));
		projectsButton = new JButton("Projects");		
		currentLayout = new SpringLayout();
		currentLayout.putConstraint(SpringLayout.SOUTH, projectsButton, -283, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, projectsButton, -66, SpringLayout.EAST, this);
		scroll = new JScrollPane (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		currentLayout.putConstraint(SpringLayout.WEST, projectsButton, 244, SpringLayout.EAST, scroll);
		currentLayout.putConstraint(SpringLayout.NORTH, scroll, -524, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, scroll, 0, SpringLayout.SOUTH, this);
		scroll.setPreferredSize(new Dimension(500,600));
		scroll.add(textArea);
		
		setupPanel();
	}

	private void setupPanel() {
		setBackground(UIManager.getColor("Button.background"));
		this.setLayout(currentLayout);
		this.add(projectsButton);
		projectsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User stand = User.getUser(User.USER_RESEARCHER);
				try {
					DatabaseHandler.getDatabaseHandler().executeStatement(stand.getProjects(), new ArrayList());
					System.out.println("Hello1");
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					System.out.println("Hello2");
					ResultSetMetaData meta = DatabaseHandler.getDatabaseHandler().getMetaData();
					System.out.println("Hello3");
					while(rs.next()){
						for(int i = 0; i < meta.getColumnCount(); i++){
							System.out.println("Column Count: " + meta.getColumnCount());
							textArea.setText("");
							if(meta.getColumnType(i) == Types.NUMERIC){
								textArea.setText(rs.getInt(i) + "\t");
							}else{
								textArea.setText(rs.getString(i) + "\t");
							}
						}
						System.out.println();
					}
				} catch (SQLException e) {
					//Maybe create a popup box to handle this message
					Graphics.createErrorMessage("Could not properly fetch the projects");
				}
				
			}
		});
		this.add(scroll);
		
		btnMyProjects = new JButton("My Projects");
		currentLayout.putConstraint(SpringLayout.WEST, btnMyProjects, 0, SpringLayout.WEST, projectsButton);
		currentLayout.putConstraint(SpringLayout.SOUTH, btnMyProjects, -28, SpringLayout.NORTH, projectsButton);
		add(btnMyProjects);
		
		btnNewButton = new JButton("Employee List");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		currentLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -24, SpringLayout.NORTH, btnMyProjects);
		currentLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, projectsButton);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Lab Materials");
		currentLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, projectsButton);
		currentLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -12, SpringLayout.NORTH, btnNewButton);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Checkout Material");
		currentLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 33, SpringLayout.SOUTH, projectsButton);
		currentLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, projectsButton);
		add(btnNewButton_2);
		
		btnReturnMaterial = new JButton("Return Material");
		currentLayout.putConstraint(SpringLayout.SOUTH, btnReturnMaterial, -160, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, btnReturnMaterial, 0, SpringLayout.EAST, projectsButton);
		add(btnReturnMaterial);
		
		btnExtraCheckoutMaterials = new JButton("Extra Checkout Materials");
		currentLayout.putConstraint(SpringLayout.NORTH, btnExtraCheckoutMaterials, 26, SpringLayout.SOUTH, btnReturnMaterial);
		currentLayout.putConstraint(SpringLayout.EAST, btnExtraCheckoutMaterials, 0, SpringLayout.EAST, projectsButton);
		add(btnExtraCheckoutMaterials);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblEmployee.setForeground(Color.ORANGE);
		currentLayout.putConstraint(SpringLayout.NORTH, lblEmployee, 10, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, lblEmployee, 341, SpringLayout.WEST, this);
		add(lblEmployee);
		
		
	}
}
