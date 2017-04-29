import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.UIManager;

public class StandardMainMenu extends JPanel {

	private JButton projectsButton;
	private JButton checkoutButton;
	private SpringLayout currentLayout;
	private JScrollPane scroll;
	
	public StandardMainMenu(){
		
		setPreferredSize(new Dimension(900,600));
		projectsButton = new JButton("Projects");		
		currentLayout = new SpringLayout();
		currentLayout.putConstraint(SpringLayout.SOUTH, projectsButton, -283, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, projectsButton, -66, SpringLayout.EAST, this);
		scroll = new JScrollPane (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(500,600));
		
		
		setupPanel();
	}

	private void setupPanel() {
		setBackground(new Color(255,255,255));
		this.setLayout(currentLayout);
		this.add(projectsButton);
		
		JButton btnNewButton = new JButton("Manager");
		currentLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 27, SpringLayout.SOUTH, projectsButton);
		currentLayout.putConstraint(SpringLayout.WEST, btnNewButton, 244, SpringLayout.EAST, scroll);
		currentLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -233, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, btnNewButton, -66, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.WEST, projectsButton, 0, SpringLayout.WEST, btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnNewButton);
		this.add(scroll);
		
	}
}
