import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.UIManager;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.BoxLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StandardMainMenu extends JPanel {

	private JButton projectsButton;
	private JButton checkoutButton;
	private SpringLayout currentLayout;
	private JScrollPane scroll;
	private JTextArea textArea;
	private JButton btnMyProjects;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnReturnMaterial;
	private JButton btnExtraCheckoutMaterials;
	private JButton btnGetPhoto;
	private JButton btnGetUsersMaterials;
	private JButton btnGetProgressReport;
	private JButton btnUpdateProgressReport;
	private JButton btnGetSupervisor;
	
	public StandardMainMenu(){
		
		setPreferredSize(new Dimension(900,600));
		textArea = new JTextArea();
		textArea.setSize(new Dimension(500,600));
		currentLayout = new SpringLayout();
		btnNewButton = new JButton("Employee List");
		btnMyProjects = new JButton("My Projects");
		projectsButton = new JButton("Projects");
		btnNewButton_2 = new JButton("Checkout Material");
		btnReturnMaterial = new JButton("Return Material");
		btnExtraCheckoutMaterials = new JButton("Extra Checkout Materials");
		btnNewButton_1 = new JButton("Lab Materials");
		btnGetPhoto = new JButton("Get Employee Photo");
		btnGetUsersMaterials = new JButton("Get User's Materials");
		scroll = new JScrollPane (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		currentLayout.putConstraint(SpringLayout.NORTH, scroll, -524, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, scroll, 0, SpringLayout.SOUTH, this);
		scroll.setPreferredSize(new Dimension(500,600));
		scroll.add(textArea);
		
		setupPanel();
	}

	private void setupPanel() {
		setBackground(UIManager.getColor("Button.background"));
		this.setLayout(currentLayout);
		this.add(scroll);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblEmployee.setForeground(Color.ORANGE);
		currentLayout.putConstraint(SpringLayout.NORTH, lblEmployee, 10, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, lblEmployee, 341, SpringLayout.WEST, this);
		add(lblEmployee);
		
		JPanel panel = new JPanel();
		currentLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, scroll);
		currentLayout.putConstraint(SpringLayout.WEST, panel, 6, SpringLayout.EAST, scroll);
		currentLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, this);
		add(panel);
		currentLayout.putConstraint(SpringLayout.NORTH, btnReturnMaterial, 6, SpringLayout.SOUTH, btnNewButton_2);
		currentLayout.putConstraint(SpringLayout.NORTH, btnMyProjects, 6, SpringLayout.SOUTH, btnNewButton);
		currentLayout.putConstraint(SpringLayout.EAST, btnMyProjects, 0, SpringLayout.EAST, btnNewButton);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{107, 119, 71, 89, 97, 153, 95, 0};
		gbl_panel.rowHeights = new int[] {100, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		currentLayout.putConstraint(SpringLayout.WEST, btnNewButton, 120, SpringLayout.EAST, scroll);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StandardUser user = (StandardUser) User.getUser(User.USER_RESEARCHER);
				
				try {
									
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getEmployees(), new ArrayList<String>(), 
							new ArrayList<Integer>());
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
		currentLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, btnNewButton_1);
		currentLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnNewButton_1);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 1;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		
		btnMyProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StandardUser user = (StandardUser) User.getUser(User.USER_RESEARCHER);
				
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
		currentLayout.putConstraint(SpringLayout.WEST, btnMyProjects, 120, SpringLayout.EAST, scroll);
		currentLayout.putConstraint(SpringLayout.NORTH, btnExtraCheckoutMaterials, 93, SpringLayout.SOUTH, btnMyProjects);
		GridBagConstraints gbc_btnMyProjects = new GridBagConstraints();
		gbc_btnMyProjects.insets = new Insets(0, 0, 5, 5);
		gbc_btnMyProjects.gridx = 3;
		gbc_btnMyProjects.gridy = 2;
		panel.add(btnMyProjects, gbc_btnMyProjects);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StandardUser user = (StandardUser) User.getUser(User.USER_RESEARCHER);
				
				try {
					String[] output = Graphics.createGeneralInputBox(
							new String[]{"Employee ID", "Amount", "Model Number"},
							"Checkout");
					
					ArrayList<String> input = new ArrayList<String>(Arrays.asList(output));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					types.add(Types.NUMERIC);
					types.add(Types.NUMERIC);
					types.add(Types.NUMERIC);
					
					int count = DatabaseHandler.getDatabaseHandler().executeUpdate(user.checkoutMaterial(),
							input, 
							types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					ResultSetMetaData meta = rs.getMetaData();
					textArea.setText("");
					textArea.append("Successfully created " + count + " rows");
					
					
					ArrayList<String> updateMaterials = new ArrayList<String>();
					updateMaterials.add(input.get(1));
					updateMaterials.add(input.get(2));
					types.remove(2);
					DatabaseHandler.getDatabaseHandler().executeUpdate(user.removeMaterial(),
								updateMaterials, 
								types);
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		
		
		currentLayout.putConstraint(SpringLayout.WEST, projectsButton, 120, SpringLayout.EAST, scroll);
		projectsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User stand = User.getUser(User.USER_RESEARCHER);
				try {
					DatabaseHandler.getDatabaseHandler().executeStatement(stand.getProjects(), new ArrayList<String>(), new ArrayList<Integer>());
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					ResultSetMetaData meta = DatabaseHandler.getDatabaseHandler().getMetaData();
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
					Graphics.createErrorMessage("Could not properly fetch the projects");
				}
				
			}
		});
		currentLayout.putConstraint(SpringLayout.NORTH, projectsButton, 6, SpringLayout.SOUTH, btnMyProjects);
		currentLayout.putConstraint(SpringLayout.EAST, projectsButton, 0, SpringLayout.EAST, btnMyProjects);
		GridBagConstraints gbc_projectsButton = new GridBagConstraints();
		gbc_projectsButton.insets = new Insets(0, 0, 5, 5);
		gbc_projectsButton.gridx = 3;
		gbc_projectsButton.gridy = 3;
		panel.add(projectsButton, gbc_projectsButton);
		
		currentLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 120, SpringLayout.EAST, scroll);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 4;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		currentLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 6, SpringLayout.SOUTH, projectsButton);
		currentLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, projectsButton);
		
		
		btnReturnMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StandardUser user = (StandardUser) User.getUser(User.USER_RESEARCHER);
				
				try {
					
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"Amount returned", "Model Number"}, 
							"Create");
					
					ArrayList<String> test = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.NUMERIC);
					types.add(Types.NUMERIC);
					
					
					int count = DatabaseHandler.getDatabaseHandler().executeUpdate(user.returnMaterial(), test, 
							types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
					textArea.setText("");
					textArea.append("Successfully created " + count + " rows");
					
					DatabaseHandler.getDatabaseHandler().executeUpdate(user.returnMaterial(), test, types);
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		currentLayout.putConstraint(SpringLayout.WEST, btnReturnMaterial, 120, SpringLayout.EAST, scroll);
		GridBagConstraints gbc_btnReturnMaterial = new GridBagConstraints();
		gbc_btnReturnMaterial.insets = new Insets(0, 0, 5, 5);
		gbc_btnReturnMaterial.gridx = 3;
		gbc_btnReturnMaterial.gridy = 5;
		panel.add(btnReturnMaterial, gbc_btnReturnMaterial);
		currentLayout.putConstraint(SpringLayout.EAST, btnReturnMaterial, 0, SpringLayout.EAST, projectsButton);
		
		btnExtraCheckoutMaterials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StandardUser user = (StandardUser) User.getUser(User.USER_RESEARCHER);
				
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
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getExtraCheckoutMaterials(), new ArrayList<String>(), 
							new ArrayList<Integer>());
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
		currentLayout.putConstraint(SpringLayout.WEST, btnExtraCheckoutMaterials, 120, SpringLayout.EAST, scroll);
		GridBagConstraints gbc_btnExtraCheckoutMaterials = new GridBagConstraints();
		gbc_btnExtraCheckoutMaterials.insets = new Insets(0, 0, 5, 5);
		gbc_btnExtraCheckoutMaterials.gridx = 3;
		gbc_btnExtraCheckoutMaterials.gridy = 6;
		panel.add(btnExtraCheckoutMaterials, gbc_btnExtraCheckoutMaterials);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StandardUser user = (StandardUser) User.getUser(User.USER_RESEARCHER);
				
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
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getLabMaterials(), new ArrayList<String>(), 
							new ArrayList<Integer>());
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
		currentLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 120, SpringLayout.EAST, scroll);
		currentLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -127, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 133, SpringLayout.NORTH, this);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 7;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		
		btnGetPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StandardUser user = (StandardUser) User.getUser(User.USER_RESEARCHER);
				
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
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getPhoto(), new ArrayList<String>(), 
							new ArrayList<Integer>());
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		
		
		btnGetUsersMaterials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StandardUser user = (StandardUser) User.getUser(User.USER_RESEARCHER);
				
				try {
					
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"First name", "Last name"}, 
							"Get Materials");
					
					ArrayList<String> test = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.VARCHAR);
					types.add(Types.VARCHAR);
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getCheckoutMaterialsByUser(), test, 
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
		GridBagConstraints gbc_btnGetUsersMaterials = new GridBagConstraints();
		gbc_btnGetUsersMaterials.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetUsersMaterials.gridx = 3;
		gbc_btnGetUsersMaterials.gridy = 8;
		panel.add(btnGetUsersMaterials, gbc_btnGetUsersMaterials);
		GridBagConstraints gbc_btnGetPhoto = new GridBagConstraints();
		gbc_btnGetPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetPhoto.gridx = 3;
		gbc_btnGetPhoto.gridy = 9;
		panel.add(btnGetPhoto, gbc_btnGetPhoto);
		
		JButton btnUpdateEmployeePhoto = new JButton("Update Employee Photo");
		btnUpdateEmployeePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StandardUser user = (StandardUser) User.getUser(User.USER_RESEARCHER);
				
				try {
					
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"Photo", "Employee ID"}, 
							"Create");
					
					ArrayList<String> test = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.BLOB);
					types.add(Types.NUMERIC);
					
					
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.updatePicture(), test, 
							types);
					ResultSet rs = DatabaseHandler.getDatabaseHandler().getResultSet();
				} catch (SQLException e) {
					Graphics.createErrorMessage("Could not execute the query properly");
				}
				
			}
		});
		GridBagConstraints gbc_btnUpdateEmployeePhoto = new GridBagConstraints();
		gbc_btnUpdateEmployeePhoto.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdateEmployeePhoto.gridx = 3;
		gbc_btnUpdateEmployeePhoto.gridy = 10;
		panel.add(btnUpdateEmployeePhoto, gbc_btnUpdateEmployeePhoto);
		
		btnGetProgressReport = new JButton("Get Progress Report");
		GridBagConstraints gbc_btnGetProgressReport = new GridBagConstraints();
		gbc_btnGetProgressReport.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetProgressReport.gridx = 3;
		gbc_btnGetProgressReport.gridy = 11;
		panel.add(btnGetProgressReport, gbc_btnGetProgressReport);
		
		btnUpdateProgressReport = new JButton("Update Progress Report");
		GridBagConstraints gbc_btnUpdateProgressReport = new GridBagConstraints();
		gbc_btnUpdateProgressReport.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdateProgressReport.gridx = 3;
		gbc_btnUpdateProgressReport.gridy = 12;
		panel.add(btnUpdateProgressReport, gbc_btnUpdateProgressReport);
		
		btnGetSupervisor = new JButton("Get Employees of Supervisor");
		btnGetSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StandardUser user = (StandardUser) User.getUser(User.USER_RESEARCHER);
				
				try {
					
					String [] outputs = Graphics.createGeneralInputBox(
							new String[]{"first name", "last name"}, 
							"Employees Under");
					
					ArrayList<String> test = new ArrayList<String>(Arrays.asList(outputs));
					
					ArrayList<Integer> types = new ArrayList<Integer>();
					
					types.add(Types.VARCHAR);
					types.add(Types.VARCHAR);
					
					
					
					DatabaseHandler.getDatabaseHandler().executeStatement(user.getResearchersUnderSup(), test, 
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
		
		GridBagConstraints gbc_btnGetSupervisor = new GridBagConstraints();
		gbc_btnGetSupervisor.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetSupervisor.gridx = 3;
		gbc_btnGetSupervisor.gridy = 13;
		panel.add(btnGetSupervisor, gbc_btnGetSupervisor);
		
		
	}
	
	private String prepareForTextArea(ResultSet rs, int type, int col){
		String output = "";
		try{
			if(type == Types.NUMERIC){
				output = output + rs.getInt(col) + "\t";
			}else if (type == Types.VARCHAR){
				output = output + rs.getString(col) + "\t";
			}else if (type == Types.DATE)
				output = output + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(rs.getDate(col)) + "\t";
		}catch(SQLException e){
			Graphics.createErrorMessage("Could not print out the query to text area");
		}
		return output;
	}
	
	private void outputClob(Clob clob, String fileName){
		BufferedReader read = DatabaseHandler.handleCLOB(clob);
		try{
			File f = new File(fileName);
			FileWriter fr = new FileWriter(f);
			BufferedWriter writer  = new BufferedWriter(fr);
			String line = "";
			while ((line = read.readLine()) != null){
				writer.write(line);
				writer.newLine();
			}
		}catch(IOException e){
			Graphics.createErrorMessage("Could not write to that file name");
		}
	}
	
	//private void outputBlob(Blob blob){
	//	blob.
	//}
}
