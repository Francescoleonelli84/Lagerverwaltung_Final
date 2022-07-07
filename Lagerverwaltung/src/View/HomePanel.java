package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Controller.HomeController;
import Controller.LoginController;

public class HomePanel extends JPanel{
	
	private JFrame myFrame;
	private JPanel HomePanel;
	private JPanel HomePanel1;
	private JButton btnProductManagement;
	private JButton btnCustomerManagement;
	private JButton btnOrderMangement;
	private JButton btnInventory;
	private JButton btnExit;
	
	public HomePanel(JFrame myFrame) {
		
		setLayout(null);
		
		HomePanel = new JPanel();
		HomePanel.setBackground(new Color(95, 158, 160));
		HomePanel.setBorder(new TitledBorder(null, "Warehouse Management System", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		HomePanel.setBounds(118, 75, 650, 314);
		add(HomePanel);
		HomePanel.setLayout(null);
		
		HomePanel1 = new JPanel();
		HomePanel1.setBounds(6, 18, 638, 290);
		HomePanel.add(HomePanel1);
		HomePanel1.setLayout(null);
		
		btnProductManagement = new JButton("Product Management");
		btnProductManagement.setForeground(new Color(0, 128, 128));
		btnProductManagement.addActionListener(new HomeController(this, myFrame));
		btnProductManagement.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnProductManagement.setBounds(70, 60, 226, 63);
		HomePanel1.add(btnProductManagement);
		
		btnCustomerManagement = new JButton("Customer Management");
		btnCustomerManagement.setForeground(new Color(0, 128, 128));
		btnCustomerManagement.addActionListener(new HomeController(this, myFrame));
		btnCustomerManagement.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnCustomerManagement.setBounds(350, 60, 226, 63);
		HomePanel1.add(btnCustomerManagement);
		
		btnOrderMangement = new JButton("Order Management");
		btnOrderMangement.setForeground(new Color(0, 128, 128));
		btnOrderMangement.addActionListener(new HomeController(this, myFrame));
		btnOrderMangement.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnOrderMangement.setBounds(70, 164, 226, 63);
		HomePanel1.add(btnOrderMangement);
		
		btnInventory = new JButton("Create Inventory");
		btnInventory.setForeground(new Color(0, 128, 128));
		btnInventory.addActionListener(new HomeController(this, myFrame));
		btnInventory.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnInventory.setBounds(350, 164, 226, 63);
		HomePanel1.add(btnInventory);
		
		btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(0, 128, 128));
		btnExit.addActionListener(new HomeController(this, myFrame));
		btnExit.setForeground(new Color(0, 128, 128));
		btnExit.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnExit.setBounds(630, 430, 136, 35);
		add(btnExit);
			
		
	}
		
	

}
