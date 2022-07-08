package Model;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.DaoImpl;
import View.ProductPanel;

public class ProductTableModel extends JComponent {
	
	
	ProductPanel view;
	ArrayList<Product> allProducts;
	

	public ProductTableModel(ProductPanel productPanel) {
		view  = productPanel;
		DaoImpl dao = new DaoImpl();
		try {
			allProducts = dao.getAllProducts();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public JScrollPane addTable() {
		
		String data[][] = new String[allProducts.size()][7];
		String column[] = { "Product_ID", "Product_Name", "Purchase_Price", "Selling_Price", "Quantity", "Description", "Picture" };
		
		for (int i = 0; i < allProducts.size(); i++) {
//			// ID in data
			data[i][0] = String.valueOf(allProducts.get(i).getProduct_id());
			// Name in data	
			data[i][1] = allProducts.get(i).getProduct_name();
			// Purchase Price in data
			data[i][2] = String.valueOf(allProducts.get(i).getPurchase_price());
			// Selling Price in data
			data[i][3] = String.valueOf(allProducts.get(i).getSelling_price());
			// Description in data
			data[i][4] = allProducts.get(i).getDecription();
			// Quantity in data
			data[i][5] = String.valueOf(allProducts.get(i).getQuantity());
			// Picture in data
			data[i][6] = String.valueOf(allProducts.get(i).getProduct_picture());
		
		}

		JTable jt = new JTable(data, column);
		jt.setBackground(Color.LIGHT_GRAY);
		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(21, 242, 842, 193);	
		sp.setViewportView(jt);
		return sp;

		
	}
}

