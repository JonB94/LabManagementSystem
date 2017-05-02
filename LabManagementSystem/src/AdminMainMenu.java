import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;


public class AdminMainMenu extends JPanel {

	private SpringLayout currentLayout;
	
	/**
	 * Create the panel.
	 */
	public AdminMainMenu() {
		
		setPreferredSize(new Dimension(900,600));
		currentLayout = new SpringLayout();
		setBackground(UIManager.getColor("Button.background"));
		this.setLayout(currentLayout);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Admin");
		currentLayout.putConstraint(SpringLayout.NORTH, lblNewJgoodiesLabel, 10, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, lblNewJgoodiesLabel, 374, SpringLayout.WEST, this);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		add(lblNewJgoodiesLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		currentLayout.putConstraint(SpringLayout.NORTH, scrollPane, 105, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, scrollPane, 436, SpringLayout.WEST, this);
		add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		textArea.setRows(10);
		textArea.setBackground(UIManager.getColor("Button.background"));
		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		currentLayout.putConstraint(SpringLayout.NORTH, panel, 51, SpringLayout.SOUTH, lblNewJgoodiesLabel);
		currentLayout.putConstraint(SpringLayout.WEST, panel, 18, SpringLayout.EAST, scrollPane);
		currentLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, scrollPane);
		currentLayout.putConstraint(SpringLayout.EAST, panel, 171, SpringLayout.EAST, this);
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{109, 97, 103, 153, 107, 119, 71, 89, 135, 181, 0};
		gbl_panel.rowHeights = new int[] {50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		
		JButton button_ViewEmployees = new JButton("View Employees");
		button_ViewEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getEmployees(),
							new ArrayList<String>(), new ArrayList<Integer>());
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					ResultSetMetaData meta = rs.getMetaData();
					String out = "";
					while(rs.next()){
						
						for(int i = 1; i <= meta.getColumnCount(); i++){
							out = out + prepareForTextArea(rs, meta.getColumnType(i), i);
						}
						out = out + "\n";
					}
					textArea.setText("");
					textArea.append(out);
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		GridBagConstraints gbc_button_ViewEmployees = new GridBagConstraints();
		gbc_button_ViewEmployees.insets = new Insets(0, 0, 5, 5);
		gbc_button_ViewEmployees.gridx = 4;
		gbc_button_ViewEmployees.gridy = 3;
		panel.add(button_ViewEmployees, gbc_button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, button_ViewEmployees, 0, SpringLayout.EAST, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.NORTH, button_ViewEmployees, 23, SpringLayout.SOUTH, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, button_ViewEmployees, 0, SpringLayout.EAST, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, button_ViewEmployees, 0, SpringLayout.EAST, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.NORTH, button_ViewEmployees, 31, SpringLayout.SOUTH, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, button_ViewEmployees, 0, SpringLayout.EAST, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, button_ViewEmployees, 0, SpringLayout.EAST, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, button_ViewEmployees, 0, SpringLayout.EAST, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, button_ViewEmployees, 0, SpringLayout.EAST, button_ViewEmployees);
		currentLayout.putConstraint(SpringLayout.EAST, button_ViewEmployees, 0, SpringLayout.EAST, button_ViewEmployees);
		
		JButton button_AddMaterials = new JButton("Add Materials");
		
		GridBagConstraints gbc_button_AddMaterials = new GridBagConstraints();
		gbc_button_AddMaterials.insets = new Insets(0, 0, 5, 5);
		gbc_button_AddMaterials.gridx = 4;
		gbc_button_AddMaterials.gridy = 4;
		panel.add(button_AddMaterials, gbc_button_AddMaterials);
		currentLayout.putConstraint(SpringLayout.EAST, button_AddMaterials, -191, SpringLayout.EAST, this);
		button_AddMaterials.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"Name", "Model Number", "Quantity", "Manufacturer", "Returnable? (TRUE/FALSE)"}, 
							"Add Material");
					
					ArrayList<String> test = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.VARCHAR);
					types.add(Types.NUMERIC);
					types.add(Types.NUMERIC);
					types.add(Types.VARCHAR);
					types.add(Types.VARCHAR);
					
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.addMaterials(), test, 
							types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					System.out.println("updated");
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
			
			
			
			
		});
		currentLayout.putConstraint(SpringLayout.SOUTH, button_AddMaterials, -20, SpringLayout.NORTH, button_ViewEmployees);
		
		JButton button_CreateProject = new JButton("Create Project");
		button_CreateProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"Project name", "Project number", "Start date", "Supervisor ID"}, 
							"Create");
					
					ArrayList<String> test = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.VARCHAR);
					types.add(Types.NUMERIC);
					types.add(Types.DATE);
					types.add(Types.NUMERIC);
					
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.createNewProject(), test, 
							types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		GridBagConstraints gbc_button_CreateProject = new GridBagConstraints();
		gbc_button_CreateProject.insets = new Insets(0, 0, 5, 5);
		gbc_button_CreateProject.gridx = 4;
		gbc_button_CreateProject.gridy = 5;
		panel.add(button_CreateProject, gbc_button_CreateProject);
		currentLayout.putConstraint(SpringLayout.EAST, button_CreateProject, -191, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, button_CreateProject, 153, SpringLayout.NORTH, this);
		
		
		JButton button_extraCheckout = new JButton("Extra Checkout Materials");
		button_extraCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					/*
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"First Name", "Last name", "Salary"}, 
							"Create");
					
					ArrayList<String> test = outputs;
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.VARCHAR);
					types.add(Types.VARCHAR);
					types.add(Types.NUMERIC);
					*/
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getExtraCheckoutMaterials(),
							new ArrayList<String>(), new ArrayList<Integer>());
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					ResultSetMetaData meta = rs.getMetaData();
					String out = "";
					while(rs.next()){
						
						for(int i = 1; i <= meta.getColumnCount(); i++){
							out = out + prepareForTextArea(rs, meta.getColumnType(i), i);
						}
						out = out + "\n";
					}
					textArea.setText("");
					textArea.append(out);
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		GridBagConstraints gbc_button_extraCheckout = new GridBagConstraints();
		gbc_button_extraCheckout.insets = new Insets(0, 0, 5, 5);
		gbc_button_extraCheckout.gridx = 4;
		gbc_button_extraCheckout.gridy = 6;
		panel.add(button_extraCheckout, gbc_button_extraCheckout);
		currentLayout.putConstraint(SpringLayout.NORTH, button_extraCheckout, 381, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, button_ViewEmployees, -16, SpringLayout.NORTH, button_extraCheckout);
		currentLayout.putConstraint(SpringLayout.NORTH, button_ViewEmployees, 17, SpringLayout.SOUTH, button_extraCheckout);
		
		JButton button_Return = new JButton("Return Material");
		button_Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"Amount returned", "Model Number"}, 
							"Create");
					
					ArrayList<String> test = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.NUMERIC);
					types.add(Types.NUMERIC);
					
					
					DatabaseHandler.getDatabaseHandler().executeUpdate(user.returnMaterial(), test, 
							types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					System.out.println("updated");
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		GridBagConstraints gbc_button_Return = new GridBagConstraints();
		gbc_button_Return.insets = new Insets(0, 0, 5, 5);
		gbc_button_Return.gridx = 4;
		gbc_button_Return.gridy = 7;
		panel.add(button_Return, gbc_button_Return);
		
		JButton button_checkout = new JButton("Checkout Material");
		button_checkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"Employee ID", "Amount", "Model Number", "Return Deadline"}, 
							"Create");
					
					ArrayList<String> test = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.NUMERIC);
					types.add(Types.NUMERIC);
					types.add(Types.NUMERIC);
					types.add(Types.DATE);
					
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.checkoutMaterial(), test, 
							types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		GridBagConstraints gbc_button_checkout = new GridBagConstraints();
		gbc_button_checkout.insets = new Insets(0, 0, 5, 5);
		gbc_button_checkout.gridx = 4;
		gbc_button_checkout.gridy = 8;
		panel.add(button_checkout, gbc_button_checkout);
		currentLayout.putConstraint(SpringLayout.NORTH, button_ViewEmployees, 26, SpringLayout.SOUTH, button_checkout);
		
		JButton button_projects = new JButton("Projects");
		button_projects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				try {
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getProjects(),
							new ArrayList<String>(), new ArrayList<Integer>());
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					ResultSetMetaData meta = rs.getMetaData();
					String out = "";
					while(rs.next()){
						
						for(int i = 1; i <= meta.getColumnCount(); i++){
							out = out + prepareForTextArea(rs, meta.getColumnType(i), i);
						}
						out = out + "\n";
					}
					textArea.setText("");
					textArea.append(out);
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		GridBagConstraints gbc_button_projects = new GridBagConstraints();
		gbc_button_projects.insets = new Insets(0, 0, 5, 5);
		gbc_button_projects.gridx = 4;
		gbc_button_projects.gridy = 9;
		panel.add(button_projects, gbc_button_projects);
		currentLayout.putConstraint(SpringLayout.NORTH, button_ViewEmployees, 21, SpringLayout.SOUTH, button_projects);
		
		JButton button_myProjects = new JButton("My Projects");
		button_myProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					String[] output = Graphics.createGeneralInputBox(new String[]{"First Name", "Last Name"},
							"Projects");
					
					ArrayList<String> input = new ArrayList<String>(Arrays.asList(output));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					types.add(Types.VARCHAR);
					types.add(Types.VARCHAR);
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getProjectsForUser(),
							input, 
							types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					ResultSetMetaData meta = rs.getMetaData();
					String out = "";
					while(rs.next()){
						
						for(int i = 1; i <= meta.getColumnCount(); i++){
							out = out + prepareForTextArea(rs, meta.getColumnType(i), i);
						}
						out = out + "\n";
					}
					textArea.setText("");
					textArea.append(out);
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		GridBagConstraints gbc_button_myProjects = new GridBagConstraints();
		gbc_button_myProjects.insets = new Insets(0, 0, 5, 5);
		gbc_button_myProjects.gridx = 4;
		gbc_button_myProjects.gridy = 10;
		panel.add(button_myProjects, gbc_button_myProjects);
		
		JButton btnGetMaterialsBy = new JButton("Get Materials by User");
		btnGetMaterialsBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					String[] output = Graphics.createGeneralInputBox(new String[]{"First Name", "Last Name"},
							"Materials");
					
					ArrayList<String> input = new ArrayList<String>(Arrays.asList(output));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					types.add(Types.VARCHAR);
					types.add(Types.VARCHAR);
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getCheckoutMaterialsByUser(),
							input, 
							types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					ResultSetMetaData meta = rs.getMetaData();
					String out = "";
					while(rs.next()){
						
						for(int i = 1; i <= meta.getColumnCount(); i++){
							out = out + prepareForTextArea(rs, meta.getColumnType(i), i);
						}
						out = out + "\n";
					}
					textArea.setText("");
					textArea.append(out);
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
			}
		});
		GridBagConstraints gbc_btnGetMaterialsBy = new GridBagConstraints();
		gbc_btnGetMaterialsBy.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetMaterialsBy.gridx = 4;
		gbc_btnGetMaterialsBy.gridy = 12;
		panel.add(btnGetMaterialsBy, gbc_btnGetMaterialsBy);
		currentLayout.putConstraint(SpringLayout.NORTH, button_ViewEmployees, 11, SpringLayout.SOUTH, btnGetMaterialsBy);
		
		JButton btnGetLastChecked = new JButton("Get Last Checked out Materials");
		btnGetLastChecked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					/*
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"First name", "Last name"}, 
							"Create");
					
					ArrayList<String> test = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.VARCHAR);
					types.add(Types.VARCHAR);
					*/
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getLastCheckouts(),
							new ArrayList<String>(), new ArrayList<Integer>());
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					ResultSetMetaData meta = rs.getMetaData();
					String out = "";
					while(rs.next()){
						
						for(int i = 1; i <= meta.getColumnCount(); i++){
							out = out + prepareForTextArea(rs, meta.getColumnType(i), i);
						}
						out = out + "\n";
					}
					textArea.setText("");
					textArea.append(out);
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
			}
		});
		GridBagConstraints gbc_btnGetLastChecked = new GridBagConstraints();
		gbc_btnGetLastChecked.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetLastChecked.gridx = 4;
		gbc_btnGetLastChecked.gridy = 13;
		panel.add(btnGetLastChecked, gbc_btnGetLastChecked);
		
		JButton btnGetPhoto = new JButton("Get Employee Photo");
		btnGetPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					String[] outputs = Graphics.createGeneralInputBox(new String[]{"Employee ID"},
							"Profile Picture");
					
					ArrayList<String> input = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					types.add(Types.NUMERIC);
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getPhoto(), input, types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					ResultSetMetaData meta = DatabaseHandler.getDatabaseHandler().getMetaData();
					while(rs.next()){
						BufferedImage bi = null;
						for(int i = 1; i <= meta.getColumnCount(); i++){
							bi = DatabaseHandler.handleBLOB(rs.getBlob(i));
						}
						Image output = bi;
						ImageIcon icon = new ImageIcon(output);
						JOptionPane.showMessageDialog(
		                        null,
		                        "",
		                        "Profile Picture", JOptionPane.INFORMATION_MESSAGE,
		                        icon);
					}
						System.out.println();
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		GridBagConstraints gbc_btnGetPhoto = new GridBagConstraints();
		gbc_btnGetPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetPhoto.gridx = 4;
		gbc_btnGetPhoto.gridy = 14;
		panel.add(btnGetPhoto, gbc_btnGetPhoto);
		
		JButton button_UpdateEmployeePhoto = new JButton("Update Employee Photo");
		button_UpdateEmployeePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"Photo Path", "Employee ID"}, 
							"Create");
					
					ArrayList<String> test = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.BLOB);
					types.add(Types.NUMERIC);
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.updatePicture(), test, 
							types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					textArea.setText("");
					textArea.append("Successfully changed the profile picture\n");
					
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		GridBagConstraints gbc_button_UpdateEmployeePhoto = new GridBagConstraints();
		gbc_button_UpdateEmployeePhoto.insets = new Insets(0, 0, 5, 5);
		gbc_button_UpdateEmployeePhoto.gridx = 4;
		gbc_button_UpdateEmployeePhoto.gridy = 15;
		panel.add(button_UpdateEmployeePhoto, gbc_button_UpdateEmployeePhoto);
		
		JButton btnRemoveResearcher = new JButton("Remove Researcher");
		btnRemoveResearcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"Employee ID"}, 
							"Create");
					
					ArrayList<String> test = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.NUMERIC);
					
					
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.removeResearcher(), test, 
							types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		
		JButton btnAddResearcher = new JButton("Add Researcher");
		btnAddResearcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"First name", "Last name", "Employee ID", "SSN", "Date of birth", "SEX", "Address", "Supervisor ID", "Employee Photo"}, 
							"Add Researcher");
					
					ArrayList<String> test = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.VARCHAR);
					types.add(Types.VARCHAR);
					types.add(Types.NUMERIC);
					types.add(Types.NUMERIC);
					types.add(Types.DATE);
					types.add(Types.VARCHAR);
					types.add(Types.VARCHAR);
					types.add(Types.NUMERIC);
					types.add(Types.BLOB);
					
					
					DatabaseHandler.getDatabaseHandler().executeUpdate(user.createNewProject(), test, 
							types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					System.out.println("updated");
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		GridBagConstraints gbc_btnAddResearcher = new GridBagConstraints();
		gbc_btnAddResearcher.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddResearcher.gridx = 4;
		gbc_btnAddResearcher.gridy = 16;
		panel.add(btnAddResearcher, gbc_btnAddResearcher);
		
		
		GridBagConstraints gbc_btnRemoveResearcher = new GridBagConstraints();
		gbc_btnRemoveResearcher.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemoveResearcher.gridx = 4;
		gbc_btnRemoveResearcher.gridy = 17;
		panel.add(btnRemoveResearcher, gbc_btnRemoveResearcher);
		
		JButton btnGetMaterialsOf = new JButton("Get All Materials");
		btnGetMaterialsOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getLabMaterials(),
							new ArrayList<String>(), new ArrayList<Integer>());
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					ResultSetMetaData meta = rs.getMetaData();
					String out = "";
					while(rs.next()){
						
						for(int i = 1; i <= meta.getColumnCount(); i++){
							out = out + prepareForTextArea(rs, meta.getColumnType(i), i);
						}
						out = out + "\n";
					}
					textArea.setText("");
					textArea.append(out);
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		GridBagConstraints gbc_btnGetMaterialsOf = new GridBagConstraints();
		gbc_btnGetMaterialsOf.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetMaterialsOf.gridx = 4;
		gbc_btnGetMaterialsOf.gridy = 18;
		panel.add(btnGetMaterialsOf, gbc_btnGetMaterialsOf);
		
		JButton btnRefillMaterials = new JButton("Refill Materials");
		btnRefillMaterials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser user = (AdminUser) User.getUser(User.USER_ADMIN);
				
				try {
					
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"Manufacturer"}, 
							"Create");
					
					ArrayList<String> test = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.VARCHAR);
					
					
					DatabaseHandler.getDatabaseHandler().executeUpdate(user.refillMaterials(), test, 
							types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					System.out.println("Successfully updated");
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		GridBagConstraints gbc_btnRefillMaterials = new GridBagConstraints();
		gbc_btnRefillMaterials.insets = new Insets(0, 0, 5, 5);
		gbc_btnRefillMaterials.gridx = 4;
		gbc_btnRefillMaterials.gridy = 19;
		panel.add(btnRefillMaterials, gbc_btnRefillMaterials);
		
		

	}
	
	private String prepareForTextArea(ResultSet rs, int type, int col){
		String output = "";
		try{
			if(type == Types.NUMERIC){
				output = output + rs.getInt(col) + "\t";
			}else if (type == Types.VARCHAR){
				output = output + rs.getString(col) + "\t";
			}
		}catch(SQLException e){
			Graphics.createErrorMessage("Could not print out the query to text area");
		}
		return output;
	}
}
