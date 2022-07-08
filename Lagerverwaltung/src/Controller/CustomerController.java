package Controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.DaoImpl;
import Model.Customer;
import Model.User;
import View.CustomerPanel;
import View.HomePanel;
import View.InventoryPanel;
import View.LoginPanel;

public class CustomerController implements ActionListener{
	
	CustomerPanel customerPanel;
	JFrame drawFrame;
	Customer customer;
	DaoImpl daoImpl = new DaoImpl();
	
	
	public CustomerController(CustomerPanel customerPanel, JFrame drawFrame) {
		this.drawFrame = drawFrame;
		this.customerPanel = customerPanel;
	}

	
	public void customer_table_update() {
		
		
		
	}
	
	public void mouseClicked(MouseEvent e){
		
		DefaultTableModel d1 = (DefaultTableModel) CustomerPanel.CustomerTable.getModel();
		int selectIndex = CustomerPanel.CustomerTable.getSelectedRow();

		CustomerPanel.txtCustomertName.setText(d1.getValueAt(selectIndex, 1).toString());// get the value of column2
		CustomerPanel.txtEmail.setText(d1.getValueAt(selectIndex, 2).toString());
		CustomerPanel.txtPhone.setText(d1.getValueAt(selectIndex, 3).toString());
		CustomerPanel.txtCreditRating.setSelectedItem(d1.getValueAt(selectIndex, 4).toString());
		CustomerPanel.txtAddress.setText(d1.getValueAt(selectIndex, 5).toString());				
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add")) {
			
			String customer_name = CustomerPanel.txtCustomertName.getText();
			String address = CustomerPanel.txtAddress.getText();
			String email = CustomerPanel.txtEmail.getText();
			String phone = CustomerPanel.txtPhone.getText();
			int credit_rating = Integer.parseInt(String.valueOf(CustomerPanel.txtCreditRating.getSelectedItem()));

	
			try {
					Customer customer = new Customer(customer_name, email, phone, credit_rating, address);
					daoImpl.addCustomer(customer);
					JOptionPane.showMessageDialog(null, "Customer added!", "Add Customer", JOptionPane.INFORMATION_MESSAGE);		
			

			}catch (Exception e1) {
				e1.printStackTrace();
						
			}
			
					
		}else if (e.getActionCommand().equals("Update")) {
			
			
			
		}else if (e.getActionCommand().equals("Delete")) {
			
			
			
		} else if (e.getActionCommand().equals("Reset")) {
			
			LoginPanel.txtUsername.setText(null);
			LoginPanel.passInput.setText(null);
			
		} else if (e.getActionCommand().equals("Exit")) {

			int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to exit", "Warning", JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		    }
		}else if(e.getActionCommand().equals("Home")){
			
			drawFrame.getContentPane().removeAll();
			drawFrame.getContentPane().add(new HomePanel(drawFrame));
			drawFrame.setVisible(true);
			
		}
			
	}
	
	
	

}
