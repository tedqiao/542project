package ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TotalInfo extends JPanel {
		private static int i=1;
		JLabel pre;
		//TotalInfo total;
	/**
	 * Create the panel.
	 */
	public TotalInfo() {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblTotal = new JLabel("total");
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTotal.setForeground(Color.CYAN);
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 46));
		add(lblTotal, BorderLayout.NORTH);
		System.out.println(" "+i);
		JLabel lblNewLabel = new JLabel("New label"+i);
		lblNewLabel.setForeground(Color.YELLOW);
		add(lblNewLabel, BorderLayout.WEST);
		pre=lblNewLabel;
		i++;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i = i+1;
				System.out.println(" "+i);
				remove(pre);
				JLabel lblNewLabel = new JLabel("New label"+i);
				lblNewLabel.setForeground(Color.YELLOW);
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
		add(lblNewLabel, BorderLayout.WEST);
		pre=lblNewLabel;
	}
	

}
