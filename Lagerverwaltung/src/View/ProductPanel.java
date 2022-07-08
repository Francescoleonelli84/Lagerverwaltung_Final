package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import Controller.ProductController;
import DAO.DaoImpl;
import Model.ProductTableModel;

public class ProductPanel extends JPanel{
	
	private JPanel ProductPanel;
	private JPanel Panel;
	private JLabel lblProductName;
	private JLabel lblPurchasePrice;
	private JLabel lblSellingPrice;
	private JLabel lblDescription;
	private JLabel lblQuantity;
	private static JLabel lblProductPicture;
	public static JTextField txtProductName;
	public static JTextField txtPurchasePrice;
	public static JTextField txtSellingPrice;
	public static JTextField txtQuantity;
	public static JTextArea txtDescription;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnHome;
	private JButton btnExit;
	private JButton btnUploadPicture;
	private JButton btnDisplayPicture;
	public ImageIcon ProductPicture;
	public static JTable ProductTable;
	private JScrollPane scrollPane;
	private DefaultTableModel dt;

	
	public ProductPanel(JFrame myFrame) {
		
		setLayout(null);
		
		ProductPanel = new JPanel();
		ProductPanel.setBackground(new Color(95, 158, 160));
		ProductPanel.setBorder(new TitledBorder(null, "PRODUCT", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ProductPanel.setBounds(22, 6, 565, 222);
		add(ProductPanel);
		ProductPanel.setLayout(null);

		JPanel Panel = new JPanel();
		Panel.setBounds(6, 23, 553, 190);
		ProductPanel.add(Panel);
		Panel.setLayout(null);

		lblProductName = new JLabel("Product_Name");
		lblProductName.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblProductName.setBounds(20, 19, 100, 24);
		Panel.add(lblProductName);

		txtProductName = new JTextField();
		txtProductName.setBounds(117, 18, 113, 26);
		Panel.add(txtProductName);
		txtProductName.setColumns(10);

		lblPurchasePrice = new JLabel("Purchase_Price");
		lblPurchasePrice.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblPurchasePrice.setBounds(253, 19, 100, 24);
		Panel.add(lblPurchasePrice);

		txtPurchasePrice = new JTextField();
		txtPurchasePrice.setColumns(10);
		txtPurchasePrice.setBounds(354, 19, 113, 26);
		Panel.add(txtPurchasePrice);

		lblSellingPrice = new JLabel("Selling_Price");
		lblSellingPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblSellingPrice.setBounds(20, 58, 100, 24);
		Panel.add(lblSellingPrice);

		txtSellingPrice = new JTextField();
		txtSellingPrice.setColumns(10);
		txtSellingPrice.setBounds(117, 57, 113, 26);
		Panel.add(txtSellingPrice);
		
		lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblDescription.setBounds(257, 57, 100, 24);
		Panel.add(lblDescription);
		
		txtDescription = new JTextArea();
		txtDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		txtDescription.setBounds(354, 57, 170, 73);
		Panel.add(txtDescription);


		lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblQuantity.setBounds(20, 106, 100, 24);
		Panel.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(117, 105, 113, 26);
		Panel.add(txtQuantity);

		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnAdd.setForeground(new Color(0, 128, 128));

		btnAdd.addActionListener(new ProductController(this, myFrame));
		btnAdd.setBounds(20, 149, 117, 29);
		Panel.add(btnAdd);

		btnUpdate = new JButton("Edit");
		btnUpdate.setForeground(new Color(0, 128, 128));
		btnUpdate.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnUpdate.addActionListener(new ProductController(this, myFrame));
		btnUpdate.setBounds(168, 149, 117, 29);
		Panel.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(0, 128, 128));
		btnDelete.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnDelete.addActionListener(new ProductController(this, myFrame));
		btnDelete.setBounds(328, 149, 117, 29);
		Panel.add(btnDelete);
		
//		scrollPane = new JScrollPane();
//		scrollPane.setBounds(21, 242, 842, 193);
//		add(scrollPane);
//
//		ProductTable = new JTable();
//		ProductTable.setBackground(Color.LIGHT_GRAY);
//		scrollPane.setViewportView(ProductTable);
//		ProductTable.addMouseListener(new ProductController(this, myFrame));
//		ProductTable.setModel(new DefaultTableModel(new Object[][] {
//
//		}, new String[] { "Product_ID", "Product_Name", "Purchase_Price", "Selling_Price", "Quantity", "Description", "Picture" }));

		
		//add table direct from JTable_Model_Class 

		add(new ProductTableModel(this).addTable());
		
		
		btnHome = new JButton("Home");
		btnHome.addActionListener(new ProductController(this, myFrame));
		btnHome.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnHome.setForeground(new Color(0, 128, 128));
		btnHome.setBounds(613, 447, 117, 29);
		add(btnHome);

		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnExit.setForeground(new Color(0, 128, 128));
		btnExit.addActionListener(new ProductController(this, myFrame));
		btnExit.setBounds(746, 447, 117, 29);
		add(btnExit);

		btnUploadPicture = new JButton("Upload");
		btnUploadPicture.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnUploadPicture.setForeground(new Color(0, 139, 139));
		btnUploadPicture.addActionListener(new ProductController(this, myFrame));
		btnUploadPicture.setBounds(599, 200, 117, 29);
		add(btnUploadPicture);

                lblProductPicture = new JLabel();
		lblProductPicture.setBackground(new Color(192, 192, 192));
		lblProductPicture.setBounds(613, 12, 250, 180);
		ProductPicture = new ImageIcon(new ImageIcon("default_image.png").getImage().getScaledInstance(250, 180, Image.SCALE_SMOOTH));
		lblProductPicture.setIcon(ProductPicture);
		add(lblProductPicture);
		
//		setLblProductPicture(new JLabel());
	//	getLblProductPicture().setBackground(new Color(192, 192, 192));
//		getLblProductPicture().setBounds(613, 12, 250, 180);
//		ProductPicture = new ImageIcon(new ImageIcon("src/default_image.png").getImage().getScaledInstance(250, 180, 
//Image.SCALE_SMOOTH));
	//	getLblProductPicture().setIcon(ProductPicture);
//		add(getLblProductPicture());
		
		btnDisplayPicture = new JButton("Display Picture");
		btnDisplayPicture.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnDisplayPicture.setForeground(new Color(0, 128, 128));
		btnDisplayPicture.addActionListener(new ProductController(this, myFrame));
		btnDisplayPicture.setBounds(728, 200, 135, 29);
		add(btnDisplayPicture);
		
	}


//	public static JLabel getLblProductPicture() {
//		return lblProductPicture;
//	}


//	public void setLblProductPicture(JLabel lblProductPicture) {
//		this.lblProductPicture = lblProductPicture;
//	}


	public DefaultTableModel getDt() {
		return dt;
	}



	
	

}
