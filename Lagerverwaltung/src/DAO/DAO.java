package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Model.Customer;
import Model.Product;
import Model.User;

public interface DAO {
	
	
	public boolean validateUser(User user)throws SQLException;

	public boolean checkCustomerDuplicate(Customer customer)throws SQLException;
	
	public void addCustomer(Customer customer)throws SQLException;
	
	public void updateCustomer(Customer customer)throws SQLException;
	
	public void deleteCustomer(Customer customer)throws SQLException;
	
	public void addProduct(Product product)throws SQLException;
	
	public void updateProduct(Product product)throws SQLException;
	
	public void deleteProduct(Product product)throws SQLException;

	public ArrayList<Product> getAllProducts() throws SQLException;
	
	
	
	
	
	

}
