package DAO;

import java.sql.SQLException;

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

	public void productTableUpdate(Product product);
	
	
	
	
	
	

}
