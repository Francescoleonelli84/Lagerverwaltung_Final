package Controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import DAO.DaoImpl;
import Model.Customer;
import Model.Product;
import View.CustomerPanel;
import View.HomePanel;
import View.LoginPanel;
import View.ProductPanel;

public class ProductController implements ActionListener, MouseListener{
	
	ProductPanel productPanel;
	JFrame drawFrame;
	Product product;
	DaoImpl daoImpl = new DaoImpl();
	public static String s;
	File selectedFile;
	
	public ProductController(ProductPanel productPanel, JFrame drawFrame) {
		this.drawFrame = drawFrame;
		this.productPanel = productPanel;
	}
	
    public void mouseClicked(MouseEvent e){
    	
    	DefaultTableModel d1 = (DefaultTableModel) ProductPanel.ProductTable.getModel();
		int selectIndex = ProductPanel.ProductTable.getSelectedRow();
		ProductPanel.txtProductName.setText(d1.getValueAt(selectIndex, 1).toString());// get the value of column1
		ProductPanel.txtPurchasePrice.setText(d1.getValueAt(selectIndex, 2).toString());// get the value of column2
		ProductPanel.txtSellingPrice.setText(d1.getValueAt(selectIndex, 3).toString());
		ProductPanel.txtQuantity.setText(d1.getValueAt(selectIndex, 4).toString());
		ProductPanel.txtDescription.setText(d1.getValueAt(selectIndex, 5).toString());		
		
	}
    
    
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add")) {
			
			try{
			String product_name = ProductPanel.txtProductName.getText();
			double purchase_price =  Double.parseDouble(ProductPanel.txtPurchasePrice.getText());
			double selling_price =  Double.parseDouble(ProductPanel.txtSellingPrice.getText());
	        int quantity = Integer.parseInt(ProductPanel.txtQuantity.getText());
			String description =  ProductPanel.txtDescription.getText();

                        Product product = new Product(product_name, purchase_price, selling_price, quantity, description);
			daoImpl.addProduct(product);
			JOptionPane.showMessageDialog(null, "Product added!", "Add Product", JOptionPane.INFORMATION_MESSAGE);	
			


			}catch (Exception e1) {
				e1.printStackTrace();
						
			}
			
		}else if (e.getActionCommand().equals("Update")) {
			
			
		}else if (e.getActionCommand().equals("Delete")) {
			
			
			
		} else if (e.getActionCommand().equals("Reset")) {
			
			LoginPanel.txtUsername.setText(null);
			LoginPanel.passInput.setText(null);
			
			
	    }else if (e.getActionCommand().equals("Upload")) {
	    	 JFileChooser fileChooser = new JFileChooser();
	         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
	         fileChooser.addChoosableFileFilter(filter);
	         int result = fileChooser.showSaveDialog(null);
	         if(result == JFileChooser.APPROVE_OPTION){
	             selectedFile = fileChooser.getSelectedFile();
	             String path = selectedFile.getAbsolutePath();
	             ProductPanel.lblProductPicture.setIcon(ResizeImage(path));
	             setS(path);
	              }
	         else if(result == JFileChooser.CANCEL_OPTION){
	             System.out.println("No Data");
	         }
			
			
		}else if (e.getActionCommand().equals("Display Picture")) {
			
			
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	 public ImageIcon ResizeImage(String imgPath){
	        ImageIcon MyImage = new ImageIcon(imgPath);
	        Image img = MyImage.getImage();
	        Image newImage = img.getScaledInstance(ProductPanel.getLblProductPicture().getWidth(), ProductPanel.getLblProductPicture().getHeight(),Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(newImage);
	        return image;
	    }

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	

}
