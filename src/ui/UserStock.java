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

public class UserStock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;
	
	public UserStock() {
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
				System.out.println("buy stock amount  "+textField.getText());
			}
		});
		btnNewButton.setBounds(86, 223, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sell");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("sell stock");
			}
		});
		btnNewButton_1.setBounds(259, 223, 117, 29);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(93, 183, 104, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(86, 151, 117, 16);
		textPane.setText("are you king me?");
		//textPane.set
		contentPane.add(textPane);
	}
}
