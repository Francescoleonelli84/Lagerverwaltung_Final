package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.CustomerController;
import Controller.LoginController;

public class CustomerPanel extends JPanel {
	
	private JPanel CustomerPanel;
	private JLabel lblCustomerName;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblAddress;
	private JLabel lblCredit_Rating;
	public static JTextField txtCustomertName;
	public static JTextField txtEmail;
	public static JTextField txtPhone;
	public static JTextArea txtAddress;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnHome;
	private JButton btnExit;
	public ImageIcon CustomerLogo;
	public static JTable CustomerTable;
	private JScrollPane scrollPane;
	public static JComboBox txtCreditRating;
	private JButton btnReset;
	private JPanel Panel;

	
	public CustomerPanel(JFrame myFrame) {
		
		setLayout(null);
		
		CustomerPanel = new JPanel();
		CustomerPanel.setBackground(new Color(95, 158, 160));
		CustomerPanel.setBorder(new TitledBorder(null, "CUSTOMER", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		CustomerPanel.setBounds(15, 6, 848, 221);
		add(CustomerPanel);
		CustomerPanel.setLayout(null);
		
		Panel = new JPanel();
		Panel.setBounds(6, 18, 836, 197);
		CustomerPanel.add(Panel);
		Panel.setLayout(null);
		
		lblCustomerName = new JLabel("Customer_Name");
		lblCustomerName.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblCustomerName.setBounds(30, 24, 114, 24);
		Panel.add(lblCustomerName);

		txtCustomertName = new JTextField();
		txtCustomertName.setBounds(145, 23, 151, 26);
		Panel.add(txtCustomertName);
		txtCustomertName.setColumns(10);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblEmail.setBounds(397, 23, 50, 24);
		Panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(470, 23, 151, 26);
		Panel.add(txtEmail);

		lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblPhone.setBounds(30, 65, 100, 24);
		Panel.add(lblPhone);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(145, 64, 151, 26);
		Panel.add(txtPhone);

		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblAddress.setBounds(395, 60, 63, 24);
		Panel.add(lblAddress);

		lblCredit_Rating = new JLabel("Credit_Rating");
		lblCredit_Rating.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblCredit_Rating.setBounds(30, 101, 100, 24);
		Panel.add(lblCredit_Rating);

		txtAddress = new JTextArea();
		txtAddress.setBounds(470, 64, 151, 61);
		Panel.add(txtAddress);

		btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(0, 128, 128));
		btnAdd.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnAdd.addActionListener(new CustomerController(this, myFrame));
		btnAdd.setBounds(30, 151, 117, 29);
		Panel.add(btnAdd);

		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(0, 128, 128));
		btnUpdate.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnUpdate.addActionListener(new CustomerController(this, myFrame));
		btnUpdate.setBounds(184, 151, 117, 29);
		Panel.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(0, 128, 128));
		btnDelete.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnDelete.addActionListener(new CustomerController(this, myFrame));
		btnDelete.setBounds(346, 151, 117, 29);
		Panel.add(btnDelete);
		
		txtCreditRating = new JComboBox();
		txtCreditRating.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		txtCreditRating.setBounds(145, 101, 151, 27);
		Panel.add(txtCreditRating);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new CustomerController(this, myFrame));	
		btnReset.setForeground(new Color(0, 128, 128));
		btnReset.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnReset.setBounds(504, 151, 117, 29);
		Panel.add(btnReset);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 242, 842, 193);
		add(scrollPane);

		CustomerTable = new JTable();	
		//Problem!!!!
//		CustomerTable.addMouseListener(new CustomerController(this, myFrame)); 
		CustomerTable.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(CustomerTable);
		CustomerTable.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Customer_ID", "Customer_Name", "Email", "Phone", "Credit_Rating", "Address"}));

		btnHome = new JButton("Home");
		btnHome.addActionListener(new CustomerController(this, myFrame));
		btnHome.setForeground(new Color(0, 128, 128));
		btnHome.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnHome.setBounds(613, 458, 117, 29);
		add(btnHome);

		btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(0, 128, 128));
		btnExit.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnExit.addActionListener(new CustomerController(this, myFrame));
		btnExit.setBounds(746, 458, 117, 29);
		add(btnExit);	
		
		
	}
	
	

}
