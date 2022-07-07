package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Controller.InventoryController;

public class InventoryPanel extends JPanel{
	
	private JPanel Panel;
	private JPanel InventoryPanel;
	private JButton btnHome;
	private JButton btnExit;
	private JButton btnExport2Pdf;
	private JTable StockTable;
	
	
public InventoryPanel(JFrame myFrame) {
		
		setLayout(null);
		
		InventoryPanel = new JPanel();
		InventoryPanel.setBackground(new Color(95, 158, 160));
		InventoryPanel.setBorder(new TitledBorder(null, "Inventory", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		InventoryPanel.setBounds(6, 6, 868, 148);
        add(InventoryPanel);
        InventoryPanel.setLayout(null);
		
		JPanel Panel = new JPanel();
		Panel.setBounds(6, 18, 856, 124);
		InventoryPanel.add(Panel);
		Panel.setLayout(null);
		
		btnHome = new JButton("HOME");
		btnHome.addActionListener(new InventoryController(this, myFrame));
		btnHome.setForeground(new Color(0, 128, 128));
		btnHome.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnHome.setBounds(500, 47, 125, 35);
		Panel.add(btnHome);
		
		btnExit = new JButton("EXIT");
		btnExit.addActionListener(new InventoryController(this, myFrame));
		btnExit.setForeground(new Color(0, 128, 128));
		btnExit.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnExit.setBounds(663, 47, 125, 35);
		Panel.add(btnExit);
		
		btnExport2Pdf = new JButton("Export PDF");
		btnExport2Pdf.addActionListener(new InventoryController(this, myFrame));
		btnExport2Pdf.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnExport2Pdf.setForeground(new Color(0, 128, 128));
		btnExport2Pdf.setBounds(164, 41, 172, 45);
		Panel.add(btnExport2Pdf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 177, 868, 309);
		add(scrollPane);
		
		StockTable = new JTable();
		StockTable.setBackground(new Color(192, 192, 192));
		scrollPane.setViewportView(StockTable);
		
		StockTable.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Product_ID", "Product_Name", "Purchase_Price", "Selling_Price", "Quantity"}));
		
		
		
}
	
	

}
