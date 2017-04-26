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
	private JTextArea outputArea;
	private SpringLayout currentLayout;
	private JScrollPane scroll;
	
	public StandardMainMenu(){
		
		setPreferredSize(new Dimension(900,600));
		projectsButton = new JButton("Projects");		
		currentLayout = new SpringLayout();
		currentLayout.putConstraint(SpringLayout.SOUTH, projectsButton, -283, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, projectsButton, -66, SpringLayout.EAST, this);
		outputArea = new JTextArea();
		outputArea.setPreferredSize(new Dimension(450,1000));
		outputArea.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		outputArea.setEditable(true);
		scroll = new JScrollPane (outputArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(500,600));
		
		
		setupPanel();
	}

	private void setupPanel() {
		setBackground(new Color(255,255,255));
		this.setLayout(currentLayout);
		this.add(projectsButton);
		this.add(scroll);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);
		
	}
}
