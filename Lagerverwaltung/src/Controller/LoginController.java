package Controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.DaoImpl;
import Model.User;
import View.HomePanel;
import View.LoginPanel;

public class LoginController implements ActionListener{
	
	LoginPanel loginPanel;
	JFrame drawFrame;
	User user;
	DaoImpl daoImpl = new DaoImpl();
	
	public LoginController() {
		user = new User();
	}
	
	public LoginController(LoginPanel loginPanel, JFrame drawFrame) {
		this.drawFrame = drawFrame;
		this.loginPanel = loginPanel;
	}
	
	public boolean loginUser(User user) {
		
		try {
			if(daoImpl.validateUser(user)) {
				
				drawFrame.getContentPane().removeAll();
				drawFrame.setPreferredSize(new Dimension(880, 520));
				drawFrame.getContentPane().add(new HomePanel(drawFrame));
				drawFrame.pack();
				drawFrame.setVisible(true);
				JOptionPane.showMessageDialog(null, "Login successfully!", "Login done", JOptionPane.INFORMATION_MESSAGE);
				return true;
				
			}else {
				JOptionPane.showMessageDialog(null, "Invadid login datails ", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}catch (Exception e1) {
			e1.printStackTrace();
					
		}
		return false;
				
	}
		
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Login")) {
			
			String username = loginPanel.txtUsername.getText();
			String password = String.valueOf(loginPanel.passInput.getPassword());
			
			User user = new User(username, password);
			loginUser(user);
			
		} else if (e.getActionCommand().equals("Reset")) {
			
			LoginPanel.txtUsername.setText(null);
			LoginPanel.passInput.setText(null);
			
		} else if (e.getActionCommand().equals("Exit")) {

			int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to exit", "Warning", JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		   }
		}
	}

}
