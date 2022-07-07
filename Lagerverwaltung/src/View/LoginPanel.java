package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Controller.LoginController;

public class LoginPanel extends JPanel {
	
	private JFrame myFrame;
	private JPanel LoginPanel;
	private JPanel LoginPanel1;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblWelcome;
	public static JTextField txtUsername;
	public static JPasswordField passInput;
	private JButton btnLogin;
	private JButton btnExit;
	private JButton btnReset;
	
	
	public LoginPanel(JFrame myFrame) {
		
		setLayout(null);
	
		LoginPanel = new JPanel();
		LoginPanel.setBackground(new Color(95, 158, 160));
		LoginPanel.setBorder(new TitledBorder(null, "LogIn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		LoginPanel.setBounds(220, 127, 410, 234);
		add(LoginPanel);
		LoginPanel.setLayout(null);
		
		LoginPanel1 = new JPanel();
		LoginPanel1.setBounds(9, 19, 393, 207);
		LoginPanel.add(LoginPanel1);
		LoginPanel1.setLayout(null);

		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(0, 128, 128));
		lblUsername.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblUsername.setBounds(76, 52, 80, 16);
		LoginPanel1.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 128, 128));
		lblPassword.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblPassword.setBounds(76, 98, 80, 16);
		LoginPanel1.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(160, 47, 140, 30);
		LoginPanel1.add(txtUsername);
		txtUsername.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnLogin.setForeground(new Color(0, 128, 128));
		btnLogin.addActionListener(new LoginController(this, myFrame));
		btnLogin.setBounds(57, 156, 90, 35);
		LoginPanel1.add(btnLogin);
		
		passInput = new JPasswordField();
		passInput.setBounds(160, 93, 140, 30);
		LoginPanel1.add(passInput);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnReset.setForeground(new Color(0, 128, 128));
		btnReset.addActionListener(new LoginController(this, myFrame));
		btnReset.setBounds(160, 156, 90, 35);
		LoginPanel1.add(btnReset);
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnExit.setForeground(new Color(0, 128, 128));
		btnExit.addActionListener(new LoginController(this, myFrame));
		btnExit.setBounds(262, 156, 90, 35);
		LoginPanel1.add(btnExit);
		
		lblWelcome = new JLabel("Welcome to Warehouse A");
		lblWelcome.setForeground(new Color(95, 158, 160));
		lblWelcome.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		lblWelcome.setBounds(220, 58, 368, 46);
	    add(lblWelcome);
		
		
	}
}
