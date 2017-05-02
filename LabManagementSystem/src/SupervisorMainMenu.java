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
		
		JButton createProject = new JButton("Create Project");
		JButton button = new JButton("Lab Materials");
		JButton btnViewEmployees = new JButton("Employee List");
		JButton btnResearchersUnderMe = new JButton("Researchers Under Me");
		JButton button_1 = new JButton("Checkout Material");
		JButton addMaterials = new JButton("Add Materials");
		JButton button_3 = new JButton("Extra Checkout Materials");
		JButton btnNewButton = new JButton("My Projects");
		JButton button_2 = new JButton("Return Material");
		JButton btnViewProjects = new JButton("View Projects");
		
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
		
		JPanel panel = new JPanel();
		currentLayout.putConstraint(SpringLayout.NORTH, panel, 54, SpringLayout.SOUTH, lblNewJgoodiesLabel);
		currentLayout.putConstraint(SpringLayout.WEST, panel, 6, SpringLayout.EAST, scrollPane);
		currentLayout.putConstraint(SpringLayout.SOUTH, panel, -23, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, this);
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{126, 5, 128, 0};
		gbl_panel.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		currentLayout.putConstraint(SpringLayout.NORTH, btnResearchersUnderMe, 23, SpringLayout.SOUTH, createProject);
		currentLayout.putConstraint(SpringLayout.NORTH, createProject, 24, SpringLayout.SOUTH, addMaterials);
		currentLayout.putConstraint(SpringLayout.EAST, createProject, 0, SpringLayout.EAST, addMaterials);
		
		
		GridBagConstraints gbc_createProject = new GridBagConstraints();
		gbc_createProject.insets = new Insets(0, 0, 5, 0);
		gbc_createProject.gridx = 2;
		gbc_createProject.gridy = 1;
		panel.add(createProject, gbc_createProject);
		
		
		createProject.addActionListener(new ActionListener(){
			MainFrame menus = new MainFrame();
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				menus.loadNewFrame(new CreateProject());
				
			}
			
			
		});
		currentLayout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, addMaterials);
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 2;
		gbc_button.gridy = 2;
		panel.add(button, gbc_button);
		currentLayout.putConstraint(SpringLayout.SOUTH, button, -23, SpringLayout.NORTH, btnViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, btnViewEmployees, 0, SpringLayout.EAST, addMaterials);
		
	
		btnViewEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnViewEmployees = new GridBagConstraints();
		gbc_btnViewEmployees.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewEmployees.gridx = 2;
		gbc_btnViewEmployees.gridy = 3;
		panel.add(btnViewEmployees, gbc_btnViewEmployees);
		currentLayout.putConstraint(SpringLayout.SOUTH, btnViewEmployees, -249, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, btnResearchersUnderMe, 0, SpringLayout.EAST, addMaterials);
		
	
		GridBagConstraints gbc_btnResearchersUnderMe = new GridBagConstraints();
		gbc_btnResearchersUnderMe.insets = new Insets(0, 0, 5, 0);
		gbc_btnResearchersUnderMe.gridx = 2;
		gbc_btnResearchersUnderMe.gridy = 4;
		panel.add(btnResearchersUnderMe, gbc_btnResearchersUnderMe);
		currentLayout.putConstraint(SpringLayout.EAST, button_1, 0, SpringLayout.EAST, addMaterials);
		
	
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 5;
		panel.add(button_1, gbc_button_1);
		
		
		GridBagConstraints gbc_addMaterials = new GridBagConstraints();
		gbc_addMaterials.insets = new Insets(0, 0, 5, 0);
		gbc_addMaterials.gridx = 2;
		gbc_addMaterials.gridy = 6;
		panel.add(addMaterials, gbc_addMaterials);
		currentLayout.putConstraint(SpringLayout.NORTH, addMaterials, 138, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, addMaterials, -147, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.EAST, button_3, 0, SpringLayout.EAST, addMaterials);
		
		
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 0);
		gbc_button_3.gridx = 2;
		gbc_button_3.gridy = 7;
		panel.add(button_3, gbc_button_3);
		currentLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, addMaterials);
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 8;
		panel.add(btnNewButton, gbc_btnNewButton);
		currentLayout.putConstraint(SpringLayout.NORTH, button_1, 16, SpringLayout.SOUTH, btnNewButton);
		
		
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 9;
		panel.add(button_2, gbc_button_2);
		currentLayout.putConstraint(SpringLayout.NORTH, button_2, 16, SpringLayout.SOUTH, button_1);
		currentLayout.putConstraint(SpringLayout.EAST, button_2, 0, SpringLayout.EAST, addMaterials);
		currentLayout.putConstraint(SpringLayout.NORTH, button_3, 16, SpringLayout.SOUTH, button_2);
		currentLayout.putConstraint(SpringLayout.EAST, btnViewProjects, 0, SpringLayout.EAST, addMaterials);
		
		
		GridBagConstraints gbc_btnViewProjects = new GridBagConstraints();
		gbc_btnViewProjects.gridx = 2;
		gbc_btnViewProjects.gridy = 10;
		panel.add(btnViewProjects, gbc_btnViewProjects);
		currentLayout.putConstraint(SpringLayout.NORTH, btnViewProjects, 20, SpringLayout.SOUTH, btnViewEmployees);
		currentLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 13, SpringLayout.SOUTH, btnViewProjects);
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
