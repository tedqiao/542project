package ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class TotalInfo extends JPanel {

	/**
	 * Create the panel.
	 */
	public TotalInfo() {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblTotal = new JLabel("total");
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTotal.setForeground(Color.YELLOW);
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 46));
		add(lblTotal, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.YELLOW);
		add(lblNewLabel, BorderLayout.WEST);

	}

}
