package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JList;

import java.awt.TextArea;
import java.awt.Label;

import javax.swing.JTextPane;

import vo.Stock;
import factory.DAOFactory;

public class UserStock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;
	private final Stock stock;
	public UserStock(final String stockID,final String UserID) throws Exception {
		stock = DAOFactory.getIStockDAOInstance().getStockByID(stockID);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Buy");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Integer.parseInt(textField.getText());
				}catch(Exception e1){
					//e1.
					System.out.println("are you king me?");
					//textArea.append("do not use String!!!!");
					//textPane.setText("are you king me?");
					//break;
					return;
				}
				
					try {
						DAOFactory.getIHoldDAOInstance().buyAmount(UserID, stockID, stock.getPrice_share(),Integer.parseInt(textField.getText()));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						return;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						return;
					}
					System.out.println("buy stock amount  "+UserID+"   "+stockID+"    "+textField.getText());
				
					// TODO Auto-generated catch block
					
				
				
				
			}
		});
		btnNewButton.setBounds(86, 223, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sell");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					Integer.parseInt(textField.getText());
					}catch(Exception e1){
						//e1.
						System.out.println("are you king me?");
						//textArea.append("do not use String!!!!");
						//textPane.setText("are you king me?");
						//break;
						return;
					}
				System.out.println("sell stock"+textField.getText());
			}
		});
		btnNewButton_1.setBounds(259, 223, 117, 29);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(93, 183, 104, 28);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
