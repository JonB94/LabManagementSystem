import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.SpringLayout;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Button;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.UIManager;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class SupervisorMainMenu extends JPanel {
	
	private SpringLayout currentLayout;
	
	
	
	/**
	 * Create the panel.
	 */
	public SupervisorMainMenu() {
		setPreferredSize(new Dimension(900,600));
		currentLayout = new SpringLayout();
		setBackground(UIManager.getColor("Button.background"));
		this.setLayout(currentLayout);
		
		JButton addMaterials = new JButton("Add Materials");
		currentLayout.putConstraint(SpringLayout.NORTH, addMaterials, 138, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, addMaterials, -147, SpringLayout.EAST, this);
		addMaterials.setBounds(136, 154, 113, 23);
		add(addMaterials);
		
		JButton createProject = new JButton("Create Project");
		currentLayout.putConstraint(SpringLayout.NORTH, createProject, 24, SpringLayout.SOUTH, addMaterials);
		currentLayout.putConstraint(SpringLayout.EAST, createProject, 0, SpringLayout.EAST, addMaterials);
		createProject.setBounds(136, 188, 113, 23);
		add(createProject);
		
		JButton btnViewEmployees = new JButton("Employee List");
		currentLayout.putConstraint(SpringLayout.SOUTH, btnViewEmployees, -249, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, btnViewEmployees, 0, SpringLayout.EAST, addMaterials);
		add(btnViewEmployees);
		
		JButton btnViewProjects = new JButton("View Projects");
		currentLayout.putConstraint(SpringLayout.NORTH, btnViewProjects, 20, SpringLayout.SOUTH, btnViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, btnViewProjects, 0, SpringLayout.EAST, addMaterials);
		add(btnViewProjects);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Supervisor");
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		currentLayout.putConstraint(SpringLayout.NORTH, lblNewJgoodiesLabel, 10, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, lblNewJgoodiesLabel, 350, SpringLayout.WEST, this);
		add(lblNewJgoodiesLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		currentLayout.putConstraint(SpringLayout.NORTH, scrollPane, 9, SpringLayout.SOUTH, lblNewJgoodiesLabel);
		currentLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 536, SpringLayout.SOUTH, lblNewJgoodiesLabel);
		currentLayout.putConstraint(SpringLayout.EAST, scrollPane, 449, SpringLayout.WEST, this);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("My Projects");
		currentLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 13, SpringLayout.SOUTH, btnViewProjects);
		currentLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, addMaterials);
		add(btnNewButton);
		
		JButton button = new JButton("Lab Materials");
		currentLayout.putConstraint(SpringLayout.SOUTH, button, -23, SpringLayout.NORTH, btnViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, addMaterials);
		add(button);
		
		JButton button_1 = new JButton("Checkout Material");
		currentLayout.putConstraint(SpringLayout.NORTH, button_1, 16, SpringLayout.SOUTH, btnNewButton);
		currentLayout.putConstraint(SpringLayout.EAST, button_1, 0, SpringLayout.EAST, addMaterials);
		add(button_1);
		
		JButton button_2 = new JButton("Return Material");
		currentLayout.putConstraint(SpringLayout.NORTH, button_2, 16, SpringLayout.SOUTH, button_1);
		currentLayout.putConstraint(SpringLayout.EAST, button_2, 0, SpringLayout.EAST, addMaterials);
		add(button_2);
		
		JButton button_3 = new JButton("Extra Checkout Materials");
		currentLayout.putConstraint(SpringLayout.NORTH, button_3, 16, SpringLayout.SOUTH, button_2);
		currentLayout.putConstraint(SpringLayout.EAST, button_3, 0, SpringLayout.EAST, addMaterials);
		add(button_3);
		
		JButton btnResearchersUnderMe = new JButton("Researchers Under Me");
		currentLayout.putConstraint(SpringLayout.NORTH, btnResearchersUnderMe, 23, SpringLayout.SOUTH, createProject);
		currentLayout.putConstraint(SpringLayout.EAST, btnResearchersUnderMe, 0, SpringLayout.EAST, addMaterials);
		add(btnResearchersUnderMe);
		
		
		createProject.addActionListener(new ActionListener(){
			MainFrame menus = new MainFrame();
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				menus.loadNewFrame(new CreateProject());
				
			}
			
			
		});
		addMaterials.addActionListener(new ActionListener(){
			MainFrame menus = new MainFrame();
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				menus.loadNewFrame(new AddMaterials());
				
			}
			
			
		});

	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
