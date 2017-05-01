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
		currentLayout.putConstraint(SpringLayout.EAST, button_ViewEmployees, -191, SpringLayout.EAST, this);
		add(button_ViewEmployees);
		
		JButton button_AddMaterials = new JButton("Add Materials");
		currentLayout.putConstraint(SpringLayout.EAST, button_AddMaterials, 0, SpringLayout.EAST, button_ViewEmployees);
		add(button_AddMaterials);
		
		JButton button_CreateProject = new JButton("Create Project");
		currentLayout.putConstraint(SpringLayout.NORTH, button_CreateProject, 153, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, button_AddMaterials, -20, SpringLayout.NORTH, button_CreateProject);
		currentLayout.putConstraint(SpringLayout.NORTH, button_ViewEmployees, 78, SpringLayout.SOUTH, button_CreateProject);
		currentLayout.putConstraint(SpringLayout.EAST, button_CreateProject, 0, SpringLayout.EAST, button_ViewEmployees);
		add(button_CreateProject);
		
		JButton button_ViewProjects = new JButton("View Projects");
		currentLayout.putConstraint(SpringLayout.NORTH, button_ViewProjects, 17, SpringLayout.SOUTH, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, button_ViewProjects, 0, SpringLayout.EAST, button_ViewEmployees);
		add(button_ViewProjects);
		
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
