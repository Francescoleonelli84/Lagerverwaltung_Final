package Model;



public class Customer {
	
	private int customer_id;
	private String customer_name;
	private String address;
	private String email;
	private String phone;
	private int credit_rating;
	
//	public Customer() {
//		
//	}
	
	public Customer(String customer_name, String email, String phone, int credit_rating, String address) {

		this.customer_name = customer_name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.credit_rating = credit_rating;
	}
	
	public Customer(int customer_id, String customer_name,String email, String phone, int credit_rating, String address) {
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.credit_rating = credit_rating;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCredit_rating() {
		return credit_rating;
	}

	public void setCredit_rating(int credit_rating) {
		this.credit_rating = credit_rating;
	}

	
	

}
