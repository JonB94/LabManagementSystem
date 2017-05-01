import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
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

	/**
	 * Create the panel.
	 */
	public SupervisorMainMenu() {
		setLayout(null);
		
		JButton addMaterials = new JButton("Add Materials");
		addMaterials.setBounds(136, 154, 113, 23);
		add(addMaterials);
		
		JButton createProject = new JButton("Create Project");
		createProject.setBounds(136, 188, 113, 23);
		add(createProject);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 10, 97, 21);
		add(menuBar);
		
		JMenu menu = new JMenu("New menu");
		menuBar.add(menu);
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
		
		Button projects = new Button("Projects");
		projects.setBounds(532, 155, 102, 22);
		add(projects);

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
