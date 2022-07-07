package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import View.CustomerPanel;
import View.HomePanel;
import View.InventoryPanel;
import View.LoginPanel;
import View.ProductPanel;

public class HomeController implements ActionListener{
	
	HomePanel homePanel;
	JFrame drawFrame;
	
	public HomeController(HomePanel homePanel, JFrame drawFrame) {
		this.drawFrame = drawFrame;
		this.homePanel = homePanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Product Management")) {
			drawFrame.getContentPane().removeAll();
			drawFrame.getContentPane().add(new ProductPanel(drawFrame));
			drawFrame.setVisible(true);
			
		} else if (e.getActionCommand().equals("Customer Management")) {
			drawFrame.getContentPane().removeAll();
			drawFrame.getContentPane().add(new CustomerPanel(drawFrame));
			drawFrame.setVisible(true);
			
//		} else if (e.getActionCommand().equals("Order Management")) {
//			drawFrame.getContentPane().removeAll();
//			drawFrame.getContentPane().add(new OrderPanel(drawFrame));
//			drawFrame.setVisible(true);
//			
		}else if(e.getActionCommand().equals("Create Inventory")) {
			drawFrame.getContentPane().removeAll();
			drawFrame.getContentPane().add(new InventoryPanel(drawFrame));
			drawFrame.setVisible(true);
			
		}else if(e.getActionCommand().equals("Exit")) {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to exit", "Warning", JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		}
		}
	}

}
