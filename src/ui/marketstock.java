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

import javax.swing.JLabel;

public class marketstock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;
	private final Stock stock;
	private JLabel lblInviladFormat;
	private UserInformation ui;
	
	public marketstock(final String stockID,final String UserID) throws Exception {
		ui = controller.getUi();
		stock = DAOFactory.getIStockDAOInstance().getStockByID(stockID);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
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
					try {
						if(DAOFactory.getIHoldDAOInstance().buyAmount(UserID, stockID, stock.getPrice_share(),Integer.parseInt(textField.getText()))){
						System.out.println("buy stock amount  "+UserID+"   "+stockID+"    "+textField.getText());
						ui.update();
						dispose();
						}else{
							
						}
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						lblInviladFormat.setForeground(Color.red);
						contentPane.updateUI();
						//System.out.println("this is fault");
						return;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						return;
					}

			}
		});
		btnNewButton.setBounds(36, 143, 117, 29);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(37, 103, 104, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(stock.getSid());
		lblNewLabel.setBounds(36, 39, 238, 54);
		contentPane.add(lblNewLabel);
		
		lblInviladFormat = new JLabel("invilad format");
		lblInviladFormat.setForeground(Color.LIGHT_GRAY);
		lblInviladFormat.setBounds(209, 189, 117, 16);
		
		contentPane.add(lblInviladFormat);
	}
}