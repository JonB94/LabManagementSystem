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


public class SupervisorMainMenu extends JPanel {
	
	private SpringLayout currentLayout;
	
	
	/**
	 * Create the panel.
	 */
	public SupervisorMainMenu() {
		setPreferredSize(new Dimension(900,600));
		currentLayout = new SpringLayout();
		setBackground(new Color(255,255,255));
		this.setLayout(currentLayout);
		
		JButton addMaterials = new JButton("Add Materials");
		currentLayout.putConstraint(SpringLayout.NORTH, addMaterials, 144, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, addMaterials, 174, SpringLayout.WEST, this);
		addMaterials.setBounds(136, 154, 113, 23);
		add(addMaterials);
		
		JButton createProject = new JButton("Create Project");
		currentLayout.putConstraint(SpringLayout.NORTH, createProject, 28, SpringLayout.SOUTH, addMaterials);
		currentLayout.putConstraint(SpringLayout.EAST, createProject, 0, SpringLayout.EAST, addMaterials);
		createProject.setBounds(136, 188, 113, 23);
		add(createProject);
		
		JMenuBar menuBar = new JMenuBar();
		currentLayout.putConstraint(SpringLayout.WEST, menuBar, 126, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, menuBar, -61, SpringLayout.NORTH, addMaterials);
		menuBar.setBounds(10, 10, 97, 21);
		add(menuBar);
		
		Button projects = new Button("Projects");
		currentLayout.putConstraint(SpringLayout.NORTH, projects, 45, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, projects, 102, SpringLayout.EAST, menuBar);
		projects.setBounds(537, 154, 102, 22);
		add(projects);
		
		JMenu menu = new JMenu("New menu");
		currentLayout.putConstraint(SpringLayout.WEST, menu, 196, SpringLayout.EAST, addMaterials);
		currentLayout.putConstraint(SpringLayout.SOUTH, menu, 0, SpringLayout.SOUTH, addMaterials);
		add(menu);
		menu.setForeground(Color.BLACK);
		menu.setBackground(Color.GRAY);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open Main Menu");
		menu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		menu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		menu.add(mntmNewMenuItem_3);

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
}
