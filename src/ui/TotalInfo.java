package ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;

public class TotalInfo extends JPanel {
		private static int i=1;
		JLabel pre;
		//TotalInfo total;
	/**
	 * Create the panel.
	 */
	public TotalInfo() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel lblTotal = new JLabel("total");
		lblTotal.setBackground(Color.BLACK);
		lblTotal.setBounds(0, 0, 107, 55);
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTotal.setForeground(Color.BLUE);
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 46));
		add(lblTotal);
		System.out.println(" "+i);
		JLabel lblNewLabel = new JLabel("New label"+i);
		lblNewLabel.setBounds(6, 87, 69, 38);
		lblNewLabel.setForeground(Color.YELLOW);
		add(lblNewLabel);
		pre=lblNewLabel;
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(128, 98, 61, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setBounds(246, 98, 61, 16);
		add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLUE);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(109, 6, 200, 42);
		textArea.setText("jin tian shi ge hao ri zi a!!!!!!!asdfsadfsadfdsafasdfasdfsadfasdfasdfsadfsadfsadfadsfasdfasdfasdfasdfadsf");
		//textArea.is();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(109, 13, 335, 55);
		add(scroll);
		i++;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i = i+1;
				System.out.println(" "+i);
				remove(pre);
				JLabel lblNewLabel = new JLabel("New label"+i);
				lblNewLabel.setForeground(Color.YELLOW);
				lblNewLabel.setBounds(6, 87, 69, 38);
				add(lblNewLabel, BorderLayout.WEST);
				pre=lblNewLabel;
				//repaint();
				//removeAll();
				updateUI();
				
			}
		});
		

	}
	void updata(){
		i = i+1;
		System.out.println(" "+i);
		remove(pre);
		JLabel lblNewLabel = new JLabel("New label"+i);
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(6, 87, 69, 38);
		add(lblNewLabel, BorderLayout.WEST);
		pre=lblNewLabel;
	}
}
