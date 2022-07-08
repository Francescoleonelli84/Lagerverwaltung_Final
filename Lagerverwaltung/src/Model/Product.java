package Model;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;

import DAO.DAO;
import DAO.DaoImpl;
import View.ProductPanel;

public class Product {

	private String product_name;
	private int product_id;
	private double purchase_price;
	private double selling_price;
	private String decription;
	private int quantity;
	private byte[] product_picture;
	//private Blob product_picture;
	

	public Product() {
	
	}
	

	public Product(String product_name,  double purchase_price, double selling_price, int quantity, String description) {
		this.product_name = product_name;
		this.purchase_price = purchase_price;
		this.selling_price = selling_price;
		this.quantity = quantity;
		this.decription = description;
		
	}

	public Product(int product_id, String product_name,  double purchase_price, double selling_price, int quantity, String description, byte[]product_picture) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.purchase_price = purchase_price;
		this.selling_price = selling_price;
		this.quantity = quantity;
		this.decription = description;
		this.product_picture = product_picture;
	}
	
	

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public double getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(double purchase_price) {
		this.purchase_price = purchase_price;
	}

	public double getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(double selling_price) {
		this.selling_price = selling_price;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public byte[] getProduct_picture() {
		return product_picture;
	}


	public void setProduct_picture(byte[] product_picture) {
		this.product_picture = product_picture;
	}

	
	

	@Override
	public String toString() {
		return "Product [product_name=" + product_name + ", product_id=" + product_id + ", purchase_price="
				+ purchase_price + ", selling_price=" + selling_price + ", decription=" + decription + ", quantity="
				+ quantity + ", product_picture=" + product_picture + "]";
	}
	
	
	
	
	
}