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
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		currentLayout = new SpringLayout();
		scroll = new JScrollPane (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
		this.add(scroll);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblEmployee.setForeground(Color.ORANGE);
		currentLayout.putConstraint(SpringLayout.NORTH, lblEmployee, 10, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, lblEmployee, 341, SpringLayout.WEST, this);
		add(lblEmployee);
		
		JPanel panel = new JPanel();
		currentLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, scroll);
		currentLayout.putConstraint(SpringLayout.WEST, panel, 6, SpringLayout.EAST, scroll);
		currentLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, this);
		add(panel);
		currentLayout.putConstraint(SpringLayout.NORTH, btnReturnMaterial, 6, SpringLayout.SOUTH, btnNewButton_2);
		currentLayout.putConstraint(SpringLayout.NORTH, btnMyProjects, 6, SpringLayout.SOUTH, btnNewButton);
		currentLayout.putConstraint(SpringLayout.EAST, btnMyProjects, 0, SpringLayout.EAST, btnNewButton);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{107, 119, 71, 89, 97, 153, 95, 0};
		gbl_panel.rowHeights = new int[] {100, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnNewButton = new JButton("Employee List");
		currentLayout.putConstraint(SpringLayout.WEST, btnNewButton, 120, SpringLayout.EAST, scroll);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		currentLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, btnNewButton_1);
		currentLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnNewButton_1);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 1;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		btnMyProjects = new JButton("My Projects");
		currentLayout.putConstraint(SpringLayout.WEST, btnMyProjects, 120, SpringLayout.EAST, scroll);
		currentLayout.putConstraint(SpringLayout.NORTH, btnExtraCheckoutMaterials, 93, SpringLayout.SOUTH, btnMyProjects);
		GridBagConstraints gbc_btnMyProjects = new GridBagConstraints();
		gbc_btnMyProjects.insets = new Insets(0, 0, 5, 5);
		gbc_btnMyProjects.gridx = 3;
		gbc_btnMyProjects.gridy = 2;
		panel.add(btnMyProjects, gbc_btnMyProjects);
		projectsButton = new JButton("Projects");
		currentLayout.putConstraint(SpringLayout.WEST, projectsButton, 120, SpringLayout.EAST, scroll);
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
		currentLayout.putConstraint(SpringLayout.NORTH, projectsButton, 6, SpringLayout.SOUTH, btnMyProjects);
		currentLayout.putConstraint(SpringLayout.EAST, projectsButton, 0, SpringLayout.EAST, btnMyProjects);
		GridBagConstraints gbc_projectsButton = new GridBagConstraints();
		gbc_projectsButton.insets = new Insets(0, 0, 5, 5);
		gbc_projectsButton.gridx = 3;
		gbc_projectsButton.gridy = 3;
		panel.add(projectsButton, gbc_projectsButton);
		
		btnNewButton_2 = new JButton("Checkout Material");
		currentLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 120, SpringLayout.EAST, scroll);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 4;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		currentLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 6, SpringLayout.SOUTH, projectsButton);
		currentLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, projectsButton);
		
		btnReturnMaterial = new JButton("Return Material");
		currentLayout.putConstraint(SpringLayout.WEST, btnReturnMaterial, 120, SpringLayout.EAST, scroll);
		GridBagConstraints gbc_btnReturnMaterial = new GridBagConstraints();
		gbc_btnReturnMaterial.insets = new Insets(0, 0, 5, 5);
		gbc_btnReturnMaterial.gridx = 3;
		gbc_btnReturnMaterial.gridy = 5;
		panel.add(btnReturnMaterial, gbc_btnReturnMaterial);
		currentLayout.putConstraint(SpringLayout.EAST, btnReturnMaterial, 0, SpringLayout.EAST, projectsButton);
		
		btnExtraCheckoutMaterials = new JButton("Extra Checkout Materials");
		currentLayout.putConstraint(SpringLayout.WEST, btnExtraCheckoutMaterials, 120, SpringLayout.EAST, scroll);
		GridBagConstraints gbc_btnExtraCheckoutMaterials = new GridBagConstraints();
		gbc_btnExtraCheckoutMaterials.insets = new Insets(0, 0, 5, 5);
		gbc_btnExtraCheckoutMaterials.gridx = 3;
		gbc_btnExtraCheckoutMaterials.gridy = 6;
		panel.add(btnExtraCheckoutMaterials, gbc_btnExtraCheckoutMaterials);
		
		btnNewButton_1 = new JButton("Lab Materials");
		currentLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 120, SpringLayout.EAST, scroll);
		currentLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -127, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 133, SpringLayout.NORTH, this);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 7;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		
	}
}
