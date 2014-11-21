package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login_frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_frame frame = new Login_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(152, 150, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(152, 190, 134, 28);
		contentPane.add(passwordField);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(92, 156, 61, 16);
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(92, 196, 61, 16);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("   "+textField.getText());
				System.out.println("   "+passwordField.getText());
				
				newThread t11= new newThread();
		    	Thread t1 = new  Thread(t11);
		    	t1.start();
		    	dispose();
				
			}
		});
		btnNewButton.setBounds(152, 230, 134, 29);
		contentPane.add(btnNewButton);
	}
}
