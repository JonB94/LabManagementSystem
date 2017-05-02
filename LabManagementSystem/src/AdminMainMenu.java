import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class AdminMainMenu extends JPanel {

	private SpringLayout currentLayout;
	
	/**
	 * Create the panel.
	 */
	public AdminMainMenu() {
		
		setPreferredSize(new Dimension(900,600));
		currentLayout = new SpringLayout();
		setBackground(UIManager.getColor("Button.background"));
		this.setLayout(currentLayout);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Admin");
		currentLayout.putConstraint(SpringLayout.NORTH, lblNewJgoodiesLabel, 10, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, lblNewJgoodiesLabel, 374, SpringLayout.WEST, this);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		add(lblNewJgoodiesLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		currentLayout.putConstraint(SpringLayout.NORTH, scrollPane, 105, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, scrollPane, 436, SpringLayout.WEST, this);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		currentLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, scrollPane);
		currentLayout.putConstraint(SpringLayout.WEST, panel, 18, SpringLayout.EAST, scrollPane);
		currentLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, scrollPane);
		currentLayout.putConstraint(SpringLayout.EAST, panel, 171, SpringLayout.EAST, this);
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{109, 97, 103, 153, 107, 119, 71, 89, 135, 181, 0};
		gbl_panel.rowHeights = new int[] {50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		JButton button_ViewEmployees = new JButton("View Employees");
		GridBagConstraints gbc_button_ViewEmployees = new GridBagConstraints();
		gbc_button_ViewEmployees.insets = new Insets(0, 0, 5, 5);
		gbc_button_ViewEmployees.gridx = 4;
		gbc_button_ViewEmployees.gridy = 1;
		panel.add(button_ViewEmployees, gbc_button_ViewEmployees);
		
		JButton button_AddMaterials = new JButton("Add Materials");
		GridBagConstraints gbc_button_AddMaterials = new GridBagConstraints();
		gbc_button_AddMaterials.insets = new Insets(0, 0, 5, 5);
		gbc_button_AddMaterials.gridx = 4;
		gbc_button_AddMaterials.gridy = 2;
		panel.add(button_AddMaterials, gbc_button_AddMaterials);
		currentLayout.putConstraint(SpringLayout.EAST, button_AddMaterials, -191, SpringLayout.EAST, this);
		button_AddMaterials.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Driver.getMainFrame().loadNewFrame(new AddMaterials());
				
			}
			
			
		});
		currentLayout.putConstraint(SpringLayout.EAST, button_ViewEmployees, 0, SpringLayout.EAST, button_AddMaterials);
		
		JButton button_CreateProject = new JButton("Create Project");
		GridBagConstraints gbc_button_CreateProject = new GridBagConstraints();
		gbc_button_CreateProject.insets = new Insets(0, 0, 5, 5);
		gbc_button_CreateProject.gridx = 4;
		gbc_button_CreateProject.gridy = 3;
		panel.add(button_CreateProject, gbc_button_CreateProject);
		currentLayout.putConstraint(SpringLayout.EAST, button_CreateProject, -191, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, button_CreateProject, 153, SpringLayout.NORTH, this);
		
		button_CreateProject.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Driver.getMainFrame().loadNewFrame(new CreateProject());
				
			}
			
			
		});
		currentLayout.putConstraint(SpringLayout.NORTH, button_ViewEmployees, 23, SpringLayout.SOUTH, button_CreateProject);
		currentLayout.putConstraint(SpringLayout.SOUTH, button_AddMaterials, -20, SpringLayout.NORTH, button_CreateProject);
		
		JButton button = new JButton("Extra Checkout Materials");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 4;
		panel.add(button, gbc_button);
		currentLayout.putConstraint(SpringLayout.NORTH, button, 381, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, button_ViewEmployees);
		
		JButton button_1 = new JButton("Return Material");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 5;
		panel.add(button_1, gbc_button_1);
		currentLayout.putConstraint(SpringLayout.EAST, button_1, 0, SpringLayout.EAST, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.SOUTH, button_1, -16, SpringLayout.NORTH, button);
		
		JButton button_2 = new JButton("Checkout Material");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 4;
		gbc_button_2.gridy = 6;
		panel.add(button_2, gbc_button_2);
		currentLayout.putConstraint(SpringLayout.NORTH, button_2, 31, SpringLayout.SOUTH, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, button_2, 0, SpringLayout.EAST, button_ViewEmployees);
		
		JButton button_3 = new JButton("Projects");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 4;
		gbc_button_3.gridy = 7;
		panel.add(button_3, gbc_button_3);
		currentLayout.putConstraint(SpringLayout.EAST, button_3, 0, SpringLayout.EAST, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.NORTH, button_3, 17, SpringLayout.SOUTH, button);
		
		JButton button_4 = new JButton("My Projects");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 4;
		gbc_button_4.gridy = 8;
		panel.add(button_4, gbc_button_4);
		currentLayout.putConstraint(SpringLayout.EAST, button_4, 0, SpringLayout.EAST, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.NORTH, button_4, 26, SpringLayout.SOUTH, button_2);
		
		JButton btnGetMaterialsBy = new JButton("Get Materials by User");
		GridBagConstraints gbc_btnGetMaterialsBy = new GridBagConstraints();
		gbc_btnGetMaterialsBy.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetMaterialsBy.gridx = 4;
		gbc_btnGetMaterialsBy.gridy = 9;
		panel.add(btnGetMaterialsBy, gbc_btnGetMaterialsBy);
		currentLayout.putConstraint(SpringLayout.EAST, btnGetMaterialsBy, 0, SpringLayout.EAST, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.NORTH, btnGetMaterialsBy, 21, SpringLayout.SOUTH, button_3);
		
		JButton btnGetLastChecked = new JButton("Get Last Checked out Materials");
		GridBagConstraints gbc_btnGetLastChecked = new GridBagConstraints();
		gbc_btnGetLastChecked.insets = new Insets(0, 0, 0, 5);
		gbc_btnGetLastChecked.gridx = 4;
		gbc_btnGetLastChecked.gridy = 10;
		panel.add(btnGetLastChecked, gbc_btnGetLastChecked);
		currentLayout.putConstraint(SpringLayout.EAST, btnGetLastChecked, 0, SpringLayout.EAST, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.NORTH, btnGetLastChecked, 11, SpringLayout.SOUTH, btnGetMaterialsBy);
		
		

	}
}
