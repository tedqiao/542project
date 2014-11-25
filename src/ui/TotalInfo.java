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

import vo.Market;
import factory.DAOFactory;

public class TotalInfo extends JPanel {
		private static int i=1;
		private JLabel preinde,prevar,precap;
		//private String index;
		private JScrollPane event;
		private Market m;
		//TotalInfo total;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public TotalInfo() throws Exception {
		//this.index=index;
		setBackground(Color.BLACK);
		setLayout(null);
		//DAOFactory.getIMarketDAOInstance().getMarket().getMarketIndex();
		//DAOFactory.getIMarketDAOInstance().getMarket().getOverallCapital();
		m=DAOFactory.getIMarketDAOInstance().getMarket();
		
		JLabel lblTotal = new JLabel("total");
		lblTotal.setBackground(Color.BLACK);
		lblTotal.setBounds(0, 0, 107, 55);
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTotal.setForeground(Color.BLUE);
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 46));
		add(lblTotal);
		System.out.println(" "+i);
		JLabel lblNewLabel = new JLabel(m.getMarketIndex()+""+i);
		lblNewLabel.setBounds(6, 87, 69, 38);
		lblNewLabel.setForeground(Color.YELLOW);
		add(lblNewLabel);
		preinde = lblNewLabel;
		
		JLabel lblNewLabel_1 = new JLabel(m.getVariationRange()+"");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(172, 87, 118, 38);
		add(lblNewLabel_1);
		prevar = lblNewLabel_1;
		JLabel lblNewLabel_2 = new JLabel(m.getOverallCapital()+"");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setBounds(335, 87, 69, 38);
		add(lblNewLabel_2);
		precap = lblNewLabel_2;
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLUE);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(109, 6, 200, 42);
		textArea.setText("jin tian shi ge hao ri zi a!!!!!!!\nasdfsadfsadfdsafasdfasdfsadfasdfasdfsadfsa\ndfsadfadsfasdfasdfasdfasdfadsf");
		//textArea.is();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(109, 13, 394, 73);
		add(scroll);
		event=scroll;
		//i++;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i = i+1;
				System.out.println(" "+i);
				remove(preinde);
				remove(prevar);
				remove(precap);
				remove(event);
				try {
					m=DAOFactory.getIMarketDAOInstance().getMarket();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JLabel lblNewLabel1 = new JLabel(m.getMarketIndex()+""+i);
				lblNewLabel1.setForeground(Color.YELLOW);
				lblNewLabel1.setBounds(6, 87, 69, 38);
				add(lblNewLabel1, BorderLayout.WEST);
				preinde=lblNewLabel1;
				JLabel lblNewLabel_1 = new JLabel(m.getVariationRange()+""+i);
				lblNewLabel_1.setForeground(Color.YELLOW);
				lblNewLabel_1.setBounds(172, 87, 118, 38);
				add(lblNewLabel_1);
				prevar = lblNewLabel_1;
				JLabel lblNewLabel_2 = new JLabel(m.getOverallCapital()+""+i);
				lblNewLabel_2.setForeground(Color.YELLOW);
				lblNewLabel_2.setBounds(335, 87, 69, 38);
				add(lblNewLabel_2);
				precap = lblNewLabel_2;
				JTextArea textArea = new JTextArea();
				textArea.setForeground(Color.BLUE);
				textArea.setBackground(Color.LIGHT_GRAY);
				textArea.setBounds(109, 6, 200, 42);
				textArea.setText("jin tian shi ge hao ri f");
				//textArea.is();
				JScrollPane scroll = new JScrollPane(textArea);
				scroll.setBounds(109, 13, 394, 73);
				add(scroll);
				event=scroll;
				//repaint();
				//removeAll();
				updateUI();
				
			}
		});
		

	}
	void updata() throws Exception{
		i = i+1;
		System.out.println(" "+i);
		remove(preinde);
		remove(prevar);
		remove(precap);
		remove(event);
		m=DAOFactory.getIMarketDAOInstance().getMarket();
		JLabel lblNewLabel1 = new JLabel(m.getMarketIndex()+""+i);
		lblNewLabel1.setForeground(Color.YELLOW);
		lblNewLabel1.setBounds(6, 87, 69, 38);
		add(lblNewLabel1, BorderLayout.WEST);
		preinde=lblNewLabel1;
		JLabel lblNewLabel_1 = new JLabel(m.getVariationRange()+""+i);
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(172, 87, 118, 38);
		add(lblNewLabel_1);
		prevar = lblNewLabel_1;
		JLabel lblNewLabel_2 = new JLabel(m.getOverallCapital()+""+i);
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setBounds(335, 87, 69, 38);
		add(lblNewLabel_2);
		precap = lblNewLabel_2;
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLUE);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(109, 6, 200, 42);
		textArea.setText("jin tian shi ge hao ri f");
		//textArea.is();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(109, 13, 394, 73);
		add(scroll);
		event=scroll;
		
	}
}
