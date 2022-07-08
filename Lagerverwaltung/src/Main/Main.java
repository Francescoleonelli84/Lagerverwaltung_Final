package Main;

import javax.swing.JFrame;

import View.LoginPanel;
import View.ProductPanel;

public class Main {
	
		public static void main(String[] args) {
			
			
			JFrame drawFrame = new JFrame("Warehouse Management System");
			drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//drawFrame.getContentPane().add(new LoginPanel(drawFrame));
			drawFrame.getContentPane().add(new ProductPanel(drawFrame));
			drawFrame.setResizable(false);
			drawFrame.setLocationRelativeTo(null);
			drawFrame.setSize(880, 520);
			drawFrame.requestFocus();
			drawFrame.setVisible(true);
		}

	}

