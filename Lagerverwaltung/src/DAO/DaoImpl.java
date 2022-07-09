package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

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

	public boolean validateUser(User user) throws SQLException{

		try {
			ps = con.prepareStatement("Select * From Users Where username='" + user.getUsername() + "' AND password ='"
					+ user.getPassword() + "'");
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	

	public void addCustomer(Customer customer) throws SQLException{

		try {
			ps = con.prepareStatement(
					"Insert into customer (customer_name, email, phone, credit_rating, address)values(?,?,?,?,?) ");
			ps.setString(1, customer.getCustomer_name());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getPhone());
			ps.setInt(4, customer.getCredit_rating());
			ps.setString(5, customer.getAddress());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCustomer(Customer customer) throws SQLException{

		try {
			ps = con.prepareStatement(
					"update customer set customer_name=?, email=?, phone=?, credit_rating=?, address=? where customer_id=?");
			ps.setString(1, customer.getCustomer_name());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getPhone());
			ps.setInt(4, customer.getCredit_rating());
			ps.setString(5, customer.getAddress());
			ps.setInt(6, customer.getCustomer_id());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteCustomer(Customer customer)throws SQLException {

		try {
			ps = con.prepareStatement("Delete from customer where customer_id = ?");
			ps.setInt(1, customer.getCustomer_id());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	public void addProduct(Product product) throws SQLException{
		try {
			InputStream picture = new FileInputStream(new File(ProductController.s));
			ps = con.prepareStatement(
					"Insert into product (product_name, purchase_price, selling_price, quantity, description, picture)values(?,?,?,?,?,?) ");
			ps.setString(1, product.getProduct_name());
			ps.setDouble(2, product.getPurchase_price());
			ps.setDouble(3, product.getSelling_price());
			ps.setInt(4, product.getQuantity());
			ps.setString(5, product.getDecription());
			ps.setBlob(6, picture);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateProduct(Product product) throws SQLException{
		try {
			ps = con.prepareStatement(
					"update product set product_name=?, purchase_price=?, selling_price=?, description=?, quantity=? where product_id=?");
			ps.setString(1, product.getProduct_name());
			ps.setDouble(2, product.getPurchase_price());
			ps.setDouble(3, product.getSelling_price());
			ps.setString(4, product.getDecription());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, product.getProduct_id());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProduct(Product product) throws SQLException{
		try {
			ps = con.prepareStatement("Delete from product where product_id = ?");
			ps.setInt(1, product.getProduct_id());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Product> getAllProducts() throws SQLException { // Event event im Konstruktor


		try {
			
			ArrayList<Product> ret = new ArrayList<Product>();
			ps = con.prepareStatement("SELECT * FROM Product ORDER BY productid ASC");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("productid");
				String productName = rs.getString("product_name");
				double purchasePrice = rs.getDouble("purchase_price");
				double sellingPrice = rs.getDouble("selling_price");
				int quantity = rs.getInt("quantity");
				String description = rs.getString("description");
				byte[] picture = rs.getBytes("picture");
				Product p = new Product(productId, productName, purchasePrice, sellingPrice, quantity, description, picture);
				ret.add(p);

			}
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	return null;
	}

     	public ArrayList<Customer> getAllCustomers() throws SQLException {

		try {
			
			ArrayList<Customer> ret = new ArrayList<Customer>();
			ps = con.prepareStatement("SELECT * FROM Customer ORDER BY customer_id ASC");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int customer_id = rs.getInt("customer_id");
				String customer_name = rs.getString("customer_name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				int credit_rating = rs.getInt("credit_rating");
				String address = rs.getString("address");
				Customer c = new Customer(customer_id, customer_name, email, phone, credit_rating, address);
				ret.add(c);

			}
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
      

      public ArrayList<Product> getProductsInStock() throws SQLException { // Event event im Konstruktor

		try {
			
			ArrayList<Product> ret = new ArrayList<Product>();
			ps = con.prepareStatement("SELECT * FROM Product ORDER BY product_id ASC");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int product_id = rs.getInt("product_id");
				String product_name = rs.getString("product_name");
				double purchase_price = rs.getDouble("purchase_price");
				double selling_price = rs.getDouble("selling_price");
				int quantity = rs.getInt("quantity");
				Product p = new Product(product_id, product_name, purchase_price, selling_price, quantity);
				ret.add(p);

			}
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
