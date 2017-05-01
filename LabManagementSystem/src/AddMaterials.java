import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;


public class AddMaterials extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public AddMaterials() {
		setLayout(null);
		
		JLabel lblAddMaterial = DefaultComponentFactory.getInstance().createLabel("Add Material");
		lblAddMaterial.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddMaterial.setForeground(Color.ORANGE);
		lblAddMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMaterial.setBounds(125, 11, 172, 29);
		add(lblAddMaterial);
		
		textField = new JTextField();
		textField.setBounds(125, 51, 247, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(125, 82, 247, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(125, 113, 247, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(125, 144, 247, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(125, 175, 247, 20);
		add(textField_4);
		
		JLabel label = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
		label.setBounds(27, 54, 88, 14);
		add(label);

	}
}
