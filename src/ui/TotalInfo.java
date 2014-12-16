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

import vo.Events;
import vo.GlobalVo;
import vo.Market;
import factory.DAOFactory;
import factory.TOOLFactory;

public class TotalInfo extends JPanel {
		private static int i=1;
		private JLabel preinde,prevar,precap;
		//private String index;
		private JScrollPane event;
		private Market m;
		private Events events;
		private final int l=55;
		private GlobalVo globalvo;
		//TotalInfo total;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public TotalInfo() throws Exception {
		//this.index=index;
		setBackground(Color.BLACK);
		setLayout(null);
		
		events =  DAOFactory.getIEventsInstance().getRandomEvent();
		globalvo = new GlobalVo();
		//DAOFactory.getIMarketDAOInstance().getMarket().getMarketIndex();
		//DAOFactory.getIMarketDAOInstance().getMarket().getOverallCapital();
		m= DAOFactory.getIMarketDAOInstance().getMarketAfterEvent(events);
		//globalvo.market.getMarketIndex()
		JLabel lblTotal = new JLabel("NASDAQ");
		lblTotal.setBackground(Color.BLACK);
		lblTotal.setBounds(20, 20, 107, 55);
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTotal.setForeground(Color.YELLOW);
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		add(lblTotal);
		System.out.println(" "+i);
		JLabel lblNewLabel = new JLabel("MarketIndex: "+globalvo.market.getMarketIndex()+""+i);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(6, 87, 187, 38);
		lblNewLabel.setForeground(Color.YELLOW);
		add(lblNewLabel);
		preinde = lblNewLabel;
		java.text.DecimalFormat b=new java.text.DecimalFormat("#.0");
		b.format(m.getVariationRange()*100);
		JLabel lblNewLabel_1 = new JLabel(b.format(globalvo.market.getVariationRange()*100)+"%");
		if(m.getVariationRange()>0)
		lblNewLabel_1.setForeground(Color.red);
		else
		lblNewLabel_1.setForeground(Color.green);
		lblNewLabel_1.setBounds(276, 87, 125, 38);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		add(lblNewLabel_1);
		prevar = lblNewLabel_1;
		JLabel lblNewLabel_2 = new JLabel(globalvo.market.getOverallCapital()+"");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setBounds(443, 87, 125, 38);
		add(lblNewLabel_2);
		precap = lblNewLabel_2;
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(Color.LIGHT_GRAY);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(109, 6, 200, 42);
		textArea.setText(TOOLFactory.getstringToolInstance().fullJustify(events.getincident(),l));
		//textArea.is();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(139, 13, 394, 73);
		add(scroll);
		event=scroll;
		
		JLabel lblChange = new JLabel("change");
		lblChange.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblChange.setForeground(Color.YELLOW);
		lblChange.setBounds(205, 93, 61, 26);
		add(lblChange);
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
					events = DAOFactory.getIEventsInstance().getRandomEvent();
					m=DAOFactory.getIMarketDAOInstance().getMarket();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				java.text.DecimalFormat b=new java.text.DecimalFormat("#.0");
				b.format(m.getVariationRange()*100);
				JLabel lblNewLabel1 = new JLabel("MarketIndex: "+globalvo.market.getMarketIndex()+"");
				lblNewLabel1.setForeground(Color.YELLOW);
				lblNewLabel1.setBounds(6, 87, 187, 38);
				lblNewLabel1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
				add(lblNewLabel1, BorderLayout.WEST);
				preinde=lblNewLabel1;
				
				JLabel lblNewLabel_1 = new JLabel(b.format(globalvo.market.getVariationRange()*100)+"%");
				if(m.getVariationRange()>0)
				lblNewLabel_1.setForeground(Color.red);
				else
				lblNewLabel_1.setForeground(Color.green);
				lblNewLabel_1.setBounds(276, 87, 125, 38);
				lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
				add(lblNewLabel_1);
				
				prevar = lblNewLabel_1;
				JLabel lblNewLabel_2 = new JLabel(globalvo.market.getOverallCapital()*100+"%");
				lblNewLabel_2.setForeground(Color.YELLOW);
				lblNewLabel_2.setBounds(413, 87, 125, 38);
				lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
				//add(lblNewLabel_2);
				precap = lblNewLabel_2;
				JTextArea textArea = new JTextArea();
				textArea.setForeground(Color.BLUE);
				textArea.setBackground(Color.LIGHT_GRAY);
				textArea.setBounds(139, 13, 394, 73);
				textArea.setText(TOOLFactory.getstringToolInstance().fullJustify(events.getincident(),l));
				//textArea.is();
				JScrollPane scroll = new JScrollPane(textArea);
				scroll.setBounds(139, 13, 394, 73);
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
		java.text.DecimalFormat b=new java.text.DecimalFormat("#.0");
		b.format(m.getVariationRange()*100);
		System.out.println(" "+i);
		//events = DAOFactory.getIEventsInstance().getRandomEvent();
		remove(preinde);
		remove(prevar);
		remove(precap);
		remove(event);
		m=DAOFactory.getIMarketDAOInstance().getMarketAfterEvent(controller.getEvent());
		JLabel lblNewLabel1 = new JLabel("MarketIndex: "+globalvo.market.getMarketIndex()+"");
		lblNewLabel1.setForeground(Color.YELLOW);
		lblNewLabel1.setBounds(6, 87, 187, 38);
		lblNewLabel1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		add(lblNewLabel1, BorderLayout.WEST);
		preinde=lblNewLabel1;
		
		JLabel lblNewLabel_1 = new JLabel(b.format(globalvo.market.getVariationRange()*100)+"%");
		if(m.getVariationRange()>0)
		lblNewLabel_1.setForeground(Color.red);
		else
		lblNewLabel_1.setForeground(Color.green);
		lblNewLabel_1.setBounds(276, 87, 125, 38);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		add(lblNewLabel_1);
		
		prevar = lblNewLabel_1;
		JLabel lblNewLabel_2 = new JLabel(m.getOverallCapital()+"");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setBounds(443, 87, 125, 38);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		add(lblNewLabel_2);
		precap = lblNewLabel_2;
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(Color.LIGHT_GRAY);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(109, 6, 200, 42);
		textArea.setText(TOOLFactory.getstringToolInstance().fullJustify(controller.getEvent().getincident(),l));
		//textArea.is();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(139, 13, 394, 73);
		add(scroll);
		event=scroll;
		
	}
}
