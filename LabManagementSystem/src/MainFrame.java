import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private JPanel currentPanel;
	
	public MainFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setupFrame(){
		this.setContentPane(currentPanel);
		this.pack();
		this.setVisible(true);
	}
	
	public void loadNewFrame(JPanel newPanel){
		currentPanel = newPanel;
		
		setupFrame();
	}
}
