package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class User_Frame extends JFrame {

	private JPanel contentPane;

	
	public User_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		UserInformation user = new UserInformation("zhang san","male","123123123",123213123.0);
		user.setBorder(new LineBorder(Color.YELLOW, 1, true));
		user.setBounds(0, 0, 193, 278);
		getContentPane().add(user);
		stockPanel st = new stockPanel();
		st.setBounds(192, 105, 400, 173);
		JScrollPane scroll = new JScrollPane(st);
		scroll.setBounds(192, 105, 400, 173);
		getContentPane().add(scroll);
		total t = new total();
		t.setSize(400, 105);
		t.setLocation(192, 0);
		getContentPane().add(t);
	}

}