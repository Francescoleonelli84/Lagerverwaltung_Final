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
import View.InventoryPanel;
import View.ProductPanel;

public class InventoryTableModel extends DefaultTableModel {
	
	
	InventoryPanel view;
	ArrayList<Product> productsInStock;
	

      public InventoryTableModel(InventoryPanel inventoryPanel) {

		view  = inventoryPanel;
		DaoImpl dao = new DaoImpl();
		try {
			productsInStock = dao.getProductsInStock();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public JScrollPane addTable() {
		
		String data[][] = new String[productsInStock.size()][5];
		String column[] = { "Product_ID", "Product_Name", "Purchase_Price", "Selling_Price", "Quantity" };
		
		for (int i = 0; i < productsInStock.size(); i++) {
			// ID in data
			data[i][0] = String.valueOf(productsInStock.get(i).getProduct_id());
			// Name in data	
			data[i][1] = productsInStock.get(i).getProduct_name();
			// Purchase Price in data
			data[i][2] = String.valueOf(productsInStock.get(i).getPurchase_price());
			// Selling Price in data
			data[i][3] = String.valueOf(productsInStock.get(i).getSelling_price());
			// Quantity in data
			data[i][4] = String.valueOf(productsInStock.get(i).getQuantity());
		
		}

		JTable jt = new JTable(data, column);
		jt.setBackground(Color.LIGHT_GRAY);
		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(21, 242, 842, 193);	
		sp.setViewportView(jt);
		return sp;

		
	}

	

}

