package WindowsBuilder.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrationForm {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm window = new RegistrationForm();
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
	public RegistrationForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 415, 548);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 399, 37);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setBounds(0, 0, 399, 37);
		panel.add(lblRegistration);
		lblRegistration.setForeground(new Color(0, 0, 128));
		lblRegistration.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 99, 71));
		panel_1.setBounds(0, 39, 399, 482);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Employee"}));
		comboBox.setBounds(202, 42, 111, 20);
		panel_1.add(comboBox);
		
		JLabel lblRegisterAs = new JLabel("Register as:");
		lblRegisterAs.setBounds(60, 30, 132, 36);
		lblRegisterAs.setForeground(new Color(0, 255, 0));
		panel_1.add(lblRegisterAs);
		lblRegisterAs.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblRegisterAs.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
