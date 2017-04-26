import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private JPanel currentPanel;
	
	public MainFrame(){
		currentPanel = new StandardMainMenu();
	
		setupFrame();
	}
	
	private void setupFrame(){
		this.setContentPane(currentPanel);
	}
}
