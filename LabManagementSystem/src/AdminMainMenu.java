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
		
		
		JButton button_ViewEmployees = new JButton("View Employees");
		add(button_ViewEmployees);
		
		JButton button_AddMaterials = new JButton("Add Materials");
		currentLayout.putConstraint(SpringLayout.EAST, button_AddMaterials, -191, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.EAST, button_ViewEmployees, 0, SpringLayout.EAST, button_AddMaterials);
		add(button_AddMaterials);
		
		JButton button_CreateProject = new JButton("Create Project");
		currentLayout.putConstraint(SpringLayout.EAST, button_CreateProject, -191, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, button_ViewEmployees, 23, SpringLayout.SOUTH, button_CreateProject);
		currentLayout.putConstraint(SpringLayout.NORTH, button_CreateProject, 153, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, button_AddMaterials, -20, SpringLayout.NORTH, button_CreateProject);
		add(button_CreateProject);
		
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
		
		JButton button = new JButton("Extra Checkout Materials");
		currentLayout.putConstraint(SpringLayout.NORTH, button, 381, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, button_ViewEmployees);
		add(button);
		
		JButton button_1 = new JButton("Return Material");
		currentLayout.putConstraint(SpringLayout.SOUTH, button_1, -16, SpringLayout.NORTH, button);
		currentLayout.putConstraint(SpringLayout.EAST, button_1, 0, SpringLayout.EAST, button_ViewEmployees);
		add(button_1);
		
		JButton button_2 = new JButton("Checkout Material");
		currentLayout.putConstraint(SpringLayout.NORTH, button_2, 31, SpringLayout.SOUTH, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, button_2, 0, SpringLayout.EAST, button_ViewEmployees);
		add(button_2);
		
		JButton button_3 = new JButton("Projects");
		currentLayout.putConstraint(SpringLayout.NORTH, button_3, 17, SpringLayout.SOUTH, button);
		currentLayout.putConstraint(SpringLayout.EAST, button_3, 0, SpringLayout.EAST, button_ViewEmployees);
		add(button_3);
		
		JButton button_4 = new JButton("My Projects");
		currentLayout.putConstraint(SpringLayout.NORTH, button_4, 26, SpringLayout.SOUTH, button_2);
		currentLayout.putConstraint(SpringLayout.EAST, button_4, 0, SpringLayout.EAST, button_ViewEmployees);
		add(button_4);
		
		JButton btnGetMaterialsBy = new JButton("Get Materials by User");
		currentLayout.putConstraint(SpringLayout.NORTH, btnGetMaterialsBy, 21, SpringLayout.SOUTH, button_3);
		currentLayout.putConstraint(SpringLayout.EAST, btnGetMaterialsBy, 0, SpringLayout.EAST, button_ViewEmployees);
		add(btnGetMaterialsBy);
		
		JButton btnGetLastChecked = new JButton("Get Last Checked out Materials");
		currentLayout.putConstraint(SpringLayout.NORTH, btnGetLastChecked, 11, SpringLayout.SOUTH, btnGetMaterialsBy);
		currentLayout.putConstraint(SpringLayout.EAST, btnGetLastChecked, 0, SpringLayout.EAST, button_ViewEmployees);
		add(btnGetLastChecked);
		
		button_CreateProject.addActionListener(new ActionListener(){
			MainFrame menus = new MainFrame();
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				menus.loadNewFrame(new CreateProject());
				
			}
			
			
		});
		button_AddMaterials.addActionListener(new ActionListener(){
			MainFrame menus = new MainFrame();
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				menus.loadNewFrame(new AddMaterials());
				
			}
			
			
		});
		
		

	}
}
