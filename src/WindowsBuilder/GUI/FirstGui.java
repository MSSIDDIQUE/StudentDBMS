package WindowsBuilder.GUI;
import javax.swing.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

public class FirstGui {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstGui window = new FirstGui();
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
	public FirstGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(FirstGui.class.getResource("/WindowsBuilder/Resourses/StudentIcon.png")));
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 589, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JFormattedTextField frmtdtxtfldStudentDatabaseManagement = new JFormattedTextField();
		frmtdtxtfldStudentDatabaseManagement.setColumns(1);
		frmtdtxtfldStudentDatabaseManagement.setBounds(0, 0, 573, 60);
		frmtdtxtfldStudentDatabaseManagement.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		frmtdtxtfldStudentDatabaseManagement.setBackground(new Color(127, 255, 0));
		frmtdtxtfldStudentDatabaseManagement.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldStudentDatabaseManagement.setText("Student DataBase Management System");
		frame.getContentPane().add(frmtdtxtfldStudentDatabaseManagement);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBounds(289, 509, 274, 96);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				AdminLogin Al=new AdminLogin();
				Al.frmAdminSection.setVisible(true);
				Al.frmAdminSection.setLocationRelativeTo(null);
			}
		});
		btnAdmin.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnAdmin.setBackground(Color.YELLOW);
		frame.getContentPane().add(btnAdmin);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				EmployeeLogin El=new EmployeeLogin();
				El.frame.setVisible(true);
				El.frame.setLocationRelativeTo(null);
			}
		});
		btnEmployee.setBackground(Color.YELLOW);
		btnEmployee.setBounds(10, 509, 269, 96);
		btnEmployee.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		frame.getContentPane().add(btnEmployee);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(FirstGui.class.getResource("/WindowsBuilder/Resourses/StudentIcon.png")));
		btnNewButton.setBounds(10, 66, 553, 433);
		frame.getContentPane().add(btnNewButton);
	}
}
