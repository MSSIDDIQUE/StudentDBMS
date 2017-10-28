package WindowsBuilder.GUI;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Choice;
import javax.swing.JFileChooser;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class EmployeeActions {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeActions window = new EmployeeActions();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection conn=null;
	private JTextField StudentIdField;
	private JTextField NameField;
	private JTextField ParentNameField;
	private JTextField AddressField;
	private JTextField AccountNoField;
	private JTextField ContactNoField;
	private JTextField FeeStatusField;
	private JTextField GradeField;
	private JTextField DateOfBirthField;
	private JTextField EnterStudentIdField;
	private JTextField SearchField;
	private JTextField SurnameField;
	private JTextField BloodGroupField;
	private JTextField ShowStudentIdField;
	private JTextField ShowNameField;
	private JTextField ShowSurnameField;
	private JTextField ShowParentNameField;
	private JTextField ShowAddressField;
	private JTextField ShowAccountNoField;
	private JTextField ShowContactNoField;
	private JTextField ShowFeeStatusField;
	private JTextField ShowGradeField;
	private JTextField ShowDateOfBirthField;
	private JTextField ShowBloodGroupField;
	private JPanel UpdateUrInfo; 
	private JComboBox ShowClassComboBox;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	public EmployeeActions() {
		initialize();
		conn=WindowsBuilder.Backend.StudentDBConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 61, 139));
		panel.setBounds(0, 0, 180, 361);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNavigation = new JLabel("Menu");
		lblNavigation.setIcon(new ImageIcon(EmployeeActions.class.getResource("/WindowsBuilder/Resourses/icons8_Bulleted_List_48px.png")));
		lblNavigation.setForeground(new Color(0, 0, 0));
		lblNavigation.setHorizontalAlignment(SwingConstants.CENTER);
		lblNavigation.setBackground(new Color(220, 20, 60));
		lblNavigation.setFont(new Font("Eras Medium ITC", Font.BOLD, 33));
		lblNavigation.setBounds(0, 0, 147, 52);
		panel.add(lblNavigation);
		
		JPanel ParentPanel = new JPanel();
		ParentPanel.setBounds(180, 0, 804, 361);
		frame.getContentPane().add(ParentPanel);
		ParentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel ShowDatabase = new JPanel();
		ShowDatabase.setBackground(new Color(0, 206, 209));
		ParentPanel.add(ShowDatabase, "name_16071224913638");
		ShowDatabase.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 20, 60));
		panel_1.setBounds(0, 0, 804, 54);
		ShowDatabase.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblClasses = new JLabel("Class Wise Databases");
		panel_1.add(lblClasses);
		lblClasses.setBackground(new Color(220, 20, 60));
		lblClasses.setFont(new Font("Eras Medium ITC", Font.BOLD, 30));
		lblClasses.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 165, 0));
		panel_1.add(menuBar);
		
		JMenu mnstClass = new JMenu("I st");
		mnstClass.setBackground(new Color(124, 252, 0));
		mnstClass.setHorizontalAlignment(SwingConstants.CENTER);
		mnstClass.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		menuBar.add(mnstClass);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane_1.setBounds(0, 103, 804, 258);
		ShowDatabase.add(scrollPane_1);
		
		JTable table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row=table.getSelectedRow();
					String TableClick=table.getModel().getValueAt(row, 0).toString();
					String Query="select *from StudentInfo where StudentId=?";
					PreparedStatement pst=conn.prepareStatement(Query);
					pst.setString(1, TableClick);
					ResultSet rs=pst.executeQuery();
					ParentPanel.removeAll();
					ParentPanel.add(UpdateUrInfo);
					ParentPanel.repaint();
					ParentPanel.revalidate();
					if(rs.next())
					{
						String ShowStudentId=rs.getString("StudentId");
						ShowStudentIdField.setText(ShowStudentId);
						String ShowName=rs.getString("Name");
						ShowNameField.setText(ShowName);
						String ShowSurname=rs.getString("Surname");
						ShowSurnameField.setText(ShowSurname);
						String ShowClass=rs.getString("Class");
						ShowClassComboBox.setSelectedItem(ShowClass);
						String ShowParentName=rs.getString("ParentName");
						ShowParentNameField.setText(ShowParentName);
						String ShowAddress=rs.getString("Address");
						ShowAddressField.setText(ShowAddress);
						String ShowAccountNo=rs.getString("AccNo");
						ShowAccountNoField.setText(ShowAccountNo);
						String ShowContactNo=rs.getString("ContactNo");
						ShowContactNoField.setText(ShowContactNo);
						String ShowFeeStatus=rs.getString("FeeStatus");
						ShowFeeStatusField.setText(ShowFeeStatus);
						String ShowGrade=rs.getString("Grade");
						ShowGradeField.setText(ShowGrade);
						String ShowDateOfBirth=rs.getString("DOB");
						ShowDateOfBirthField.setText(ShowDateOfBirth);
						String ShowBloodGroup=rs.getString("BloodGroup");
						ShowBloodGroupField.setText(ShowBloodGroup);
					}
					
				}catch(Exception e5)
				{
					JOptionPane.showMessageDialog(null,e5);
				}
			}
		});
		scrollPane_1.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
		JMenuItem IstA = new JMenuItem("A");
		IstA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IstA'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
			}
			}
		});
		IstA.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IstA.setHorizontalAlignment(SwingConstants.CENTER);
		IstA.setBackground(new Color(220, 20, 60));
		mnstClass.add(IstA);
		
		JMenuItem IstB = new JMenuItem("B");
		IstB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IstB'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		IstB.setHorizontalAlignment(SwingConstants.CENTER);
		IstB.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IstB.setBackground(new Color(220, 20, 60));
		mnstClass.add(IstB);
		
		JMenuItem IstC = new JMenuItem("C");
		IstC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IstC'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		IstC.setHorizontalAlignment(SwingConstants.CENTER);
		IstC.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IstC.setBackground(new Color(220, 20, 60));
		mnstClass.add(IstC);
		
		JMenu mnIiNd = new JMenu("II nd");
		mnIiNd.setHorizontalAlignment(SwingConstants.CENTER);
		mnIiNd.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		mnIiNd.setBackground(new Color(124, 252, 0));
		menuBar.add(mnIiNd);
		
		JMenuItem IIndA = new JMenuItem("A");
		IIndA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IIndA'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		IIndA.setHorizontalAlignment(SwingConstants.CENTER);
		IIndA.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IIndA.setBackground(new Color(220, 20, 60));
		mnIiNd.add(IIndA);
		
		JMenuItem IIndB = new JMenuItem("B");
		IIndB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IIndB'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			
			}
		});
		IIndB.setHorizontalAlignment(SwingConstants.CENTER);
		IIndB.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IIndB.setBackground(new Color(220, 20, 60));
		mnIiNd.add(IIndB);
		
		JMenuItem IIndC = new JMenuItem("C");
		IIndC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IIndC'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		IIndC.setHorizontalAlignment(SwingConstants.CENTER);
		IIndC.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IIndC.setBackground(new Color(220, 20, 60));
		mnIiNd.add(IIndC);
		
		JMenu mnIiiRd = new JMenu("III rd");
		mnIiiRd.setHorizontalAlignment(SwingConstants.CENTER);
		mnIiiRd.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		mnIiiRd.setBackground(new Color(124, 252, 0));
		menuBar.add(mnIiiRd);
		
		JMenuItem IIIrdA = new JMenuItem("A");
		IIIrdA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IIIrdA'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		IIIrdA.setHorizontalAlignment(SwingConstants.CENTER);
		IIIrdA.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IIIrdA.setBackground(new Color(220, 20, 60));
		mnIiiRd.add(IIIrdA);
		
		JMenuItem IIIrdB = new JMenuItem("B");
		IIIrdB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IIIrdB'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		IIIrdB.setHorizontalAlignment(SwingConstants.CENTER);
		IIIrdB.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IIIrdB.setBackground(new Color(220, 20, 60));
		mnIiiRd.add(IIIrdB);
		
		JMenuItem IIIrdC = new JMenuItem("C");
		IIIrdC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IIIrdC'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		IIIrdC.setHorizontalAlignment(SwingConstants.CENTER);
		IIIrdC.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IIIrdC.setBackground(new Color(220, 20, 60));
		mnIiiRd.add(IIIrdC);
		
		JMenu mnIvTh = new JMenu("IV th");
		mnIvTh.setHorizontalAlignment(SwingConstants.CENTER);
		mnIvTh.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		mnIvTh.setBackground(new Color(124, 252, 0));
		menuBar.add(mnIvTh);
		
		JMenuItem IVthA = new JMenuItem("A");
		IVthA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IVthA'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		IVthA.setHorizontalAlignment(SwingConstants.CENTER);
		IVthA.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IVthA.setBackground(new Color(220, 20, 60));
		mnIvTh.add(IVthA);
		
		JMenuItem IVthB = new JMenuItem("B");
		IVthB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IVthB'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		IVthB.setHorizontalAlignment(SwingConstants.CENTER);
		IVthB.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IVthB.setBackground(new Color(220, 20, 60));
		mnIvTh.add(IVthB);
		
		JMenuItem IVthC = new JMenuItem("C");
		IVthC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IVthC'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		IVthC.setHorizontalAlignment(SwingConstants.CENTER);
		IVthC.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IVthC.setBackground(new Color(220, 20, 60));
		mnIvTh.add(IVthC);
		
		JMenu mnVTh = new JMenu("V th");
		mnVTh.setHorizontalAlignment(SwingConstants.CENTER);
		mnVTh.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		mnVTh.setBackground(new Color(124, 252, 0));
		menuBar.add(mnVTh);
		
		JMenuItem VthA = new JMenuItem("A");
		VthA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='VthA'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		VthA.setHorizontalAlignment(SwingConstants.CENTER);
		VthA.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		VthA.setBackground(new Color(220, 20, 60));
		mnVTh.add(VthA);
		
		JMenuItem VthB = new JMenuItem("B");
		VthB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='VthB'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		VthB.setHorizontalAlignment(SwingConstants.CENTER);
		VthB.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		VthB.setBackground(new Color(220, 20, 60));
		mnVTh.add(VthB);
		
		JMenuItem VthC = new JMenuItem("C");
		VthC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='VthC'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		VthC.setHorizontalAlignment(SwingConstants.CENTER);
		VthC.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		VthC.setBackground(new Color(220, 20, 60));
		mnVTh.add(VthC);
		
		JMenu mnViTh = new JMenu("VI th");
		mnViTh.setHorizontalAlignment(SwingConstants.CENTER);
		mnViTh.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		mnViTh.setBackground(new Color(124, 252, 0));
		menuBar.add(mnViTh);
		
		JMenuItem VIthA = new JMenuItem("A");
		VIthA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='VIthA'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		VIthA.setHorizontalAlignment(SwingConstants.CENTER);
		VIthA.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		VIthA.setBackground(new Color(220, 20, 60));
		mnViTh.add(VIthA);
		
		JMenuItem VIthB = new JMenuItem("B");
		VIthB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='VIthB'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		VIthB.setHorizontalAlignment(SwingConstants.CENTER);
		VIthB.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		VIthB.setBackground(new Color(220, 20, 60));
		mnViTh.add(VIthB);
		
		JMenuItem VIthC = new JMenuItem("C");
		VIthC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='VIthC'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		VIthC.setHorizontalAlignment(SwingConstants.CENTER);
		VIthC.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		VIthC.setBackground(new Color(220, 20, 60));
		mnViTh.add(VIthC);
		
		JMenu mnViiTh = new JMenu("VII th");
		mnViiTh.setHorizontalAlignment(SwingConstants.CENTER);
		mnViiTh.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		mnViiTh.setBackground(new Color(124, 252, 0));
		menuBar.add(mnViiTh);
		
		JMenuItem VIIthA = new JMenuItem("A");
		VIIthA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='VIIthA'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		VIIthA.setHorizontalAlignment(SwingConstants.CENTER);
		VIIthA.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		VIIthA.setBackground(new Color(220, 20, 60));
		mnViiTh.add(VIIthA);
		
		JMenuItem VIIthB = new JMenuItem("B");
		VIIthB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='VIIthB'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		VIIthB.setHorizontalAlignment(SwingConstants.CENTER);
		VIIthB.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		VIIthB.setBackground(new Color(220, 20, 60));
		mnViiTh.add(VIIthB);
		
		JMenuItem VIIthC = new JMenuItem("C");
		VIIthC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='VIIthC'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		VIIthC.setHorizontalAlignment(SwingConstants.CENTER);
		VIIthC.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		VIIthC.setBackground(new Color(220, 20, 60));
		mnViiTh.add(VIIthC);
		
		JMenu mnViiiTh = new JMenu("VIII th");
		mnViiiTh.setHorizontalAlignment(SwingConstants.CENTER);
		mnViiiTh.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		mnViiiTh.setBackground(new Color(124, 252, 0));
		menuBar.add(mnViiiTh);
		
		JMenuItem VIIIthA = new JMenuItem("A");
		VIIIthA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='VIIIthA'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		VIIIthA.setHorizontalAlignment(SwingConstants.CENTER);
		VIIIthA.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		VIIIthA.setBackground(new Color(220, 20, 60));
		mnViiiTh.add(VIIIthA);
		
		JMenuItem VIIIthB = new JMenuItem("B");
		VIIIthB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='VIIIthB'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		VIIIthB.setHorizontalAlignment(SwingConstants.CENTER);
		VIIIthB.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		VIIIthB.setBackground(new Color(220, 20, 60));
		mnViiiTh.add(VIIIthB);
		
		JMenuItem VIIIthC = new JMenuItem("C");
		VIIIthC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='VIIIthC'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		VIIIthC.setHorizontalAlignment(SwingConstants.CENTER);
		VIIIthC.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		VIIIthC.setBackground(new Color(220, 20, 60));
		mnViiiTh.add(VIIIthC);
		
		JMenu mnIxTh = new JMenu("IX th");
		mnIxTh.setHorizontalAlignment(SwingConstants.CENTER);
		mnIxTh.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		mnIxTh.setBackground(new Color(124, 252, 0));
		menuBar.add(mnIxTh);
		
		JMenuItem IXthA = new JMenuItem("A");
		IXthA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IXthA'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		IXthA.setHorizontalAlignment(SwingConstants.CENTER);
		IXthA.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IXthA.setBackground(new Color(220, 20, 60));
		mnIxTh.add(IXthA);
		
		JMenuItem IXthB = new JMenuItem("B");
		IXthB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IXthB'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		IXthB.setHorizontalAlignment(SwingConstants.CENTER);
		IXthB.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IXthB.setBackground(new Color(220, 20, 60));
		mnIxTh.add(IXthB);
		
		JMenuItem IXthC = new JMenuItem("C");
		IXthC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='IXthC'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		IXthC.setHorizontalAlignment(SwingConstants.CENTER);
		IXthC.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		IXthC.setBackground(new Color(220, 20, 60));
		mnIxTh.add(IXthC);
		
		JMenu mnXTh = new JMenu("X th");
		mnXTh.setHorizontalAlignment(SwingConstants.CENTER);
		mnXTh.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		mnXTh.setBackground(new Color(124, 252, 0));
		menuBar.add(mnXTh);
		
		JMenuItem XthA = new JMenuItem("A");
		XthA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='XthA'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		XthA.setHorizontalAlignment(SwingConstants.CENTER);
		XthA.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		XthA.setBackground(new Color(220, 20, 60));
		mnXTh.add(XthA);
		
		JMenuItem XthB = new JMenuItem("B");
		XthB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='XthB'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		XthB.setHorizontalAlignment(SwingConstants.CENTER);
		XthB.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		XthB.setBackground(new Color(220, 20, 60));
		mnXTh.add(XthB);
		
		JMenuItem XthC = new JMenuItem("C");
		XthC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='XthC'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		XthC.setHorizontalAlignment(SwingConstants.CENTER);
		XthC.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		XthC.setBackground(new Color(220, 20, 60));
		mnXTh.add(XthC);
		
		JMenu mnXiTh = new JMenu("XI th");
		mnXiTh.setHorizontalAlignment(SwingConstants.CENTER);
		mnXiTh.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		mnXiTh.setBackground(new Color(124, 252, 0));
		menuBar.add(mnXiTh);
		
		JMenuItem XIthA = new JMenuItem("Science(A)");
		XIthA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='XIthA'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		XIthA.setHorizontalAlignment(SwingConstants.CENTER);
		XIthA.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		XIthA.setBackground(new Color(220, 20, 60));
		mnXiTh.add(XIthA);
		
		JMenuItem XIthB = new JMenuItem("Commerce(B)");
		XIthB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='XIthB'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		XIthB.setHorizontalAlignment(SwingConstants.CENTER);
		XIthB.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		XIthB.setBackground(new Color(220, 20, 60));
		mnXiTh.add(XIthB);
		
		JMenuItem XIthC = new JMenuItem("Arts(C)");
		XIthC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='XIthC'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		XIthC.setHorizontalAlignment(SwingConstants.CENTER);
		XIthC.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		XIthC.setBackground(new Color(220, 20, 60));
		mnXiTh.add(XIthC);
		
		JMenu mnXiiTh = new JMenu("XII th");
		mnXiiTh.setHorizontalAlignment(SwingConstants.CENTER);
		mnXiiTh.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		mnXiiTh.setBackground(new Color(124, 252, 0));
		menuBar.add(mnXiiTh);
		
		JMenuItem XIIthA = new JMenuItem("Science(A)");
		XIIthA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='XIIthA'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		XIIthA.setHorizontalAlignment(SwingConstants.CENTER);
		XIIthA.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		XIIthA.setBackground(new Color(220, 20, 60));
		mnXiiTh.add(XIIthA);
		
		JMenuItem XIIthB = new JMenuItem("Commerce(B)");
		XIIthB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='XIIthB'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		XIIthB.setHorizontalAlignment(SwingConstants.CENTER);
		XIIthB.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		XIIthB.setBackground(new Color(220, 20, 60));
		mnXiiTh.add(XIIthB);
		
		JMenuItem XIIthC = new JMenuItem("Arts(C)");
		XIIthC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     String Query="Select * from StudentInfo where Class='XIIthC'";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     ResultSet rs=pst.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
			}
		});
		XIIthC.setHorizontalAlignment(SwingConstants.CENTER);
		XIIthC.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
		XIIthC.setBackground(new Color(220, 20, 60));
		mnXiiTh.add(XIIthC);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"StudentId", "Name", "Surname"}));
		comboBox.setBounds(156, 60, 126, 28);
		ShowDatabase.add(comboBox);
		
		SearchField = new JTextField();
		SearchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String Query="";
					if(comboBox.getSelectedItem()=="Name")
					{
						Query="select * from StudentInfo where Name=?";
						PreparedStatement pst=conn.prepareStatement(Query);
						pst.setString(1, SearchField.getText());
						ResultSet rs=pst.executeQuery();
					     table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					else if(comboBox.getSelectedItem()=="StudentId")
					{   
						Query="select *from StudentInfo where StudentId=?";
						PreparedStatement pst=conn.prepareStatement(Query);
						pst.setString(1, SearchField.getText());
						ResultSet rs=pst.executeQuery();
					     table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					else if(comboBox.getSelectedItem()=="Surname")
					{   
						Query="select *from StudentInfo where Surname=?";
						PreparedStatement pst=conn.prepareStatement(Query);
						pst.setString(1, SearchField.getText());
						ResultSet rs=pst.executeQuery();
					     table.setModel(DbUtils.resultSetToTableModel(rs));
					}
				}catch(Exception e4)
				{
				}
			}
		});
		SearchField.setBounds(333, 60, 267, 28);
		ShowDatabase.add(SearchField);
		SearchField.setColumns(10);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Query="";
					if(comboBox.getSelectedItem()=="Name")
					{
						Query="select * from StudentInfo where Name=?";
						PreparedStatement pst=conn.prepareStatement(Query);
						pst.setString(1, SearchField.getText());
						ResultSet rs=pst.executeQuery();
					     table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					else if(comboBox.getSelectedItem()=="StudentId")
					{   
						Query="select *from StudentInfo where StudentId=?";
						PreparedStatement pst=conn.prepareStatement(Query);
						pst.setString(1, SearchField.getText());
						ResultSet rs=pst.executeQuery();
					     table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					else if(comboBox.getSelectedItem()=="Surname")
					{   
						Query="select *from StudentInfo where Surname=?";
						PreparedStatement pst=conn.prepareStatement(Query);
						pst.setString(1, SearchField.getText());
						ResultSet rs=pst.executeQuery();
					     table.setModel(DbUtils.resultSetToTableModel(rs));
					}
				}catch(Exception e4)
				{
				}
			}
		});
		button.setBackground(Color.DARK_GRAY);
		button.setIcon(new ImageIcon(EmployeeActions.class.getResource("/WindowsBuilder/Resourses/search.png")));
		button.setBounds(604, 60, 40, 28);
		ShowDatabase.add(button);
		
		JLabel lblSearchUsing = new JLabel("Search using:");
		lblSearchUsing.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchUsing.setFont(new Font("Eras Medium ITC", Font.BOLD, 18));
		lblSearchUsing.setBounds(0, 58, 155, 28);
		ShowDatabase.add(lblSearchUsing);
		
		JButton btnNewButton_3 = new JButton("Show All");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Q="Select * from StudentInfo";
					PreparedStatement pst=conn.prepareStatement(Q);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e7)
				{
					JOptionPane.showMessageDialog(null, e7);
				}
				
			}
		});
		btnNewButton_3.setBackground(new Color(255, 255, 0));
		btnNewButton_3.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		btnNewButton_3.setBounds(664, 60, 130, 28);
		ShowDatabase.add(btnNewButton_3);
		
		JPanel Issues = new JPanel();
		Issues.setBackground(new Color(255, 69, 0));
		ParentPanel.add(Issues, "name_16071240784630");
		
		JPanel Search = new JPanel();
		Search.setBackground(new Color(106, 90, 205));
		ParentPanel.add(Search, "name_16071255819013");
		Search.setLayout(null);
		
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setIcon(new ImageIcon(EmployeeActions.class.getResource("/WindowsBuilder/Resourses/icons8_Name_Tag_48px.png")));
		lblMyProfile.setBackground(new Color(220, 20, 60));
		lblMyProfile.setFont(new Font("Eras Medium ITC", Font.BOLD, 35));
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setBounds(0, 0, 804, 54);
		Search.add(lblMyProfile);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 140, 0));
		panel_5.setBounds(0, 0, 804, 54);
		Search.add(panel_5);
		panel_5.setLayout(null);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(747, 0, 57, 54);
		panel_5.add(button_1);
		
		JLabel label = new JLabel("");
		label.setBounds(638, 68, 150, 191);
		Search.add(label);
		
		JButton btnLoadImage = new JButton("Load Image");
		btnLoadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLoadImage.setBounds(638, 271, 150, 33);
		Search.add(btnLoadImage);
		
		JLabel lblEmployeeId = new JLabel("Employee Id:");
		lblEmployeeId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployeeId.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblEmployeeId.setBounds(22, 76, 105, 25);
		Search.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Name:");
		lblEmployeeName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployeeName.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblEmployeeName.setBounds(68, 112, 59, 25);
		Search.add(lblEmployeeName);
		
		JLabel lblEmployeePassword = new JLabel("Password:");
		lblEmployeePassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployeePassword.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblEmployeePassword.setBounds(22, 148, 105, 25);
		Search.add(lblEmployeePassword);
		
		JLabel lblDobs = new JLabel("DOB:");
		lblDobs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDobs.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblDobs.setBounds(68, 184, 59, 25);
		Search.add(lblDobs);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblAge.setBounds(68, 220, 59, 25);
		Search.add(lblAge);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalary.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblSalary.setBounds(392, 112, 59, 25);
		Search.add(lblSalary);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartment.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblDepartment.setBounds(346, 148, 105, 25);
		Search.add(lblDepartment);
		
		JLabel lblAddress_2 = new JLabel("Address:");
		lblAddress_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress_2.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblAddress_2.setBounds(356, 184, 95, 25);
		Search.add(lblAddress_2);
		
		textField = new JTextField();
		textField.setBounds(133, 79, 150, 20);
		Search.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 115, 150, 20);
		Search.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 151, 150, 20);
		Search.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(133, 187, 150, 20);
		Search.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(133, 223, 150, 20);
		Search.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(455, 115, 150, 20);
		Search.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(455, 151, 150, 20);
		Search.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(455, 187, 150, 20);
		Search.add(textField_7);
		
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContactNo.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblContactNo.setBounds(346, 76, 105, 25);
		Search.add(lblContactNo);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(455, 79, 150, 20);
		Search.add(textField_8);
		
		JButton btnUpdateInfo_1 = new JButton("Update Info");
		btnUpdateInfo_1.setBounds(277, 294, 150, 33);
		Search.add(btnUpdateInfo_1);
		
		
		UpdateUrInfo = new JPanel();
		UpdateUrInfo.setBackground(new Color(220, 20, 60));
		ParentPanel.add(UpdateUrInfo, "name_16071268438290");
		UpdateUrInfo.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 804, 53);
		panel_4.setBackground(Color.GRAY);
		UpdateUrInfo.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblStudentDataModification = new JLabel("Student Data Modification");
		lblStudentDataModification.setBounds(0, 0, 804, 53);
		lblStudentDataModification.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentDataModification.setForeground(Color.WHITE);
		lblStudentDataModification.setFont(new Font("Eras Medium ITC", Font.BOLD, 35));
		panel_4.add(lblStudentDataModification);
		
		JLabel lblNoteSelectThe = new JLabel("Note:- First Select the Student Data from the Databases that you wanted to Modify");
		lblNoteSelectThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoteSelectThe.setForeground(new Color(255, 255, 0));
		lblNoteSelectThe.setFont(new Font("Eras Medium ITC", Font.BOLD, 18));
		lblNoteSelectThe.setBounds(0, 54, 804, 38);
		UpdateUrInfo.add(lblNoteSelectThe);
		
		JLabel lblStudent = new JLabel("StudentId:");
		lblStudent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudent.setForeground(new Color(0, 0, 0));
		lblStudent.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblStudent.setBounds(48, 103, 113, 26);
		UpdateUrInfo.add(lblStudent);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_1.setForeground(Color.BLACK);
		lblName_1.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblName_1.setBounds(48, 140, 113, 26);
		UpdateUrInfo.add(lblName_1);
		
		JLabel lblSurname_1 = new JLabel("Surname:");
		lblSurname_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname_1.setForeground(Color.BLACK);
		lblSurname_1.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblSurname_1.setBounds(48, 177, 113, 26);
		UpdateUrInfo.add(lblSurname_1);
		
		JLabel lblClass_1 = new JLabel("Class:");
		lblClass_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClass_1.setForeground(Color.BLACK);
		lblClass_1.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblClass_1.setBounds(48, 208, 113, 26);
		UpdateUrInfo.add(lblClass_1);
		
		JLabel lblParentname_1 = new JLabel("ParentName:");
		lblParentname_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParentname_1.setForeground(Color.BLACK);
		lblParentname_1.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblParentname_1.setBounds(48, 243, 113, 26);
		UpdateUrInfo.add(lblParentname_1);
		
		JLabel lblAddress_1 = new JLabel("Address:");
		lblAddress_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress_1.setForeground(Color.BLACK);
		lblAddress_1.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblAddress_1.setBounds(48, 278, 113, 26);
		UpdateUrInfo.add(lblAddress_1);
		
		JLabel lblAccountno_1 = new JLabel("AccountNo:");
		lblAccountno_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccountno_1.setForeground(Color.BLACK);
		lblAccountno_1.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblAccountno_1.setBounds(450, 103, 113, 26);
		UpdateUrInfo.add(lblAccountno_1);
		
		JLabel lblContactno_1 = new JLabel("ContactNo:");
		lblContactno_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContactno_1.setForeground(Color.BLACK);
		lblContactno_1.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblContactno_1.setBounds(450, 140, 113, 26);
		UpdateUrInfo.add(lblContactno_1);
		
		JLabel lblFeestatus_1 = new JLabel("FeeStatus:");
		lblFeestatus_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFeestatus_1.setForeground(Color.BLACK);
		lblFeestatus_1.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblFeestatus_1.setBounds(450, 177, 113, 26);
		UpdateUrInfo.add(lblFeestatus_1);
		
		JLabel lblDateofbirth_1 = new JLabel("Grade:");
		lblDateofbirth_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateofbirth_1.setForeground(Color.BLACK);
		lblDateofbirth_1.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblDateofbirth_1.setBounds(450, 208, 113, 26);
		UpdateUrInfo.add(lblDateofbirth_1);
		
		JLabel lblDateofbirth_2 = new JLabel("DateOfBirth:");
		lblDateofbirth_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateofbirth_2.setForeground(Color.BLACK);
		lblDateofbirth_2.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblDateofbirth_2.setBounds(450, 243, 113, 26);
		UpdateUrInfo.add(lblDateofbirth_2);
		
		JLabel lblBloodgroup_1 = new JLabel("BloodGroup:");
		lblBloodgroup_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBloodgroup_1.setForeground(Color.BLACK);
		lblBloodgroup_1.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblBloodgroup_1.setBounds(450, 278, 113, 26);
		UpdateUrInfo.add(lblBloodgroup_1);
		
		ShowStudentIdField = new JTextField();
		ShowStudentIdField.setBounds(169, 106, 175, 22);
		UpdateUrInfo.add(ShowStudentIdField);
		ShowStudentIdField.setColumns(10);
		
		ShowNameField = new JTextField();
		ShowNameField.setColumns(10);
		ShowNameField.setBounds(169, 140, 175, 22);
		UpdateUrInfo.add(ShowNameField);
		
		ShowSurnameField = new JTextField();
		ShowSurnameField.setColumns(10);
		ShowSurnameField.setBounds(169, 176, 175, 22);
		UpdateUrInfo.add(ShowSurnameField);
		
		ShowParentNameField = new JTextField();
		ShowParentNameField.setColumns(10);
		ShowParentNameField.setBounds(169, 246, 175, 22);
		UpdateUrInfo.add(ShowParentNameField);
		
		ShowAddressField = new JTextField();
		ShowAddressField.setColumns(10);
		ShowAddressField.setBounds(169, 281, 175, 22);
		UpdateUrInfo.add(ShowAddressField);
		
		ShowAccountNoField = new JTextField();
		ShowAccountNoField.setColumns(10);
		ShowAccountNoField.setBounds(573, 107, 175, 22);
		UpdateUrInfo.add(ShowAccountNoField);
		
		ShowContactNoField = new JTextField();
		ShowContactNoField.setColumns(10);
		ShowContactNoField.setBounds(573, 144, 175, 22);
		UpdateUrInfo.add(ShowContactNoField);
		
		ShowFeeStatusField = new JTextField();
		ShowFeeStatusField.setColumns(10);
		ShowFeeStatusField.setBounds(573, 180, 175, 22);
		UpdateUrInfo.add(ShowFeeStatusField);
		
		ShowGradeField = new JTextField();
		ShowGradeField.setColumns(10);
		ShowGradeField.setBounds(573, 213, 175, 22);
		UpdateUrInfo.add(ShowGradeField);
		
		ShowDateOfBirthField = new JTextField();
		ShowDateOfBirthField.setColumns(10);
		ShowDateOfBirthField.setBounds(573, 247, 175, 22);
		UpdateUrInfo.add(ShowDateOfBirthField);
		
		ShowBloodGroupField = new JTextField();
		ShowBloodGroupField.setColumns(10);
		ShowBloodGroupField.setBounds(573, 282, 175, 22);
		UpdateUrInfo.add(ShowBloodGroupField);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					 String Class1=ShowClassComboBox.getSelectedItem().toString();
					 String temp=ShowStudentIdField.getText();
				     String Q="update  StudentInfo set StudentId=?, Name=?, Address=?, ParentName=?, DOB=?, AccNo=?, ContactNo=?, FeeStatus=?, Grade=?, Class=?, Surname=?, BloodGroup=? where StudentId=?";
				     PreparedStatement pst1=conn.prepareStatement(Q);
				     pst1.setString(2, ShowNameField.getText());
				     pst1.setString(1, ShowStudentIdField.getText());
				     pst1.setString(3, ShowAddressField.getText());
				     pst1.setString(4, ShowParentNameField.getText());
				     pst1.setString(5, ShowDateOfBirthField.getText());
				     pst1.setString(6, ShowAccountNoField.getText());
				     pst1.setString(7, ShowContactNoField.getText());
				     pst1.setString(8, ShowFeeStatusField.getText());
				     pst1.setString(9, ShowGradeField.getText());
				     pst1.setString(10, Class1);
				     pst1.setString(11, ShowSurnameField.getText());
				     pst1.setString(12, ShowBloodGroupField.getText());
				     pst1.setString(13, temp);
				     pst1.execute();
				     JOptionPane.showMessageDialog(null, "Student Data is Updated Successfully");
				     pst1.close();
				     ParentPanel.removeAll();
				     ParentPanel.add(ShowDatabase);
				     ParentPanel.repaint();
				     ParentPanel.revalidate();
				}catch(Exception e6)
				{
					JOptionPane.showMessageDialog(null, e6);
				}
			}
		});
		btnUpdate.setBackground(new Color(154, 205, 50));
		btnUpdate.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		btnUpdate.setBounds(231, 314, 113, 36);
		UpdateUrInfo.add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Eras Medium ITC", Font.BOLD, 20));
		btnCancel.setBackground(new Color(154, 205, 50));
		btnCancel.setBounds(450, 315, 113, 36);
		UpdateUrInfo.add(btnCancel);
		
	    ShowClassComboBox = new JComboBox();
		ShowClassComboBox.setModel(new DefaultComboBoxModel(new String[] {"IstA", "IstB", "IstC", "IIndA", "IIndB", "IIndC", "IIIrdA", "IIIrdB", "IIIrdC", "IVthA", "IVthB", "IVthC", "VthA", "VthB", "VthC", "VIthA", "VIthB", "VIthC", "VIIthA", "VIIthB", "VIIthC", "VIIIthA", "VIIIthB", "VIIIthC", "IXthA", "IXthB", "IXthC", "XthA", "XthB", "XthC", "XIthA", "XIthB", "XIthC", "XIIthA", "XIIthB", "XIIthC"}));
		ShowClassComboBox.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		ShowClassComboBox.setBounds(169, 212, 174, 20);
		UpdateUrInfo.add(ShowClassComboBox);
		
		JPanel AddStudent = new JPanel();
		AddStudent.setBackground(new Color(139, 0, 139));
		ParentPanel.add(AddStudent, "name_18516905204638");
		AddStudent.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(220, 20, 60));
		panel_2.setBounds(0, 0, 804, 53);
		AddStudent.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblRegisterNewStudent = new JLabel("Register New Student");
		lblRegisterNewStudent.setBounds(0, 0, 804, 53);
		panel_2.add(lblRegisterNewStudent);
		lblRegisterNewStudent.setBackground(new Color(220, 20, 60));
		lblRegisterNewStudent.setIcon(new ImageIcon(EmployeeActions.class.getResource("/WindowsBuilder/Resourses/icons8_Add_User_Male_48px.png")));
		lblRegisterNewStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterNewStudent.setFont(new Font("Eras Medium ITC", Font.BOLD, 35));
		
		JLabel StudentId = new JLabel("StudentId:");
		StudentId.setForeground(new Color(255, 255, 255));
		StudentId.setHorizontalAlignment(SwingConstants.RIGHT);
		StudentId.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		StudentId.setBounds(38, 64, 93, 23);
		AddStudent.add(StudentId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblName.setBounds(48, 98, 83, 23);
		AddStudent.add(lblName);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClass.setForeground(Color.WHITE);
		lblClass.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblClass.setBounds(38, 163, 93, 23);
		AddStudent.add(lblClass);
		
		JLabel lblParentname = new JLabel("ParentName:");
		lblParentname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParentname.setForeground(Color.WHITE);
		lblParentname.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblParentname.setBounds(28, 197, 103, 23);
		AddStudent.add(lblParentname);
		
		JLabel lblDateofbirth = new JLabel("DateOfBirth:");
		lblDateofbirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateofbirth.setForeground(Color.WHITE);
		lblDateofbirth.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblDateofbirth.setBounds(414, 197, 103, 23);
		AddStudent.add(lblDateofbirth);
		
		JLabel lblAccountno = new JLabel("AccountNo:");
		lblAccountno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccountno.setForeground(Color.WHITE);
		lblAccountno.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblAccountno.setBounds(424, 64, 93, 23);
		AddStudent.add(lblAccountno);
		
		JLabel lblContactno = new JLabel("ContactNo:");
		lblContactno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContactno.setForeground(Color.WHITE);
		lblContactno.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblContactno.setBounds(424, 98, 93, 23);
		AddStudent.add(lblContactno);
		
		JLabel lblFeestatus = new JLabel("FeeStatus:");
		lblFeestatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFeestatus.setForeground(Color.WHITE);
		lblFeestatus.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblFeestatus.setBounds(424, 132, 93, 23);
		AddStudent.add(lblFeestatus);
		
		JLabel lblGrade = new JLabel("Grade:");
		lblGrade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrade.setForeground(Color.WHITE);
		lblGrade.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblGrade.setBounds(424, 163, 93, 23);
		AddStudent.add(lblGrade);
		
		StudentIdField = new JTextField();
		StudentIdField.setBounds(141, 64, 172, 20);
		AddStudent.add(StudentIdField);
		StudentIdField.setColumns(10);
		
		NameField = new JTextField();
		NameField.setBounds(141, 100, 172, 20);
		AddStudent.add(NameField);
		NameField.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblAddress.setBounds(38, 232, 93, 23);
		AddStudent.add(lblAddress);
		
		ParentNameField = new JTextField();
		ParentNameField.setColumns(10);
		ParentNameField.setBounds(141, 199, 172, 20);
		AddStudent.add(ParentNameField);
		
		AddressField = new JTextField();
		AddressField.setColumns(10);
		AddressField.setBounds(141, 233, 172, 20);
		AddStudent.add(AddressField);
		
		AccountNoField = new JTextField();
		AccountNoField.setColumns(10);
		AccountNoField.setBounds(537, 66, 172, 20);
		AddStudent.add(AccountNoField);
		
		ContactNoField = new JTextField();
		ContactNoField.setColumns(10);
		ContactNoField.setBounds(537, 100, 172, 20);
		AddStudent.add(ContactNoField);
		
		FeeStatusField = new JTextField();
		FeeStatusField.setColumns(10);
		FeeStatusField.setBounds(537, 134, 172, 20);
		AddStudent.add(FeeStatusField);
		
		GradeField = new JTextField();
		GradeField.setColumns(10);
		GradeField.setBounds(537, 165, 172, 20);
		AddStudent.add(GradeField);
		
		DateOfBirthField = new JTextField();
		DateOfBirthField.setColumns(10);
		DateOfBirthField.setBounds(537, 199, 172, 20);
		AddStudent.add(DateOfBirthField);
		
		JComboBox ClassComboBox = new JComboBox();
		ClassComboBox.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		ClassComboBox.setModel(new DefaultComboBoxModel(new String[] {"IstA", "IstB", "IstC", "IIndA", "IIndB", "IIndC", "IIIrdA", "IIIrdB", "IIIrdC", "IVthA", "IVthB", "IVthC", "VthA", "VthB", "VthC", "VIthA", "VIthB", "VIthC", "VIIthA", "VIIthB", "VIIthC", "VIIIthA", "VIIIthB", "VIIIthC", "IXthA", "IXthB", "IXthC", "XthA", "XthB", "XthC", "XIthA", "XIthB", "XIthC", "XIIthA", "XIIthB", "XIIthC"}));
		ClassComboBox.setBounds(141, 164, 172, 20);
		AddStudent.add(ClassComboBox);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 String Class=ClassComboBox.getSelectedItem().toString();
					 JOptionPane.showMessageDialog(null, "The data has been Added to the Database of Class "+Class);
				     String Query="Insert Into  StudentInfo (StudentId, Name, Address, ParentName, DOB, AccNo, ContactNo, FeeStatus, Grade, Class, Surname, BloodGroup) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				     PreparedStatement pst=conn.prepareStatement(Query);
				     pst.setString(2, NameField.getText());
				     pst.setString(1, StudentIdField.getText());
				     pst.setString(3, AddressField.getText());
				     pst.setString(4, ParentNameField.getText());
				     pst.setString(5, DateOfBirthField.getText());
				     pst.setString(6, AccountNoField.getText());
				     pst.setString(7, ContactNoField.getText());
				     pst.setString(8, FeeStatusField.getText());
				     pst.setString(9, GradeField.getText());
				     pst.setString(10, Class);
				     pst.setString(11, SurnameField.getText());
				     pst.setString(12, BloodGroupField.getText());
				     pst.execute();
				     JOptionPane.showMessageDialog(null, "Student Data Registered Successfully");
				     pst.close();
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
				
			}
				
			}
		});
		btnNewButton_1.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(255, 255, 0));
		btnNewButton_1.setBounds(261, 312, 103, 38);
		AddStudent.add(btnNewButton_1);
		
		JButton btnNeButton = new JButton("Cancel");
		btnNeButton.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		btnNeButton.setBackground(new Color(255, 255, 0));
		btnNeButton.setBounds(414, 312, 103, 38);
		AddStudent.add(btnNeButton);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblSurname.setBounds(38, 132, 93, 23);
		AddStudent.add(lblSurname);
		
		SurnameField = new JTextField();
		SurnameField.setColumns(10);
		SurnameField.setBounds(141, 131, 172, 20);
		AddStudent.add(SurnameField);
		
		JLabel lblBloodgroup = new JLabel("BloodGroup:");
		lblBloodgroup.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBloodgroup.setForeground(Color.WHITE);
		lblBloodgroup.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblBloodgroup.setBounds(414, 231, 103, 23);
		AddStudent.add(lblBloodgroup);
		
		BloodGroupField = new JTextField();
		BloodGroupField.setColumns(10);
		BloodGroupField.setBounds(537, 234, 172, 20);
		AddStudent.add(BloodGroupField);
		
		JPanel RemoveStudent = new JPanel();
		RemoveStudent.setBackground(Color.ORANGE);
		ParentPanel.add(RemoveStudent, "name_18615334080342");
		RemoveStudent.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(220, 20, 60));
		panel_3.setBounds(0, 0, 804, 53);
		RemoveStudent.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Students Records");
		lblNewLabel.setFont(new Font("Eras Medium ITC", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 804, 53);
		panel_3.add(lblNewLabel);
		
		JLabel lblEnterTheStudentid = new JLabel("Enter StudentId:");
		lblEnterTheStudentid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterTheStudentid.setForeground(new Color(0, 0, 0));
		lblEnterTheStudentid.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblEnterTheStudentid.setBounds(202, 122, 153, 32);
		RemoveStudent.add(lblEnterTheStudentid);
		
		JLabel lblSelectClass = new JLabel("Select Class:");
		lblSelectClass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelectClass.setForeground(Color.BLACK);
		lblSelectClass.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblSelectClass.setBounds(202, 165, 153, 32);
		RemoveStudent.add(lblSelectClass);
		
		JComboBox SelectClassComboBoxField = new JComboBox();
		SelectClassComboBoxField.setModel(new DefaultComboBoxModel(new String[] {"IstA", "IstB", "IstC", "IIndA", "IIndB", "IIndC", "IIIrdA", "IIIrdB", "IIIrdC", "IVthA", "IVthB", "IVthC", "VthA", "VthB", "VthC", "VIthA", "VIthB", "VIthC", "VIIthA", "VIIthB", "VIIthC", "VIIIthA", "VIIIthB", "VIIIthC", "IXthA", "IXthB", "IXthC", "XthA", "XthB", "XthC", "XIthA", "XIthB", "XIthC", "XIIthA", "XIIthB", "XIIthC"}));
		SelectClassComboBoxField.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		SelectClassComboBoxField.setBounds(367, 169, 172, 25);
		RemoveStudent.add(SelectClassComboBoxField);
		
		EnterStudentIdField = new JTextField();
		EnterStudentIdField.setBounds(365, 127, 172, 25);
		RemoveStudent.add(EnterStudentIdField);
		EnterStudentIdField.setColumns(10);
		
		JRadioButton rdbtnDeleteAllRecords = new JRadioButton("Delete All Records of the above Class");
		rdbtnDeleteAllRecords.setBackground(Color.ORANGE);
		rdbtnDeleteAllRecords.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		rdbtnDeleteAllRecords.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnDeleteAllRecords.setBounds(229, 216, 311, 32);
		RemoveStudent.add(rdbtnDeleteAllRecords);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Query;
					String SelectedClass=SelectClassComboBoxField.getSelectedItem().toString();
					  if(rdbtnDeleteAllRecords.isSelected())
					  {
						Query="Delete from StudentInfo where Class =?";
						PreparedStatement pst=conn.prepareStatement(Query);
						pst.setString(1, SelectedClass);
						pst.execute();
					  }
					  else
					  {
						 Query="Delete from StudentInfo where StudentId=?";
						 PreparedStatement pst=conn.prepareStatement(Query);
						 pst.setString(1, EnterStudentIdField.getText());
						 pst.execute();
					  }
					JOptionPane.showMessageDialog(null,"The Records are Deleted successfully");
				}catch(Exception e3)
				{
					JOptionPane.showMessageDialog(null,e3);
				}
			}
		});
		btnNewButton_2.setBackground(new Color(51, 153, 255));
		btnNewButton_2.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		btnNewButton_2.setBounds(340, 266, 89, 23);
		RemoveStudent.add(btnNewButton_2);
		
		JLabel lblNote = new JLabel("Note:");
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setForeground(Color.BLACK);
		lblNote.setFont(new Font("Eras Medium ITC", Font.BOLD, 15));
		lblNote.setBounds(128, 64, 64, 32);
		RemoveStudent.add(lblNote);
		
		JLabel lblForDeleting = new JLabel("1. For Deleting The Whole Record of the Class Pleare Select The Class and also Select Delete All Records");
		lblForDeleting.setHorizontalAlignment(SwingConstants.LEFT);
		lblForDeleting.setForeground(Color.BLUE);
		lblForDeleting.setFont(new Font("Eras Medium ITC", Font.BOLD, 10));
		lblForDeleting.setBounds(186, 64, 608, 32);
		RemoveStudent.add(lblForDeleting);
		
		JLabel lblForDeleting_1 = new JLabel("2. For Deleting only one Record You Have to Select the Class and Provide the StudentId");
		lblForDeleting_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblForDeleting_1.setForeground(Color.BLUE);
		lblForDeleting_1.setFont(new Font("Eras Medium ITC", Font.BOLD, 10));
		lblForDeleting_1.setBounds(186, 92, 608, 32);
		RemoveStudent.add(lblForDeleting_1);
		
		JButton btnNewButton = new JButton("Search In Databases");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParentPanel.removeAll();
				ParentPanel.add(ShowDatabase);
				ParentPanel.repaint();
				ParentPanel.revalidate();
				try {
					     String Query="Select * from IstA";
					     PreparedStatement pst=conn.prepareStatement(Query);
					     ResultSet rs=pst.executeQuery();
					     table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
					
				}
			}
		});
		
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(72, 61, 139));
		btnNewButton.setIcon(new ImageIcon(EmployeeActions.class.getResource("/WindowsBuilder/Resourses/search (1).png")));
		btnNewButton.setFont(new Font("Eras Medium ITC", Font.BOLD, 10));
		btnNewButton.setBounds(0, 52, 180, 52);
		panel.add(btnNewButton);
		
		JButton btnProblems = new JButton("Change Password");
		btnProblems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParentPanel.removeAll();
				ParentPanel.add(Issues);
				ParentPanel.repaint();
				ParentPanel.revalidate();
			}
		});
		btnProblems.setIcon(new ImageIcon(EmployeeActions.class.getResource("/WindowsBuilder/Resourses/icons8_Key_48px.png")));
		btnProblems.setForeground(Color.BLACK);
		btnProblems.setFont(new Font("Eras Medium ITC", Font.BOLD, 10));
		btnProblems.setBackground(new Color(72, 61, 139));
		btnProblems.setBounds(0, 309, 180, 52);
		panel.add(btnProblems);
		
		JButton btnUpdateInfo = new JButton("Update Info");
		btnUpdateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParentPanel.removeAll();
				ParentPanel.add(UpdateUrInfo);
				ParentPanel.repaint();
				ParentPanel.revalidate();
			}
		});
		btnUpdateInfo.setIcon(new ImageIcon(EmployeeActions.class.getResource("/WindowsBuilder/Resourses/icons8_Restart_48px.png")));
		btnUpdateInfo.setForeground(Color.BLACK);
		btnUpdateInfo.setFont(new Font("Eras Medium ITC", Font.BOLD, 10));
		btnUpdateInfo.setBackground(new Color(72, 61, 139));
		btnUpdateInfo.setBounds(0, 155, 180, 52);
		panel.add(btnUpdateInfo);
		
		JButton btnAddnewstudent = new JButton("Add Student");
		btnAddnewstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParentPanel.removeAll();
				ParentPanel.add(AddStudent);
				ParentPanel.repaint();
				ParentPanel.revalidate();
			}
		});
		btnAddnewstudent.setIcon(new ImageIcon(EmployeeActions.class.getResource("/WindowsBuilder/Resourses/icons8_Add_User_Male_48px.png")));
		btnAddnewstudent.setForeground(Color.BLACK);
		btnAddnewstudent.setFont(new Font("Eras Medium ITC", Font.BOLD, 10));
		btnAddnewstudent.setBackground(new Color(72, 61, 139));
		btnAddnewstudent.setBounds(0, 205, 180, 52);
		panel.add(btnAddnewstudent);
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParentPanel.removeAll();
				ParentPanel.add(RemoveStudent);
				ParentPanel.repaint();
				ParentPanel.revalidate();
			}
		});
		btnRemoveStudent.setIcon(new ImageIcon(EmployeeActions.class.getResource("/WindowsBuilder/Resourses/icons8_Denied_48px.png")));
		btnRemoveStudent.setForeground(Color.BLACK);
		btnRemoveStudent.setFont(new Font("Eras Medium ITC", Font.BOLD, 10));
		btnRemoveStudent.setBackground(new Color(72, 61, 139));
		btnRemoveStudent.setBounds(0, 257, 180, 52);
		panel.add(btnRemoveStudent);
		
		JButton btnCheckSalary = new JButton("User Profile");
		btnCheckSalary.setBounds(0, 104, 180, 52);
		panel.add(btnCheckSalary);
		btnCheckSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParentPanel.removeAll();
				ParentPanel.add(Search);
				ParentPanel.repaint();
				ParentPanel.revalidate();
			}
		});
		btnCheckSalary.setIcon(new ImageIcon(EmployeeActions.class.getResource("/WindowsBuilder/Resourses/icons8_Name_Tag_48px.png")));
		btnCheckSalary.setForeground(Color.BLACK);
		btnCheckSalary.setFont(new Font("Eras Medium ITC", Font.BOLD, 10));
		btnCheckSalary.setBackground(new Color(72, 61, 139));
		
	}
}
