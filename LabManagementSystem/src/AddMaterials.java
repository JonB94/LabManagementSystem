import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;


public class AddMaterials extends JPanel {
	private JTextField textField_name;
	private JTextField textField_quantity;
	private JTextField textField_modelnumber;
	private JTextField textField_manufacturer;
	private JTextField textField_returnable;

	private SpringLayout currentLayout;
	
	/**
	 * Create the panel.
	 */
	public AddMaterials() {
		
		
		setPreferredSize(new Dimension(900,600));
		currentLayout = new SpringLayout();
		setBackground(new Color(255,255,255));
		this.setLayout(currentLayout);
		
		JLabel lblAddMaterial = DefaultComponentFactory.getInstance().createLabel("Add Material");
		currentLayout.putConstraint(SpringLayout.NORTH, lblAddMaterial, 0, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, lblAddMaterial, 295, SpringLayout.WEST, this);
		lblAddMaterial.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblAddMaterial.setForeground(Color.ORANGE);
		lblAddMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMaterial.setBounds(125, 11, 172, 29);
		add(lblAddMaterial);
		
		textField_name = new JTextField();
		currentLayout.putConstraint(SpringLayout.EAST, textField_name, -345, SpringLayout.EAST, this);
		textField_name.setBounds(125, 51, 247, 20);
		add(textField_name);
		textField_name.setColumns(10);
		
		textField_quantity = new JTextField();
		currentLayout.putConstraint(SpringLayout.WEST, textField_quantity, 343, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.EAST, textField_quantity, 0, SpringLayout.EAST, textField_name);
		textField_quantity.setColumns(10);
		textField_quantity.setBounds(125, 82, 247, 20);
		add(textField_quantity);
		
		textField_modelnumber = new JTextField();
		currentLayout.putConstraint(SpringLayout.SOUTH, textField_modelnumber, -287, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, textField_modelnumber, -345, SpringLayout.EAST, this);
		textField_modelnumber.setColumns(10);
		textField_modelnumber.setBounds(125, 113, 247, 20);
		add(textField_modelnumber);
		
		textField_manufacturer = new JTextField();
		currentLayout.putConstraint(SpringLayout.NORTH, textField_manufacturer, 70, SpringLayout.SOUTH, textField_modelnumber);
		currentLayout.putConstraint(SpringLayout.EAST, textField_manufacturer, -345, SpringLayout.EAST, this);
		textField_manufacturer.setColumns(10);
		textField_manufacturer.setBounds(125, 144, 247, 20);
		add(textField_manufacturer);
		
		textField_returnable = new JTextField();
		currentLayout.putConstraint(SpringLayout.EAST, textField_returnable, -345, SpringLayout.EAST, this);
		textField_returnable.setText("TRUE");
		textField_returnable.setColumns(10);
		textField_returnable.setBounds(125, 175, 247, 20);
		add(textField_returnable);
		
		JLabel lblName = DefaultComponentFactory.getInstance().createLabel("Name");
		currentLayout.putConstraint(SpringLayout.NORTH, textField_name, -3, SpringLayout.NORTH, lblName);
		currentLayout.putConstraint(SpringLayout.WEST, textField_name, 66, SpringLayout.EAST, lblName);
		lblName.setBounds(27, 53, 101, 17);
		add(lblName);
		
		JLabel lblModelNumber = DefaultComponentFactory.getInstance().createLabel("Model Number");
		currentLayout.putConstraint(SpringLayout.WEST, textField_modelnumber, 49, SpringLayout.EAST, lblModelNumber);
		currentLayout.putConstraint(SpringLayout.EAST, lblModelNumber, -606, SpringLayout.EAST, this);
		lblModelNumber.setBounds(27, 82, 101, 20);
		add(lblModelNumber);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Quantity");
		currentLayout.putConstraint(SpringLayout.NORTH, textField_quantity, -3, SpringLayout.NORTH, lblNewJgoodiesLabel);
		currentLayout.putConstraint(SpringLayout.SOUTH, lblNewJgoodiesLabel, -390, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.NORTH, lblModelNumber, 86, SpringLayout.SOUTH, lblNewJgoodiesLabel);
		currentLayout.putConstraint(SpringLayout.EAST, lblNewJgoodiesLabel, -623, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, lblName, -86, SpringLayout.NORTH, lblNewJgoodiesLabel);
		currentLayout.putConstraint(SpringLayout.EAST, lblName, 0, SpringLayout.EAST, lblNewJgoodiesLabel);
		lblNewJgoodiesLabel.setBounds(27, 113, 101, 20);
		add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Manufacturer");
		currentLayout.putConstraint(SpringLayout.WEST, textField_manufacturer, 38, SpringLayout.EAST, lblNewJgoodiesLabel_1);
		currentLayout.putConstraint(SpringLayout.NORTH, lblNewJgoodiesLabel_1, 76, SpringLayout.SOUTH, lblModelNumber);
		currentLayout.putConstraint(SpringLayout.EAST, lblNewJgoodiesLabel_1, -595, SpringLayout.EAST, this);
		lblNewJgoodiesLabel_1.setBounds(27, 144, 101, 20);
		add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Returnable?");
		currentLayout.putConstraint(SpringLayout.NORTH, textField_returnable, -3, SpringLayout.NORTH, lblNewJgoodiesLabel_2);
		currentLayout.putConstraint(SpringLayout.WEST, textField_returnable, 38, SpringLayout.EAST, lblNewJgoodiesLabel_2);
		currentLayout.putConstraint(SpringLayout.NORTH, lblNewJgoodiesLabel_2, 87, SpringLayout.SOUTH, lblNewJgoodiesLabel_1);
		currentLayout.putConstraint(SpringLayout.EAST, lblNewJgoodiesLabel_2, 0, SpringLayout.EAST, lblNewJgoodiesLabel_1);
		lblNewJgoodiesLabel_2.setBounds(27, 175, 101, 20);
		add(lblNewJgoodiesLabel_2);
		
		JButton btnSubmit = new JButton("Submit");
		currentLayout.putConstraint(SpringLayout.NORTH, btnSubmit, -1, SpringLayout.NORTH, textField_modelnumber);
		currentLayout.putConstraint(SpringLayout.WEST, btnSubmit, 91, SpringLayout.EAST, textField_modelnumber);
		add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser admin = (AdminUser) User.getUser(User.USER_ADMIN);
				try {
					ArrayList<String> fields = new ArrayList<String>();
					fields.add(textField_name.getText());
					fields.add(textField_modelnumber.getText());
					fields.add(textField_quantity.getText().trim());
					fields.add(textField_manufacturer.getText());
					fields.add(textField_returnable.getText());
					int count = DatabaseHandler.getDatabaseHandler().executeUpdate(admin.addMaterials(), fields);
					if(count >= 1){
						System.out.println("Successfully added " + count + " of " + textField_name.getText());
					}
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not properly fetch the projects");
				}
				
			}
		});

	}
}
