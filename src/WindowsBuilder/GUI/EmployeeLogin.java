package WindowsBuilder.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EmployeeLogin {

	public JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeLogin window = new EmployeeLogin();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connect=null;
	private JPasswordField passwordField;
	public EmployeeLogin() {
	initialize();
	connect=WindowsBuilder.Backend.EmployeeDBConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frame.setTitle("Admin Section");
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLogin.class.getResource("/WindowsBuilder/Resourses/StudentIcon.png")));
		frame.setBounds(100, 100, 428, 276);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setToolTipText("Admin Login Page");
		panel.setForeground(SystemColor.desktop);
		panel.setBounds(0, 0, 434, 38);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAdminLoginSection = new JLabel("Employee Login Section");
		lblAdminLoginSection.setBackground(new Color(147, 112, 219));
		lblAdminLoginSection.setForeground(new Color(139, 0, 139));
		lblAdminLoginSection.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblAdminLoginSection.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLoginSection.setBounds(0, 0, 412, 38);
		panel.add(lblAdminLoginSection);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 255, 47));
		panel_1.setBounds(0, 38, 413, 199);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(173, 77, 71, 22);
		lblNewLabel_1.setForeground(new Color(148, 0, 211));
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setBounds(163, 32, 80, 22);
		lblNewLabel.setForeground(new Color(148, 0, 211));
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setSelectedIcon(new ImageIcon(AdminLogin.class.getResource("/WindowsBuilder/Resourses/LoginIcon.jpg")));
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setBounds(224, 112, 80, 24);
		panel_1.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 77, 146, 20);
		panel_1.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(248, 32, 146, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String Query="select * from EmployeeData where EID=? and password=? ";
					PreparedStatement pst=connect.prepareStatement(Query);		
					pst.setString(1,textField.getText());
					pst.setString(2,passwordField.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next())
					{
						count+=1;
					}
					if(count==1)
					{
						  frame.dispose();
						  EmployeeActions sr=new EmployeeActions();
						  sr.frame.setVisible(true);
						  sr.frame.setLocationRelativeTo(null);
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null,"More than one data Found");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "The username and Password is incorrect");
						textField.setText("");
						passwordField.setText("");
					}
					rs.close();
					pst.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AdminLogin.class.getResource("/WindowsBuilder/Resourses/images.jpg")));
		lblNewLabel_2.setBounds(9, 10, 138, 179);
		panel_1.add(lblNewLabel_2);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
                frame.dispose();
				FirstGui fg=new FirstGui();
				fg.frame.setVisible(true);
				fg.frame.setLocationRelativeTo(null);
			}
		});
		btnCancel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnCancel.setBackground(new Color(220, 20, 60));
		btnCancel.setBounds(314, 112, 80, 24);
		panel_1.add(btnCancel);
		
		JLabel lblRegisterAsA = new JLabel("Register as a Employee");
		lblRegisterAsA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				RegistrationForm Ar=new RegistrationForm();
				frame.dispose();
				Ar.frame.setVisible(true);
				Ar.frame.setLocationRelativeTo(null);
			}
		});
		lblRegisterAsA.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterAsA.setForeground(new Color(255, 0, 0));
		lblRegisterAsA.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblRegisterAsA.setBounds(217, 155, 177, 22);
		panel_1.add(lblRegisterAsA);
	}
}
