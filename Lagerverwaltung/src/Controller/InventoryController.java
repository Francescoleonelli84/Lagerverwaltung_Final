package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicButtonListener;

import DAO.DaoImpl;
import Model.Customer;
import View.CustomerPanel;
import View.HomePanel;
import View.InventoryPanel;
import View.LoginPanel;

public class InventoryController implements ActionListener{
	
	InventoryPanel inventoryPanel;
	JFrame drawFrame;
	DaoImpl daoImpl = new DaoImpl();
	
	
	public InventoryController (InventoryPanel inventoryPanel, JFrame drawFrame) {
		
		this.drawFrame = drawFrame;
		this.inventoryPanel = inventoryPanel;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Export PDF")) {
				
		} else if (e.getActionCommand().equals("Exit")) {

			int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to exit", "Warning", JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		    }
		}else if(e.getActionCommand().equals("Home")){
			
			drawFrame.getContentPane().removeAll();
			drawFrame.getContentPane().add(new HomePanel(drawFrame));
			drawFrame.setVisible(true);
			
		}
			
	}

}
