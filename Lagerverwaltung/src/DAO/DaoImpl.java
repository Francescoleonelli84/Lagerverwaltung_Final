package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Controller.ProductController;
import Ds.DsSingleton;
import Model.Customer;
import Model.Product;
import Model.User;
import View.ProductPanel;

public class DaoImpl implements DAO {

	private static final String ProductTable = null;
	Connection con = DsSingleton.getConnection();
	PreparedStatement ps = null;

	public boolean validateUser(User user) {

		try {
			ps = con.prepareStatement("Select * From Users Where username='" + user.getUsername() + "' AND password ='" + user.getPassword() + "'");
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkCustomerDuplicate(Customer customer) {

		try {
			ps = con.prepareStatement("Select * From Customer Where username='" + customer.getCustomer_name() + "'");
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void addCustomer(Customer customer) {
		
		try {
		ps = con.prepareStatement("Insert into customer (customer_name, email, phone, credit_rating, address)values(?,?,?,?,?) ");
		ps.setString(1, customer.getCustomer_name());
		ps.setString(2, customer.getEmail());
		ps.setString(3, customer.getPhone());
		ps.setInt(4, customer.getCredit_rating());
		ps.setString(5, customer.getAddress());	

		ps.executeUpdate();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCustomer(Customer customer) {
		
		try {
			ps = con.prepareStatement("update customer set customer_name=?, email=?, phone=?, credit_rating=?, address=? where customer_id=?");
			ps.setString(1,  customer.getCustomer_name());
			ps.setString(2, customer.getEmail());
			ps.setString(3,customer.getPhone());
			ps.setInt(4, customer.getCredit_rating());
			ps.setString(5, customer.getAddress());
			ps.setInt(6, customer.getCustomer_id());

			ps.executeUpdate();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public void deleteCustomer(Customer customer) {
		
		try {
			ps = con.prepareStatement("Delete from customer where customer_id = ?");
			ps.setInt(1, customer.getCustomer_id());
			ps.executeUpdate();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public boolean checkProductDuplicate(Product product) {

//		try {
//			ps = con.prepareStatement("Select * From product Where product_name='" + product.getProduct_name() + "'");
//			ResultSet rs = ps.executeQuery();
//
//			if (rs != null) {
//				while (rs.next()) {
//					return true;
//				}
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return false;
	}
	
	public void addProduct(Product product) {
		try {
			InputStream picture = new FileInputStream(new File(ProductController.s));
			ps = con.prepareStatement("Insert into product (product_name, purchase_price, selling_price, quantity, description, picture)values(?,?,?,?,?,?) ");
			ps.setString(1, product.getProduct_name());
			ps.setDouble(2, product.getPurchase_price());
			ps.setDouble(3, product.getSelling_price());
			ps.setInt(4, product.getQuantity());
			ps.setString(5, product.getDecription());
			ps.setBlob(6, picture);
			ps.executeUpdate();
			
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
	}
	
	public void updateProduct(Product product) {
		try {
			ps = con.prepareStatement("update product set product_name=?, purchase_price=?, selling_price=?, description=?, quantity=? where product_id=?");
			ps.setString(1,  product.getProduct_name());
			ps.setDouble(2,product.getPurchase_price());
			ps.setDouble(3, product.getSelling_price());
			ps.setString(4, product.getDecription());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, product.getProduct_id());
			
			ps.executeUpdate();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}		
	}
	
	public void deleteProduct(Product product) {
		try {
			ps = con.prepareStatement("Delete from product where product_id = ?");
			ps.setInt(1, product.getProduct_id());
			ps.executeUpdate();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}		
	}

	
	public void productTableUpdate () {
		int c;
	
		try {
			ps = con.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();

			java.sql.ResultSetMetaData rsd = rs.getMetaData();
			c = rsd.getColumnCount();

			DefaultTableModel d = (DefaultTableModel) ProductPanel.ProductTable.getModel();
			d.setRowCount(0);

			while (rs.next()) {
				Vector v2 = new Vector();

				for (int i = 1; i <= c; i++) {

					v2.add(rs.getInt("product_id"));
					v2.add(rs.getString("product_name"));
					v2.add(rs.getString("purchase_price"));
					v2.add(rs.getString("selling_price"));
					v2.add(rs.getInt("quantity"));
					v2.add(rs.getString("description"));
					v2.add(rs.getBytes("picture"));
					
				}
				d.addRow(v2);
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
	

